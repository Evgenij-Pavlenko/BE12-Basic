package com.example.demo.entity;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle(char ch, int width, int height) {
        super(ch);
        this.width = width;
        this.height = height;
    }

    // with empty center - a lot of "if"
    @Override
    public void draw() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i > 0 && i < width - 1 && j > 0 && j < height - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print(symbol);
                }
            }
            System.out.println("");
        }
    }

//    @Override
//    public void draw() {
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                System.out.print(symbol);
//            }
//            System.out.println("");
//        }
//    }

}
