package com.example.myapplication;

public class CalculateCircleArea {
    static void calculateCircleArea(double loopLimit) {
        for (double radius = 1; radius <= loopLimit; radius++){
            double v = Math.PI * radius * radius;
        }
    }
}
