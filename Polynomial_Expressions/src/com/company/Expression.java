package com.company;

import java.text.MessageFormat;

public class Expression {

    TermNode firstTerm;
    TermNode lastTerm;

    public Expression(TermNode... terms) {
        for (TermNode term : terms) {
            TermNode existingTerm = find(term.exponent);
            insertTerm(term.coefficient, term.exponent);
        }
    }

    private void insertTerm(int coefficient, int exponent) {
        TermNode existingTerm = find(exponent);
        if (existingTerm != null) {
            existingTerm.coefficient = existingTerm.coefficient + coefficient;
            return;
        }

        TermNode newTerm = new TermNode(coefficient, exponent);
        TermNode currentTermPointer = firstTerm;

        if (firstTerm == null) {
            firstTerm = newTerm;
            lastTerm = firstTerm;
            return;
        }

        if (exponent >= firstTerm.exponent) {
            newTerm.nextTerm = firstTerm;
            firstTerm.previousTerm = newTerm;
            firstTerm = newTerm;
            return;
        }

        while (currentTermPointer != null) {
            if (currentTermPointer.nextTerm == null) {
                if (currentTermPointer.exponent >= exponent) {
                    currentTermPointer.nextTerm = newTerm;
                    newTerm.previousTerm = currentTermPointer;
                    currentTermPointer = newTerm;
                    lastTerm = newTerm;
                } else {
                    System.out.println(exponent);
                    newTerm.nextTerm = currentTermPointer;
                    currentTermPointer.previousTerm = newTerm;
                    lastTerm = currentTermPointer;
                    if (currentTermPointer == firstTerm) firstTerm = newTerm;
                }
                break;
            }

            if (exponent <= currentTermPointer.exponent && exponent >= currentTermPointer.nextTerm.exponent) {
                currentTermPointer.nextTerm.previousTerm = newTerm;
                newTerm.nextTerm = currentTermPointer.nextTerm;
                newTerm.previousTerm = currentTermPointer;
                currentTermPointer.nextTerm = newTerm;
                break;
            }

            currentTermPointer = currentTermPointer.nextTerm;
        }

    }

    public Expression add(Expression expressionA, Expression expressionB) {
        Expression result = new Expression();
        TermNode expressionAPointer = expressionA.firstTerm;
        TermNode expressionBPointer = expressionB.firstTerm;
        while (expressionAPointer != null) {
            result.insertTerm(expressionAPointer.coefficient, expressionAPointer.exponent);
            expressionAPointer = expressionAPointer.nextTerm;
        }
        while (expressionBPointer != null) {
            result.insertTerm(expressionBPointer.coefficient, expressionBPointer.exponent);
            expressionBPointer = expressionBPointer.nextTerm;
        }

        this.firstTerm = result.firstTerm;
        this.lastTerm = result.lastTerm;

        return result;
    }

    public boolean clear () {
        firstTerm = null;
        lastTerm = null;
        return true;
    }

    public TermNode find (int exponent) {
        TermNode currentPointer = firstTerm;
        while (currentPointer != null) {
            if (currentPointer.exponent == exponent) return currentPointer;
            currentPointer = currentPointer.nextTerm;
        }
        return null;
    }

    public void print () {
        System.out.print("\n");
        TermNode currentTermPointer = firstTerm;
        while (currentTermPointer != null) {
            MessageFormat message = new MessageFormat("{0}e{1} ");
            Object[] args = {
                    currentTermPointer.coefficient,
                    currentTermPointer.exponent
            };
            System.out.print(message.format(args));
            currentTermPointer = currentTermPointer.nextTerm;
        }
        System.out.print("\n");
    }

}
