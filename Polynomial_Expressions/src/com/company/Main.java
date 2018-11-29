package com.company;

public class Main {

    public static void main(String[] args) {
        Expression expressionA = new Expression(
                new TermNode(5, 4),
                new TermNode(5, 3),
                new TermNode(5, 3),
                new TermNode(-4, 2),
                new TermNode(3, 1)
        );

        Expression expressionB = new Expression(
                new TermNode(1, 3),
                new TermNode(-2, 2),
                new TermNode(3, 1)
        );

        Expression result = new Expression();

        expressionA.print();

        expressionB.print();

        result.add(expressionA, expressionB);

        result.print();



    }
}
