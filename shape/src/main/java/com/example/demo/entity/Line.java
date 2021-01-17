package com.example.demo.entity;

import java.util.stream.Stream;

public class Line extends Shape {
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Line(char ch, int length) {
        super(ch);
        this.length = length;
    }

    @Override
    public void draw() {
        Stream.generate(()->symbol).limit(length).forEach(System.out::print);
        System.out.println("");
    }
}
