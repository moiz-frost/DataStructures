package com.company;

public class Main {

    public static void main(String[] args) {
        Customer queue = new Customer(10);
        System.out.println(queue.HomeDelivery());
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.CustomerEnter();
        queue.ShowAll();
        System.out.println(queue.ServeCustomer());
        System.out.println(queue.ServeCustomer());
        System.out.println(queue.ServeCustomer());
        System.out.println(queue.HomeDelivery());
        queue.ShowAll();
        System.out.println(queue.CancelAll());
        queue.ShowAll();
    }
}
