package com.company;

import FactoryArea.BlueFactory;
import Figures.BluePolygon;
import Interfaces.IFigureFactory;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Point> points = new ArrayList<>();
        Point p1 = new Point (1, 3);
        Point p2 = new Point (2, 5);
        Point p3 = new Point (3, 6);
        Point p4 = new Point (4, 4);
        Point p5 = new Point (5, 5);
        points.add (p1);
        points.add (p2);
        points.add (p3);
        points.add (p4);
        points.add (p5);

        IFigureFactory creator;
        creator = new BlueFactory();
        BluePolygon p = (BluePolygon) creator.createPolygon(points);

        SavedFigure savedPolygon = new SavedFigure(points, p.getArea(), p.getPerimeter());

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Kimrayt\\Documents\\.IdeaSerealization\\savedPolygon.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(savedPolygon);

        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Kimrayt\\Documents\\.IdeaSerealization\\savedPolygon.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedFigure previouslySavedPolygon = (SavedFigure) objectInputStream.readObject();

        System.out.println(previouslySavedPolygon);

    }
}
