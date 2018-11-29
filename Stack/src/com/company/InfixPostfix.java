package com.company;

public class InfixPostfix {

    public String infixToPostfix (String expression) {
        LinkedListStack <Character> operatorStack = new LinkedListStack<Character>();
        StringBuilder postfix = new StringBuilder();

        boolean higherPrecedence = false;

        for (int i = 0; i < expression.length(); i++) {

            char currentCharacter = expression.charAt(i);

            if (this.isOperator(currentCharacter)) {

                if (isClosingParanthesis(currentCharacter)) {

                    char topData = operatorStack.getLast() != null ? operatorStack.getLast().data : '0';
                    while (true) {
                        if (isOpeningParanthesis(topData)) {
                            operatorStack.pop();
                            break;
                        } else {
                            postfix.append(operatorStack.pop().data);
                        }
                        topData = operatorStack.getLast() != null ? operatorStack.getLast().data : '0';
                    }

                } else if (isHigherPrecedence(currentCharacter)) {

                    higherPrecedence = true;
                    operatorStack.push(currentCharacter);

                } else if (isLowerPrecedence(currentCharacter) && higherPrecedence) {

                    higherPrecedence = false;
                    for (Node<Character> top = operatorStack.top; !operatorStack.isEmpty(); top = operatorStack.top) {
                        postfix.append(operatorStack.pop().data);
                    }

                } else {
                    operatorStack.push(currentCharacter);
                }

            } else {

                postfix.append(currentCharacter);

            }
        }

        for (Node<Character> top = operatorStack.top; !operatorStack.isEmpty(); top = operatorStack.top) {
            postfix.append(operatorStack.pop().data);
        }

        return postfix.toString();
    }

    public int evaluatePostfix (String expression) {
        int result = 0;
        LinkedListStack <Integer> numberStack = new LinkedListStack<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                numberStack.push(Character.getNumericValue(expression.charAt(i)));
            } else if (isOperator(expression.charAt(i))) {
                int operand1 = numberStack.pop().data;
                int operand2 = numberStack.pop().data;
                result = evaluate(operand1, operand2, expression.charAt(i));
                numberStack.push(result);
            }
        }
        return numberStack.top.data;
    }

    private int evaluate(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand2 + operand1;
            case '-':
                return operand2 - operand1;
            case '*':
                return operand2 * operand1;
            case '/':
                return operand2 / operand1;
            default:
                return 0;
        }
    }

    private boolean isOperator(char character) {
        String operator = Character.toString(character);
        return operator.matches("[()/*+\\-]");
    }

    private boolean isOpeningParanthesis(char character) {
        String operator = Character.toString(character);
        return operator .matches("[(]");
    }

    private boolean isClosingParanthesis(char character) {
        String operator = Character.toString(character);
        return operator .matches("[)]");
    }

    private boolean isHigherPrecedence(char character) {
        String operator = Character.toString(character);
        return operator .matches("[*/]");
    }

    private boolean isLowerPrecedence(char character) {
        String operator = Character.toString(character);
        return operator .matches("[+-]");
    }

}
