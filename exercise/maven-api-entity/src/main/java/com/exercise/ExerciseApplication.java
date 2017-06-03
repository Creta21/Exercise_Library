package com.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // auto to pairnoume apo ta stubs
@ComponentScan(basePackages = {"io.swagger", "com.exercise", "com.exercise.repository"}) // kai auto kai PROSOXI!!!
public class ExerciseApplication { // na valoume to paketo tis main kai twn repository me ta {} apeksw

    public static void main(String[] args) {
	SpringApplication.run(ExerciseApplication.class, args);
    }
}