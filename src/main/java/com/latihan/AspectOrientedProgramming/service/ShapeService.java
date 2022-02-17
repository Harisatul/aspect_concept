package com.latihan.AspectOrientedProgramming.service;

import com.latihan.AspectOrientedProgramming.aspect.Loggable;
import com.latihan.AspectOrientedProgramming.model.Circle;
import com.latihan.AspectOrientedProgramming.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ShapeService {

    private Circle circle;
    private Triangle triangle;

    public ShapeService(Circle circle, Triangle triangle) {
        this.circle = circle;
        this.triangle = triangle;
    }

    @Loggable
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }


}
