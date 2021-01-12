package com.example.demo.entity;

public abstract class Shape {

    public char symbol;

    public Shape(char ch) {
        this.symbol = ch;
    }

    public abstract void draw();
}
