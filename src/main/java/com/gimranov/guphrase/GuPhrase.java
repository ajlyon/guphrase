package com.gimranov.guphrase;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.UUID;

public class GuPhrase {
    public static String phraseForUUID(UUID uuid, Dictionary dictionary) {
        BigInteger integer = new BigInteger(uuid.toString().replace("-", ""), 16);

        BigInteger lexicon = BigInteger.valueOf(dictionary.size());

        StringBuilder stringBuilder = new StringBuilder();

        do {
//            System.out.println("i " + integer);
            BigInteger mod = integer.mod(lexicon);
            integer = (integer.subtract(mod).divide(lexicon));
            System.out.println("v " + mod);
            stringBuilder.append(dictionary.wordForIndex(mod.longValue()));
            stringBuilder.append(' ');
        } while (integer.getLowestSetBit() >= 0);

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));

        return stringBuilder.toString();
    }


    public static UUID uuidForPhrase(String phrase, Dictionary dictionary) {
        String[] pieces = phrase.split(" ");

        BigInteger integer = BigInteger.ZERO;
        BigInteger lexicon = BigInteger.valueOf(dictionary.size());

        int power = 0;

        for (String piece : pieces) {
            long value = dictionary.indexForWord(piece);
//            System.out.println("i " + integer);
//            System.out.println("p " + power);
            System.out.println("v " + value);
            integer = integer.add(BigInteger.valueOf(value).multiply(lexicon.pow(power)));
            power++;
        }
        return fromByteArray(integer.toByteArray());
    }

    /**
     * Reconstructs a UUID from a byte array
     *
     * @param bytes The byte array (will be automatically padded left if size < 16)
     * @return The UUID
     */
    public static UUID fromByteArray(byte[] bytes) {
        int usableBytes = Math.min(bytes.length, 16);

        // Need exactly 16 bytes - pad the input if not enough bytes are provided
        // Use provided bytes in the least significant position; if more than 16 bytes are given,
        // then use the first 16 bytes from the array;
        byte[] barr = new byte[16];
        for (int i = 15, j = usableBytes-1; j >= 0; i--, j--)
            barr[i] = bytes[j];

        ByteArrayInputStream bais = new ByteArrayInputStream(barr);
        DataInputStream inputStream = new DataInputStream(bais);

        try {
            long msb = inputStream.readLong();
            long lsb = inputStream.readLong();

            return new UUID(msb, lsb);
        }
        catch (IOException e) {
            // Should never happen
            return null;
        }
    }
}
