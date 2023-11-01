package com.example.quiz1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarFactory {
    private static CarFactory instance;

    public final List<Car> cars = new ArrayList<Car>();

    private CarFactory() { }

    public static CarFactory getInstance() {
        if (instance == null) { instance = new CarFactory(); }
        return instance;
    }

    public List<Car> getCars() {
        return cars;
    }
}
