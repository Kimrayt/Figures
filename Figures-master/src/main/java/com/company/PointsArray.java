package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PointsArray {

    static ArrayList<Point> points = new ArrayList<>();


    public static ArrayList createArray(int length){
        Random rng = new Random();
        for (int i = 0; i<=length; i++){
            points.add(new Point((rng.nextDouble()*i*30), (rng.nextDouble()*i*30)));
        }
        return points;
    }

    public static Point getPoint(int i){
        return points.get(i);
    }

    public static ArrayList getArray(){
        return points;
    }
}
