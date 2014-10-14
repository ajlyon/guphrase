package com.gimranov.guphrase;

import java.util.ArrayList;
import java.util.List;

public class ListDictionary implements Dictionary {
    private final List<String> words;

    public ListDictionary(List<String> words) {
        this.words = new ArrayList<String>(words);
    }

    @Override
    public String wordForIndex(long index) {
        return words.get((int) index);
    }

    @Override
    public long size() {
        return words.size();
    }

    @Override
    public long indexForWord(String word) {
        return words.indexOf(word);
    }
}
