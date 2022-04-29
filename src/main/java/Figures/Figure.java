package Figures;

import com.company.Point;

import java.util.ArrayList;

public abstract class Figure {

    public ArrayList<Point> points;


    public Figure (ArrayList<Point> points){
        this.points = points;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public String toString() {
        return "Hi, I'm " + this.getClass().getSimpleName() + " with points: " + this.points;
    }
}
