package com.tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Render extends JPanel {

    private Graphics graphics;
    private Main main = new Main();
    private int offsetX;
    private int offsetY;
    private int FIELD_HEIGHT = Main.FIELD_HEIGHT;
    private int FIELD_WIDTH = Main.FIELD_WIDTH;
    private int CELL_SIZE = Main.CELL_SIZE;

    public Render() {
    }

    protected static void initWindow(Main panel) {
        JFrame frame = new JFrame();
        frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        frame.add(panel);
        frame.setTitle("Tetris");
        frame.setVisible(true);
        panel.requestFocusInWindow();
    }

    public void paintcomponent(Graphics graphics) {
        this.graphics = graphics;
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, main.WINDOW_WIDTH, main.WINDOW_HEIGHT);
        offsetX = (main.WINDOW_WIDTH / 2) - (FIELD_HEIGHT * FIELD_WIDTH) / 2;
        offsetY = (main.WINDOW_HEIGHT / 2) - (CELL_SIZE * FIELD_HEIGHT) / 2;
        renderCells(new int[][] a = int[

    
    4][5]);
    }

    public void renderCells(int[][] blocks) {
        System.out.println(blocks.length);
        int x = 0;
        int y = 0;

    }

}
