package org.skypro.skyshop.search;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> sources;

    public SearchEngine() {
        sources = new HashSet<>();
    }

    public void addSearch(Searchable source) {
        sources.add(source);
    }

    public Set<Searchable> search(String term) {
        String lowerTerm = term.toLowerCase();

        return sources.stream()
                .filter(Objects::nonNull)
                .filter(source -> source.getSearchTerm().toLowerCase().contains(lowerTerm))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchTermComparator())));
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound("Поисковый запрос не может быть пустым.");
        }
        Searchable result = null;
        int maxCount = 0;
        search = search.toLowerCase();

        for (Searchable unit : sources) {
            if (unit == null) {
                continue;
            }
            String str = unit.getSearchTerm().toLowerCase();
            int count = 0;
            int index = 0;
            while ((index = str.indexOf(search, index)) != -1) {
                count++;
                index += search.length();
            }
            if (count > maxCount) {
                maxCount = count;
                result = unit;
            }
        }

        if (result == null) {
            throw new BestResultNotFound(search);
        }
        return result;
    }
}
