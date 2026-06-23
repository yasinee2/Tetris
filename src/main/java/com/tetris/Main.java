package com.tetris;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Main extends JPanel {

    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;
    public static final int CELL_SIZE = 40;

    private InputHandler inputHandler = new InputHandler();
    private Render render = new Render();

    public static void main(String[] args) {
        Main panel = new Main();
        Render.initWindow(panel);
        
        
        var cells = new Cells();
        cells.addPiece(PieceType.T);
        
        panel.add(panel.inputHandler);
        panel.inputHandler.inputHandler();
        panel.inputHandler.setCells(cells);
        panel.inputHandler.requestFocusInWindow();
        
        long tick = 0;
        long lastTime = System.nanoTime();
        while (true) {
            long now = System.nanoTime();
            tick += now - lastTime;
            lastTime = now;
            while (tick > 500_000_000L) {
                cells.update();
                tick -= 500_000_000L;
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        render.paintComponent(graphics);
    }

    public static void test(Render render) {
        System.out.println("Currently testing");
        int[][] testBlocks = new int[Cells.HEIGHT][Cells.WIDTH];
        int x = 0;
        int y = 0;
        int colorID = 0;
        for (int i = 0; i < Cells.WIDTH * Cells.HEIGHT; i++) {
            if (x >= Cells.WIDTH) {
                x = 0;
                y++;
            }
            if (colorID >= 7) colorID = 1;
            else colorID++;

            System.out.println(testBlocks[y][x]);
            testBlocks[y][x] = colorID;
            x++;
        }
        Render.renderCells(testBlocks);
    }
}
