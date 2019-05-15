package com.example.demo;

/**
 * Created by XGH on 2019/4/24
 */
public class House {
    Window window = new Window(1);
    House(){
        System.out.println("House()");
        w3 = new Window(3);
    }
    Window w2 = new Window(2);

    void f(){
        System.out.println("F()");
    }
    Window w3 = new Window(3);
}
