package com.example.quiz1;

public class Car {
    private String name;
    private String model;
    private String color;

    public Car(String name, String model, String color) {
        this.name = name;
        this.model = model;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return String.format("Car{name='%s', model='%s', color='%s'}", name, model, color);
    }
}