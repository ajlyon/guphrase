guphrase
========
[![Build Status](https://travis-ci.org/ajlyon/guphrase.svg?branch=master)](https://travis-ci.org/ajlyon/guphrase)

Toy utility to represent UUIDs as phrases from an agreed-upon dictionary.

```java
UUID uuid = UUID.randomUUID();
Dictionary dictionary = new WordListResourceDictionary("/354984si.ngl");
String output = GuPhrase.phraseForUUID(uuid, dictionary);
uuid = c6da2d3d-b8c5-49e3-a338-798fae5b3c8b
output = pua-yen-gulfs-wage-glucolysis-doorframe-heynne
```

Or use a morpheme list to make a "word":

```java
UUID uuid = UUID.randomUUID();
Dictionary dictionary = new WordListResourceDictionary("/cogna-sorted.morphemes");
String output = GuPhrase.pseudoWordForUUID(uuid, dictionary);
uuid = 3e9d3cae-1780-4768-aa2f-bf63cd92c030
output = estrorsephosafuciteginotocosmafunctestereocopistigac
```
