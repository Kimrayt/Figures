package Figures;

import Interfaces.ICircle;
import com.company.Point;

import java.util.ArrayList;

public class YellowCircle extends Figure implements ICircle {

public YellowCircle (ArrayList<Point> points){
        super(points);
    }

    @Override
    public double getRadius() {
        double radius = 0;
        for (int i = 0; i < points.size(); i++) {
            int next = i + 1 < points.size() ? i + 1 : 0;
            radius = Math.sqrt(Math.pow((points.get(next).getY()-points.get(i).getY()),2) * Math.pow((points.get(next).getX()-points.get(i).getX()),2));
        }
        return radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI*(getRadius()*getRadius());
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = Math.PI*2*getRadius();
        return perimeter;
    }

}
