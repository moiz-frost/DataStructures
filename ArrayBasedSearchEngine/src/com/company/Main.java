package com.company;

public class Main {

    public static void main(String[] args) {
        ArrayBasedWordList arrayBasedWordList = new ArrayBasedWordList();
        arrayBasedWordList.insert("ASD", "url1");
        arrayBasedWordList.insert("ASD", "url1");
        arrayBasedWordList.insert("BSD", "url1");
        arrayBasedWordList.insert("bSD", "url1");
        arrayBasedWordList.insert("cSD", "url1");
        arrayBasedWordList.insert("DSD", "url1");

        arrayBasedWordList.print();

        arrayBasedWordList.search("ASD");

    }
}
