package com.tetris;

import java.awt.Color;
import java.util.Random;

public class Cells {

    private final int[][] cells = new int[10][24];
    public static final Random random = new Random();

    //public Piece activePiece;

    public Cells() {}

    public void addPiece(Pieces piece) {
        int color = random.nextInt(9) + 1;
    }
}
