package com.example.demo;

import com.example.demo.entity.Picture;
import com.example.demo.entity.Shape;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeFlow implements ApplicationRunner {
    private final List<Shape> shapes;
    private final Picture picture;

    public ShapeFlow(List<Shape> shapes, Picture picture) {
        this.shapes = shapes;
        this.picture = picture;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        picture.draw();
    }
}
