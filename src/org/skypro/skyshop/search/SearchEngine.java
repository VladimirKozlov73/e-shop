package org.skypro.skyshop.search;

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

        for (int i = 0; i < counter && found < 5; i++) {
            if (sources[i] != null) {
                String searchTerm = sources[i].getSearchTerm().toLowerCase();
                if (searchTerm.contains(lowerTerm)) {
                    results[found++] = sources[i];
                }
            }
        }
        return results;
    }
}
