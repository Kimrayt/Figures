package Graphic;

import Figures.BlueCircle;
import Figures.Figure;
import com.company.FigureCreator;
import com.company.FiguresArray;
import com.company.Main;
import com.company.PointsArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FiguresFrame extends JFrame implements ActionListener{
    public static boolean makeCircle = false;
    public static boolean makeTriangle = false;
    public static boolean makePolygon = false;


    private JFrame frame;
    private JLabel statusLabel;
    private JTextField colorTextFiled;
    private JButton createTriangle;
    private JButton createPolygon;
    private JButton createCircle;
    private static FiguresGraphic graphic;

    private static String color;

    public FiguresFrame(){
        createFrame();
        initElements();
    }
    private void createFrame(){
        frame = new JFrame("Pure suffering");
        frame.setSize(720, 480);
        //frame.setBounds(1, 1, 720, 480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void show(){
        frame.setVisible(true);
    }

    private void initElements() {
        Container mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        /*JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.pink);*/

        //mainContainer.add(bottomPanel);
        statusLabel = new JLabel("Let's draw a figure");
        statusLabel.setIcon(new ImageIcon("C:\\Users\\Kimrayt\\Download\\artist.png"));

        Box leftPanel = createLeftPanel();
        mainContainer.add(leftPanel, BorderLayout.PAGE_END);

        Box rightPanel = createRightPanel();
        mainContainer.add(rightPanel, BorderLayout.PAGE_START);

        graphic = new FiguresGraphic();
        graphic.setBackground(Color.WHITE);
        //graphic.setBounds(200, 200, 400, 400);
        mainContainer.add(graphic);

    }
    private Box createLeftPanel() {
        Box panel = Box.createHorizontalBox();
        JLabel drawing = new JLabel();
        //drawing.setIcon(new ImageIcon("C:\\Users\\Kimrayt\\Download\\artist.png"));
        panel.add(drawing);

        JButton createTriangle = new JButton ("Create a triangle");
        JButton createPolygon = new JButton ("Create a polygon");
        JButton createCircle = new JButton ("Create a circle  ");

        createCircle.setFont(Font.getFont(Font.SANS_SERIF));
        createTriangle.setFont(Font.getFont(Font.SANS_SERIF));
        createPolygon.setFont(Font.getFont(Font.SANS_SERIF));


        createCircle.addActionListener(e -> {
            FiguresArray.getArray().add(FigureCreator.createFigure("blue", PointsArray.createArray(2)));
            setMakeCircle(true);
            setMakeTriangle(false);
            setMakePolygon(false);
            graphic.repaint();
        });

        createTriangle.addActionListener(e -> {
            FiguresArray.getArray().add(FigureCreator.createFigure("blue", PointsArray.createArray(3)));
            setMakeTriangle(true);
            setMakeCircle(false);
            setMakePolygon(false);
            graphic.repaint();

        });

        createPolygon.addActionListener(e -> {
            Figure bp = FigureCreator.createFigure("blue", PointsArray.createArray(10));
            FiguresArray.getArray().add(bp);
            setMakePolygon(true);
            setMakeTriangle(false);
            setMakeCircle(false);
            graphic.repaint();

        });

        panel.add(createCircle);
        panel.add(createTriangle);
        panel.add(createPolygon);

        return panel;
    }
    private Box createRightPanel(){
        Box panel = Box.createHorizontalBox();
        JLabel drawing = new JLabel();
        //drawing.setIcon(new ImageIcon("C:\\Users\\Kimrayt\\Download\\artist.png"));
        panel.add(drawing);

        JButton setColorBlue = new JButton ("<html><font color='blue'>&#9679</font> </html>");
        JButton setColorYellow = new JButton ("<html><font color='yellow'>&#9679</font> </html>");


        setColorBlue.setFont(Font.getFont(Font.SANS_SERIF));
        setColorYellow.setFont(Font.getFont(Font.SANS_SERIF));

        setColorBlue.addActionListener(e -> {
            //graphic.setFigureColor("Blue");
            color = "Blue";
        });
        setColorYellow.addActionListener(e -> {
            //graphic.setFigureColor("Yellow");
            color = "Yellow";
        });


        panel.add(setColorBlue);
        panel.add(setColorYellow);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (makePolygon == true || makeCircle == true || makeTriangle == true){
            graphic.repaint();}
    }
    public static void draw (Graphics g){
        if (makePolygon == true){
            graphic.drawFigureWithSquares(g, 4);
        }
        else if (makeCircle == true){
            graphic.createBlueCircle(g);
        }
        else if (makeTriangle == true){
            graphic.drawFigureWithSquares(g, 3);
        }
    }

    public static boolean getMakeCircle() {
        return makeCircle;
    }

    public static boolean getMakePolygon() {
        return makePolygon;
    }
    public static boolean getMakeTriangle(){
        return makeTriangle;
    }

    public static void setMakePolygon(boolean makePolygon) {
        FiguresFrame.makePolygon = makePolygon;
    }

    public static void setMakeCircle(boolean makeCircle) {
        FiguresFrame.makeCircle = makeCircle;
    }

    public static void setMakeTriangle(boolean makeTriangle) {
        FiguresFrame.makeTriangle = makeTriangle;
    }

    public JFrame getFrame(){
        return frame;
    }

    public static String getColor() {
        return color;
    }
}
