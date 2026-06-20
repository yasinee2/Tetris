package com.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Main extends JPanel {

    private final int CELL_SIZE = 50;

    private final int FIELD_HEIGHT = 20;
    private final int FIELD_WIDTH = 10;

    private Set<Point> cells = new HashSet<>();
    private Set<Point> OpenCells = new HashSet<>();

    private Graphics graphics;
    private int offsetX;
    private int offsetY;

    public static void main(String[] args) {
        Piece piece = new Piece(Pieces.T, 1);
        Main panel = new Main();
        initWindow(panel);
        panel.initListeners();
    }

    private void initListeners() {
        setFocusable(true);

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        getActionMap().put(
            "space",
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {}
            }
        );
        getActionMap().put(
            "down",
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("move");
                }
            }
        );
    }

    private static void initWindow(Main panel) {
        JFrame frame = new JFrame();
        frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        frame.add(panel);
        frame.setTitle("Tetris");
        frame.setVisible(true);
        panel.requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        this.graphics = graphics;
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        offsetX = (getWidth() / 2) - (CELL_SIZE * FIELD_WIDTH) / 2;
        offsetY = (getHeight() / 2) - (CELL_SIZE * FIELD_HEIGHT) / 2;

        int x = 0;
        int y = 0;
        for (int i = 0; i < FIELD_HEIGHT * FIELD_WIDTH; i++) {
            if (x > (FIELD_WIDTH - 1)) {
                x = 0;
                y++;
            }
            graphics.setColor(Color.WHITE);
            cells.add(new Point(x * CELL_SIZE, y * CELL_SIZE));
            graphics.drawRect(x * CELL_SIZE + offsetX, y * CELL_SIZE + offsetY, CELL_SIZE, CELL_SIZE);
            x++;
        }

        if (OpenCells.isEmpty()) {
            return;
        }

        for (Point cell : OpenCells) {
            if (cell != null) {
                System.out.println("Cell: " + cell);
                graphics.setColor(Color.RED);
                graphics.fillRect(cell.x * CELL_SIZE + offsetX, cell.y * CELL_SIZE + offsetY, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    private void spawnTetromino(Point[] tetromino) {
        System.out.println("Spawning");
        for (Point tetro : tetromino) {
            OpenCells.add(tetro);
            repaint();
        }
    }

    private void moveTetrominoDown(Point[] tetromino, Point LeftCorner) {
        for (Point tetro : tetromino) {
            OpenCells.remove(tetro);
            if (tetro != null) {
                tetro.y += LeftCorner.y + 1;
                OpenCells.add(tetro);
            }
            System.out.println("New Tetro: " + tetro);
        }
        repaint();
    }
}
