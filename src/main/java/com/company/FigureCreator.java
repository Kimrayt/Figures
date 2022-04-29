package com.company;

import FactoryArea.BlueFactory;
import FactoryArea.YellowFactory;
import Figures.*;
import Interfaces.IFigureFactory;

import java.util.ArrayList;

public class FigureCreator {
    public static Figure createFigure(String color, ArrayList<Point> points){
        if (color == "blue") {
            if (points.size() == 2) {
                IFigureFactory creator;
                creator = new BlueFactory();
                BlueCircle bc = (BlueCircle) creator.createCircle(points);
                return bc;
            } else if (points.size() == 3) {
                IFigureFactory creator;
                creator = new BlueFactory();
                BlueTriangle bt = (BlueTriangle) creator.createTriangle(points);
                return bt;
            } else if (points.size() >= 4) {
                IFigureFactory creator;
                creator = new BlueFactory();
                BluePolygon bp = (BluePolygon) creator.createPolygon(points);
                return bp;
            } else {
                return null;
            }
        }
        else if (color == "yellow") {
            if (points.size() == 2) {
                IFigureFactory creator;
                creator = new YellowFactory();
                YellowCircle bc = (YellowCircle) creator.createCircle(points);
                return bc;
            } else if (points.size() == 3) {
                IFigureFactory creator;
                creator = new YellowFactory();
                YellowTriangle bt = (YellowTriangle) creator.createTriangle(points);
                return bt;
            } else if (points.size() >= 4) {
                IFigureFactory creator;
                creator = new YellowFactory();
                YellowPolygon bp = (YellowPolygon) creator.createPolygon(points);
                return bp;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }
}
