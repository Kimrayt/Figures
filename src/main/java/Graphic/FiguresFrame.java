package Graphic;

import Figures.BlueCircle;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FiguresFrame {
    private JFrame frame;
    private JLabel statusLabel;
    private JTextField colorTextFiled;
    private JButton createTriangle;
    private JButton createPolygon;
    private JButton createCircle;
    private FiguresGraphic graphic;

    public FiguresFrame(){
        createFrame();
        initElements();
    }
    private void createFrame(){
        frame = new JFrame("Pure suffering");
        frame.setSize(720, 480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void show(){
        frame.setVisible(true);
    }

    private void initElements() {
        Container mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.pink);

        mainContainer.add(bottomPanel, BorderLayout.PAGE_END);
        statusLabel = new JLabel("Let's draw a figure");
        statusLabel.setIcon(new ImageIcon("C:\\Users\\Kimrayt\\Download\\artist.png"));

        Box leftPanel = createLeftPanel();
        mainContainer.add(leftPanel, BorderLayout.BEFORE_LINE_BEGINS);

        Box rightPanel = createRightPanel();
        mainContainer.add(rightPanel, BorderLayout.AFTER_LAST_LINE);

        graphic = new FiguresGraphic();
        graphic.setBackground(Color.WHITE);
        mainContainer.add(graphic);


    }
    private Box createLeftPanel() {
        Box panel = Box.createHorizontalBox();
        JLabel drawing = new JLabel();
        drawing.setIcon(new ImageIcon("C:\\Users\\Kimrayt\\Download\\artist.png"));
        panel.add(drawing);

        JButton createTriangle = new JButton ("Create a triangle");
        JButton createPolygon = new JButton ("Create a polygon");
        JButton createCircle = new JButton ("Create a circle  ");

        createCircle.setFont(Font.getFont(Font.SANS_SERIF));
        createTriangle.setFont(Font.getFont(Font.SANS_SERIF));
        createPolygon.setFont(Font.getFont(Font.SANS_SERIF));

        createCircle.setSize(80, 20);
        createPolygon.setSize(80, 20);
        createTriangle.setSize(80, 20);

        panel.add(createCircle);

        createCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(createTriangle);
        panel.add(createPolygon);

        return panel;
    }
    private Box createRightPanel(){
        Box panel = Box.createHorizontalBox();
        JLabel drawing = new JLabel();
        drawing.setIcon(new ImageIcon("C:\\Users\\Kimrayt\\Download\\artist.png"));
        panel.add(drawing);

        JButton setColorBlue = new JButton ("Make it Blue");
        JButton setColorYellow = new JButton ("Make it Yellow");

        setColorBlue.setFont(Font.getFont(Font.SANS_SERIF));
        setColorYellow.setFont(Font.getFont(Font.SANS_SERIF));

        panel.add(setColorBlue);
        panel.add(setColorYellow);

        return panel;
    }
}
