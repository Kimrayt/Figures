package Figures;

import Interfaces.ICircle;
import com.company.Point;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class BlueCircle extends Figure implements ICircle, Serializable {

    private Color circleColor = Color.BLUE;

    @JsonIgnore
    public BlueCircle (ArrayList<Point> points){
        super(points);
    }

    @Override
    @JsonFormat(pattern = "radius : ")
    public double getRadius() {
        double radius = 0;
        for (int i = 0; i < points.size(); i++) {
            int next = i + 1 < points.size() ? i + 1 : 0;
            radius = Math.sqrt(Math.pow((points.get(next).getY()-points.get(i).getY()),2) * Math.pow((points.get(next).getX()-points.get(i).getX()),2));
        }
        return radius;
    }

    @Override
    @JsonFormat(pattern = "area : ")
    public double getArea() {
        double area = Math.PI*(getRadius()*getRadius());
        return area;
    }

    @Override
    @JsonFormat(pattern = "perimeter : ")
    public double getPerimeter() {
        double perimeter = Math.PI*2*getRadius();
        return perimeter;
    }

    public Color getCircleColor() {
        return circleColor;
    }
    public int getX(){
        int x = (int)points.get(0).getX();
        return x;
    }
    public int getY(){
        int y = (int)points.get(0).getX();
        return y;
    }
}
