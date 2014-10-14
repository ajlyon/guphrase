package com.gimranov.guphrase;

public interface Dictionary {
    public String wordForIndex(long index);

    public long size();

    public long indexForWord(String word);
}
