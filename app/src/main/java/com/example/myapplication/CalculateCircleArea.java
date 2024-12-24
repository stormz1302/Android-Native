package com.example.myapplication;

public class CalculateCircleArea {
    static double calculateCircleArea(double loopLimit, double radius) {
        double sum = 0;
        for (double i = 1; i <= loopLimit; i++){
            double startTime = System.nanoTime();
            double v = Math.PI * radius * radius;
            double endTime = System.nanoTime();
            double duration = endTime - startTime;
            sum += 1/duration;
        }
        return loopLimit/sum;
    }
}
