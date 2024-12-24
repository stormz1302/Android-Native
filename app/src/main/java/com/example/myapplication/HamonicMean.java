package com.example.myapplication;

public class HamonicMean {
    static double _res = 0;
    static double harmonicMean(double x) {
        double res = _res;
        res += 1/x;
        _res = res;
        return res;
    }
}
