package com.latihan.AspectOrientedProgramming;

import com.latihan.AspectOrientedProgramming.service.ShapeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
       applicationContext = new AnnotationConfigApplicationContext(ShapeConfiguration.class);
    }

    @org.junit.jupiter.api.Test
     void test() {
        ShapeService shapeService = applicationContext.getBean(ShapeService.class);
        ShapeService shapeService2 = applicationContext.getBean(ShapeService.class);

        System.out.println(shapeService.getCircle().getName());

        Assertions.assertSame(shapeService, shapeService2);
    }
}
