package com.gimranov.guphrase;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WordListResourceDictionary implements Dictionary {

    private final List<String> words;

    public WordListResourceDictionary(String name) throws IOException {
        InputStream stream = getClass().getResourceAsStream(name);
        if (stream == null) {
            throw new IllegalArgumentException("Resource not found for " + name);
        }

        words = IOUtils.readLines(stream);
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
