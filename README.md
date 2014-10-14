guphrase
========

Toy utility to represent UUIDs as phrases from an agreed-upon dictionary.

```
UUID uuid = UUID.randomUUID();
Dictionary dictionary = new WordListResourceDictionary("/354984si.ngl");
String output = GuPhrase.phraseForUUID(uuid, dictionary);
uuid = c6da2d3d-b8c5-49e3-a338-798fae5b3c8b
output = pua-yen-gulfs-wage-glucolysis-doorframe-heynne
```