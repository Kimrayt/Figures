package com.company;

import Figures.BlueCircle;
import Figures.Figure;
import Graphic.FiguresFrame;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public ArrayList<Figure> figuresBlue;

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {


        ArrayList<Point> polygonPoints = new ArrayList<>();
        Point p1 = new Point(1, 3);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(3, 6);
        Point p4 = new Point(4, 4);
        Point p5 = new Point(5, 5);
        Point p6 = new Point(7, 8);
        Point p7 = new Point(8, 9);
        Point p8 = new Point(9, 10);
        Point p9 = new Point(10, 12);
        Point p10 = new Point(12, 14);

        polygonPoints.add(p1);
        polygonPoints.add(p2);
        polygonPoints.add(p3);
        polygonPoints.add(p4);

        ArrayList<Point> circlePoints = new ArrayList<>();
        circlePoints.add(p6);
        circlePoints.add(p7);

        ArrayList<Point> trianglePoints = new ArrayList<>();
        trianglePoints.add(p8);
        trianglePoints.add(p9);
        trianglePoints.add(p10);

        Figure bp = FigureCreator.createFigure("blue", polygonPoints);
        Figure bt = FigureCreator.createFigure("blue", trianglePoints);
        Figure bc = FigureCreator.createFigure("blue", circlePoints);

        ArrayList<Figure> figuresBlue = new ArrayList<>();
        figuresBlue.add(bp);
        figuresBlue.add(bt);
        figuresBlue.add(bc);

        SavedFigure savedPolygon = new SavedFigure(polygonPoints, bp.getArea(), bp.getPerimeter());

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Kimrayt\\Documents\\.IdeaSerialization\\savedFigure.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(savedPolygon);

        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Kimrayt\\Documents\\.IdeaSerialization\\savedFigure.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedFigure previouslySavedPolygon = (SavedFigure) objectInputStream.readObject();

        System.out.println(previouslySavedPolygon);

        ObjectMapper mapper = new ObjectMapper();
        String jsonlist = mapper.writeValueAsString(figuresBlue);
        System.out.println(jsonlist);

        /*String output = "{\" class\":\" Figure\",\"area\": 20\",\"perimeter\": 10}";
        @JsonDeserialize(as = ArrayList.class)
        Figure savedBlueFigures = mapper.readValue(output, Figure.class);
        System.out.println(savedBlueFigures);*/

        FiguresFrame frame = new FiguresFrame();
        frame.show();

    }

}
