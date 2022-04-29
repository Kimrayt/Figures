package com.company;

import FactoryArea.BlueFactory;
import Figures.BlueCircle;
import Figures.BluePolygon;
import Figures.BlueTriangle;
import Figures.Figure;
import Interfaces.IFigureFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import static com.company.FigureCreator.createFigure;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Point> polygonPoints = new ArrayList<>();
        Point p1 = new Point (1, 3);
        Point p2 = new Point (2, 5);
        Point p3 = new Point (3, 6);
        Point p4 = new Point (4, 4);
        Point p5 = new Point (5, 5);
        Point p6 = new Point (7, 8);
        Point p7 = new Point (8, 9);
        Point p8 = new Point (9, 10);
        Point p9 = new Point (10, 12);
        Point p10 = new Point (12, 14);

        polygonPoints.add (p1);
        polygonPoints.add (p2);
        polygonPoints.add (p3);
        polygonPoints.add (p4);

        ArrayList<Point> circlePoints = new ArrayList<>();
        circlePoints.add(p6);
        circlePoints.add(p7);

        ArrayList<Point> trianglePoints = new ArrayList<>();
        polygonPoints.add (p8);
        polygonPoints.add (p9);
        polygonPoints.add (p10);

        BluePolygon bp = (BluePolygon) FigureCreator.createFigure("blue", polygonPoints);
        BlueTriangle bt = (BlueTriangle) FigureCreator.createFigure("blue", trianglePoints);
        BlueCircle bc = (BlueCircle) FigureCreator.createFigure("blue", circlePoints);

        ArrayList<Figure> figuresBlue = new ArrayList<>();
        figuresBlue.add(bp);
        figuresBlue.add(bt);
        figuresBlue.add(bc);

        SavedFigure savedPolygon = new SavedFigure(polygonPoints, bp.getArea(), bp.getPerimeter());

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Kimrayt\\Documents\\.IdeaSerialization\\savedPolygon.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(savedPolygon);

        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Kimrayt\\Documents\\.IdeaSerialization\\savedPolygon.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedFigure previouslySavedPolygon = (SavedFigure) objectInputStream.readObject();

        System.out.println(previouslySavedPolygon);

        ObjectMapper mapper = new ObjectMapper();
        String jsonlist = mapper.writeValueAsString(figuresBlue);
        System.out.println(jsonlist);


    }
}
