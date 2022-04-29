package FactoryArea;

import Figures.BlueCircle;
import Figures.BluePolygon;
import Figures.BlueTriangle;
import Interfaces.ICircle;
import Interfaces.IFigureFactory;
import Interfaces.IPolygon;
import Interfaces.ITriangle;
import com.company.Point;

import java.util.ArrayList;

public class BlueFactory implements IFigureFactory {
    @Override
    public ICircle createCircle(ArrayList<Point> points) {
        return new BlueCircle(points);
    }

    @Override
    public ITriangle createTriangle(ArrayList<Point> points) {
        return new BlueTriangle(points);
    }

    @Override
    public IPolygon createPolygon (ArrayList<Point> points) {
        return new BluePolygon(points);
    }
}
