package com.company;

public class Main {

    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'C', 'B');
    }

    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            print(n, from, to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        print(n, from, to);
        towerOfHanoi(n - 1, aux, to, from);
    }

    public static void print(int n, char from, char to) {
        System.out.println("Moving disk " + n + " from rod " + from + " to rod " + to);
    }

}
