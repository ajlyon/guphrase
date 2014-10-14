package com.gimranov;

import com.gimranov.guphrase.Dictionary;
import com.gimranov.guphrase.GuPhrase;
import com.gimranov.guphrase.ListDictionary;
import com.gimranov.guphrase.WordListResourceDictionary;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.testng.AssertJUnit.assertEquals;

public class GuPhraseTest {
    @Test
    public void testConversion() throws Exception {
        Dictionary dictionary = new ListDictionary(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8"));
        String output = GuPhrase.phraseForUUID(UUID.randomUUID(), dictionary);
        System.out.println(output);
        System.out.println(output.length());
    }

    @Test
    public void testResourceDictionary() throws Exception {
        Dictionary dictionary = new WordListResourceDictionary("/duke-words");
        String output = GuPhrase.phraseForUUID(UUID.randomUUID(), dictionary);
        System.out.println(output);
        System.out.println(output.length());
    }

    @Test
    public void testMoby() throws Exception {
        Dictionary dictionary = new WordListResourceDictionary("/113809of.fic");
        String output = GuPhrase.phraseForUUID(UUID.randomUUID(), dictionary);
        System.out.println(output);
        System.out.println(output.length());
    }

    @Test
    public void testMaxiDict() throws Exception {
        UUID uuid = UUID.randomUUID();
        Dictionary dictionary = new WordListResourceDictionary("/354984si.ngl");
        String output = GuPhrase.phraseForUUID(uuid, dictionary);
        System.out.println(uuid.toString());
        System.out.println(output);
        System.out.println(output.length());

    }

    @Test
    public void testRoundTrip() throws Exception {
        UUID uuid = UUID.randomUUID();
        Dictionary dictionary = new ListDictionary(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8"));
        String output = GuPhrase.phraseForUUID(uuid, dictionary);
        System.out.println(output);
        System.out.println(output.length());

        UUID restored = GuPhrase.uuidForPhrase(output, dictionary);
        assertEquals(uuid, restored);
    }
}
