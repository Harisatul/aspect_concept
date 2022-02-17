package com.latihan.AspectOrientedProgramming;

import com.latihan.AspectOrientedProgramming.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ShapeConfiguration.class);

        ShapeService shapeService = applicationContext.getBean(ShapeService.class);
//        shapeService.getCircle().setName("Dummy name");
        shapeService.getCircle();
//        System.out.println(shapeService.getCircle().getName());
//        System.out.println(shapeService.getTriangle().getName());

    }
}
