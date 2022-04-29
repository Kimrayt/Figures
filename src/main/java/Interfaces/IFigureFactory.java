package Interfaces;

import com.company.Point;

import java.util.ArrayList;

public interface IFigureFactory {
    ICircle createCircle(ArrayList<Point> points);
    ITriangle createTriangle(ArrayList<Point> points);
    IPolygon createPolygon(ArrayList<Point> points);
}
