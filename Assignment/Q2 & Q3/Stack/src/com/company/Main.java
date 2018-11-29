package com.company;

public class Main {

    public static void main(String[] args) {
//        LinkedListStack <Integer> listStack = new LinkedListStack<>();
//        listStack.push(5);
//        listStack.push(6);
//        listStack.push(8);
//        listStack.push(10);
//        listStack.print();
//        listStack.pop();
//        listStack.pop();
//        listStack.pop();
//        listStack.pop();
//        listStack.pop();
//        System.out.println(listStack.isEmpty());
//        listStack.print();
//        System.out.println(listStack.validateStringExpression("()}"));
//        System.out.println(listStack.validateStringExpression("{)}"));
//        System.out.println(listStack.validateStringExpression("({})"));
//
//        ArrayListStack arrayStack = new ArrayListStack();
//        System.out.println(arrayStack.isEmpty());
//        System.out.println(arrayStack.size());
//        arrayStack.push(5);
//        arrayStack.push(6);
//        arrayStack.push(7);
//        arrayStack.push(8);
//        arrayStack.print();
//        System.out.println(arrayStack.isEmpty());
//        System.out.println(arrayStack.size());
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.print();
//        System.out.println(arrayStack.size());

        InfixPostfix infixPostfix = new InfixPostfix();

        String postfix = infixPostfix.infixToPostfix("(9+(2+9))*((3*3)/9)");
        System.out.println(postfix);
        System.out.println(infixPostfix.evaluatePostfix(postfix));

        System.out.println();

        postfix = infixPostfix.infixToPostfix("(2*1)+(8/2)");
        System.out.println(postfix);
        System.out.println(infixPostfix.evaluatePostfix(postfix));

        System.out.println();

        postfix = infixPostfix.infixToPostfix("(3+2)/2+3-1+(2-1)");
        System.out.println(postfix);
        System.out.println(infixPostfix.evaluatePostfix(postfix));

    }
}
