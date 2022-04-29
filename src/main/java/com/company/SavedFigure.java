package com.company;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class SavedFigure implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;

    private ArrayList<Point> points;
    private double area;
    private double perimeter;


    public SavedFigure(ArrayList<Point> points, double area, double perimeter){
        this.points = points;
        this.area = area;
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public Double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
    public String toString(){
        return "Saved figure is {" + getClass().getSimpleName() + " with area " + this.area + " and perimeter " + this.perimeter +" }";
    }
}
