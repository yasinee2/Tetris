package com.tetris;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Render extends JPanel {

    private static Graphics graphics;
    private static int offsetX;
    private static int offsetY;
    private static int CELL_SIZE = Main.CELL_SIZE;

    public Render() {}

    protected static void initWindow(Main panel) {
        JFrame frame = new JFrame();
        frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        frame.add(panel);
        frame.setTitle("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.requestFocusInWindow();
    }

    public void paintcomponent(Graphics graphics) {
        Render.graphics = graphics;
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        offsetX = (Main.WINDOW_WIDTH / 2) - (Cells.WIDTH * CELL_SIZE) / 2;
        offsetY = 0;
    }

    public static void renderCells(int[][] blocks) {
        if (graphics == null) return; // not yet initialized

        for (int y = 0; y < Cells.HEIGHT; y++) {
            for (int x = 0; x < Cells.WIDTH; x++) {
                switch (blocks[y][x]) {
                    case 0 -> DrawCell(x, y, Color.white);
                    case 1 -> DrawCell(x, y, Color.red);
                    case 2 -> DrawCell(x, y, Color.blue);
                    case 3 -> DrawCell(x, y, Color.green);
                    case 4 -> DrawCell(x, y, Color.yellow);
                    case 5 -> DrawCell(x, y, Color.cyan);
                    case 6 -> DrawCell(x, y, Color.orange);
                    case 7 -> DrawCell(x, y, Color.magenta);
                    default -> DrawCell(x, y, Color.gray);
                }
            }
        }
    }

    private static void DrawCell(int CellX, int CellY, Color color) {
        if (graphics == null) return;
        int PosX = CellX * CELL_SIZE + offsetX;
        int PosY = CellY * CELL_SIZE + offsetY;
        int ExtraOffset = 1;
        if (color.equals(Color.white)) {
            graphics.setColor(color);
            graphics.drawRect(PosX, PosY, CELL_SIZE - ExtraOffset, CELL_SIZE - ExtraOffset);
        } else {
            graphics.setColor(color);
            graphics.fillRect(PosX, PosY, CELL_SIZE, CELL_SIZE);
        }
    }
}
