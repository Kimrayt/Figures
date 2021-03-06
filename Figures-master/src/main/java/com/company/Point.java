package com.company;

import java.awt.geom.AffineTransform;
import java.io.Serializable;

public class Point implements Serializable {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String toString (){
        return "Point: "+this.getX() + "; "+ this.getY();
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}