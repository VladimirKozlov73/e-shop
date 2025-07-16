package org.skypro.skyshop.search;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final List<Searchable> sources;

    public SearchEngine() {
        sources = new ArrayList<>();
    }

    public void addSearch(Searchable source) {
        sources.add(source);
    }

    public List<Searchable> search(String term) {
        List<Searchable> results = new ArrayList<>();
        String lowerTerm = term.toLowerCase();

        for (Searchable source : sources) {
            if (source != null) {
                String searchTerm = source.getSearchTerm().toLowerCase();
                if (searchTerm.contains(lowerTerm)) {
                    results.add(source);
                }
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()){
            throw new BestResultNotFound("Поисковый запрос не может быть пустым.");
        }
        Searchable result = null;
        int maxCount = 0;
        search = search.toLowerCase();

        for (Searchable unit : sources) {
            if (unit == null) {
                break;
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
