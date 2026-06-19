package com.tetris;

import java.awt.Color;
import java.util.Random;

public class Cells {

    private final Block[][] cells = new Block[10][24];
    private final Color[] colors = {
        Color.BLUE,
        Color.GREEN,
        Color.ORANGE,
        Color.PINK,
        Color.RED,
        Color.LIGHT_GRAY,
        Color.YELLOW,
    };
    public static final Random random = new Random();

    public Cells() {}

    public void addPiece(Pieces piece) {
        Color color = colors[random.nextInt(colors.length)];
        switch (piece) {
            case S -> {
                cells[4][21] = new Block(color);
                cells[5][21] = new Block(color);
                cells[5][22] = new Block(color);
                cells[6][22] = new Block(color);
            }
        }
    }
}
