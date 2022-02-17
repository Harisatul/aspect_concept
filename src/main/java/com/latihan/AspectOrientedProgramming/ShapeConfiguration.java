package com.latihan.AspectOrientedProgramming;

import com.latihan.AspectOrientedProgramming.aspect.LoggingAspect;
import com.latihan.AspectOrientedProgramming.model.Circle;
import com.latihan.AspectOrientedProgramming.model.Triangle;
import com.latihan.AspectOrientedProgramming.service.ShapeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses = LoggingAspect.class)
public class ShapeConfiguration {

    @Bean
    public Circle circle(){
        return new Circle("circle name");
    }
    @Bean
    public Triangle triangle(){
        return new Triangle("triangle name");
    }
    @Bean
    public ShapeService shapeService(Circle circle, Triangle triangle){
        return new ShapeService(circle, triangle);
    }


}
