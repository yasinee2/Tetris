package com.tetris;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Main extends JPanel {

    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;
    public static final int CELL_SIZE = 50;
    public static final int FIELD_HEIGHT = 20;
    public static final int FIELD_WIDTH = 10;

    public static void main(String[] args) {
        Main panel = new Main();
        Render.initWindow(panel);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        new Render().paintcomponent(graphics);
    }

}
