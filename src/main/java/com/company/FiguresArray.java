package com.company;

import Figures.Figure;

import java.util.ArrayList;

public class FiguresArray {

    static ArrayList<Figure> figures = new ArrayList<>();

    public static void addFigure(Figure f){
        figures.add(f);
    }

    public static Figure getFigure (int i){
        return figures.get(i);
    }
    public static ArrayList getArray(){
        return figures;
    }
}
