package com.latihan.AspectOrientedProgramming.model;

import org.springframework.stereotype.Component;


public class Circle {

    private String name;

    public Circle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Circle setter called");
        throw (new RuntimeException());
    }

    public String setNameAndReturn(String name) {
        this.name = name;
        System.out.println("Circle setter called");
        return name;
    }
}
