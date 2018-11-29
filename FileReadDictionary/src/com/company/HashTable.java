package com.company;

import java.util.LinkedList;

public class HashTable {

    private LinkedList<Dictionary>[] table;

    public HashTable (int size){
        table = new LinkedList [size + (size / 3)]; // table size should be a prime number.
    }

    private int strToInt (String str) {
        int asciiSum = 0;
        char[] letters = str.toCharArray();
        for (char ch : letters) {
            asciiSum += (int) ch;
        }
        return asciiSum;
    }

    private int hash (Dictionary dictionary) {
        return strToInt(dictionary.word) % table.length;
    }

    public void insert (Dictionary dictionary) {
        int index = hash(dictionary);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
            table[index].add(dictionary);
        } else {
            table[index].add(dictionary);
        }
    }

}
