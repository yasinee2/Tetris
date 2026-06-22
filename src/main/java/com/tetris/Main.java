package com.tetris;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Main extends JPanel {

    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;
    public static final int CELL_SIZE = 50;
    public static final int FIELD_HEIGHT = 20;
    public static final int FIELD_WIDTH = 10;

    public static int[][] testBlocks = new int[FIELD_WIDTH][FIELD_HEIGHT];

    private Render render = new Render();

    public static void main(String[] args) {
        Main panel = new Main();
        Render.initWindow(panel);

    }

    @Override
    public void paintComponent(Graphics graphics) {
        render.paintcomponent(graphics);
    }

    public static void test() {
        System.out.println("Currently testing");
        int x = 0;
        int y = 0;
        int colorID = 0;
        for (int i = 0; i < FIELD_WIDTH * FIELD_HEIGHT; i++) {
            if (x >= FIELD_WIDTH) {
                x = 0;
                y++;
            }
            if (colorID >= 7) {
                colorID = 0;
            } else {
                colorID++;
            }
            testBlocks[x][y] = colorID;
            x++;
        }
        Render.renderCells(testBlocks);
    }

}
