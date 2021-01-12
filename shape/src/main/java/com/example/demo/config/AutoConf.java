package com.example.demo.config;

import com.example.demo.entity.Line;
import com.example.demo.entity.Picture;
import com.example.demo.entity.Rectangle;
import com.example.demo.entity.Shape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AutoConf {

    @Bean
    public Line starLine() {
        return new Line('*', 5);
    }

    @Bean
    public Rectangle andRectangle() {
        return new Rectangle('&', 3, 5);
    }

    @Bean
    public List<Shape> shapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(starLine());
        shapes.add(andRectangle());
        return shapes;
    }

    @Bean
    public Picture dachPicture() {

        return new Picture('-', shapes());
    }
}
