package com.company;

public class ArrayBasedWordList {

    private WordLinkedList[] array;

    public ArrayBasedWordList() {
        array = new WordLinkedList[27];
    }

    public void insert (String word, String url) {
        int index = getIndexOfWord(word);
        if (array[index] == null) array[index] = new WordLinkedList();
        array[index].insert(word, url);
    }

    public void search (String word) {
        int index = getIndexOfWord(word);
        array[index].find(word);
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i].print();
            }
        }
    }

    private int getIndexOfWord (String word) {
        if (word.isEmpty()) return 0;
        word = word.toLowerCase();
        int index = ((int) word.charAt(0)) - 97;
        return index;
    }

}
