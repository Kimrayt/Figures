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

    public ArrayList<Point> getPoints() {
        return points;
    }

    public double getRadius() {
        double radius = 0;
        for (int i = 0; i < points.size(); i++) {
            int next = i + 1 < points.size() ? i + 1 : 0;
            radius = Math.sqrt(Math.pow((points.get(next).getY()-points.get(i).getY()),2) * Math.pow((points.get(next).getX()-points.get(i).getX()),2));
        }
        return radius;
    }
}
