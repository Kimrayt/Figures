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

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {

        /*SavedFigure savedPolygon = new SavedFigure(bp.getArray(), bp.getArea(), bp.getPerimeter());

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Меланхолия попугая\\Downloads\\Figures-master\\src\\main\\java\\com\\savedFigure.json");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(savedPolygon);

        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Меланхолия попугая\\Downloads\\Figures-master\\src\\main\\java\\com\\savedFigure.json");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedFigure previouslySavedPolygon = (SavedFigure) objectInputStream.readObject();

        System.out.println(previouslySavedPolygon);

        ObjectMapper mapper = new ObjectMapper();
        String jsonlist = mapper.writeValueAsString(FiguresArray.getArray());
        System.out.println(jsonlist);

        /*String output = "{\" class\":\" Figure\",\"area\": 20\",\"perimeter\": 10}";
        @JsonDeserialize(as = ArrayList.class)
        Figure savedBlueFigures = mapper.readValue(output, Figure.class);
        System.out.println(savedBlueFigures);*/

        FiguresFrame frame = new FiguresFrame();
        frame.show();
    }

}
