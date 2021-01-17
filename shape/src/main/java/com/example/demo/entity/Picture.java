package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

public class Picture extends Shape {
    List<Shape> shapes;

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public Picture(char ch, List<Shape> shapes) {
        super(ch);
        this.shapes = shapes;
    }

    @Override
    public void draw() {
        Stream.generate(() -> '_').limit(20).forEach(System.out::print);
        System.out.println("");
        shapes.forEach(Shape::draw);
        Stream.generate(() -> '_').limit(20).forEach(System.out::print);
    }
}
