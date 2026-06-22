package com.tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Render extends JPanel {

    private static Graphics graphics;
    private static int offsetX;
    private static int offsetY;
    private static int FIELD_HEIGHT = Main.FIELD_HEIGHT;
    private static int FIELD_WIDTH = Main.FIELD_WIDTH;
    private static int CELL_SIZE = Main.CELL_SIZE;

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
        graphics.fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        offsetX = (Main.WINDOW_WIDTH / 2) - FIELD_WIDTH * CELL_SIZE / 2;
        offsetY = 0;
        Main.test();
    }

    public static void renderCells(int[][] blocks) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < FIELD_HEIGHT * FIELD_WIDTH; i++) {
            System.out.println("Rendering cell: " + x + ", " + y);
            if (x >= FIELD_WIDTH) {
                x = 0;
                y++;
            }
            switch (blocks[x][y]) {
                case 0:
                    DrawCell(x, y, Color.white);
                    break;
                case 1:
                    DrawCell(x, y, Color.red);
                    break;
                case 2:
                    DrawCell(x, y, Color.blue);
                    break;
                case 3:
                    DrawCell(x, y, Color.green);
                    break;
                case 4:
                    DrawCell(x, y, Color.yellow);
                    break;
                case 5:
                    DrawCell(x, y, Color.cyan);
                    break;
                case 6:
                    DrawCell(x, y, Color.orange);
                    break;
                case 7:
                    DrawCell(x, y, Color.red);
                    break;

                default:
                    throw new AssertionError();
            }
            x++;
        }
    }

    private static void DrawCell(int CellX, int CellY, Color color) {
        int PosX = CellX * CELL_SIZE + offsetX;
        int PosY = CellY * CELL_SIZE + offsetY;
        int ExtraOffset = 1; // for a outline
        if (color.equals(Color.white)) {
            graphics.setColor(color);
            graphics.drawRect(PosX, PosY, CELL_SIZE - ExtraOffset, CELL_SIZE - ExtraOffset);
        } else {
            graphics.setColor(color);
            graphics.fillRect(PosX, PosY, CELL_SIZE - ExtraOffset, CELL_SIZE - ExtraOffset);
        }
        System.out.println(color + " at: " + CellX + ", " + CellY);

    }
}
