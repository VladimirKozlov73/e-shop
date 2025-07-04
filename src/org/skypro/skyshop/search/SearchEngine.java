package org.skypro.skyshop.search;
import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {

    private final Searchable[] sources;
    private int counter = 0;

    public SearchEngine(int size) {
        sources = new Searchable[size];
    }

    public void addSearch(Searchable source) {
        if (counter < sources.length) {
            sources[counter++] = source;
        } else {
            System.out.println("Массив заполнен, невозможно добавить элемент");
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int found = 0;
        String lowerTerm = term.toLowerCase();

        for (int i = 0; i < counter && found < results.length; i++) {
            if (sources[i] != null) {
                String searchTerm = sources[i].getSearchTerm().toLowerCase();
                if (searchTerm.contains(lowerTerm)) {
                    results[found++] = sources[i];
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
