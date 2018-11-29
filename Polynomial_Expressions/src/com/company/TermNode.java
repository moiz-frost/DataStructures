package com.company;

public class TermNode {

    int coefficient;
    int exponent;
    TermNode nextTerm;
    TermNode previousTerm;

    public TermNode (int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

}


