package FactoryArea;

import Figures.*;
import Interfaces.ICircle;
import Interfaces.IFigureFactory;
import Interfaces.IPolygon;
import Interfaces.ITriangle;
import com.company.Point;

import java.util.ArrayList;

public class YellowFactory implements IFigureFactory {

    @Override
    public ICircle createCircle(ArrayList<Point> points) {
        return new YellowCircle(points);
    }

    @Override
    public ITriangle createTriangle(ArrayList<Point> points) {
        return new YellowTriangle(points);
    }

    @Override
    public IPolygon createPolygon (ArrayList<Point> points) {
        return new YellowPolygon(points);
    }
}
