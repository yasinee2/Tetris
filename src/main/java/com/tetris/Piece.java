package com.tetris;

public class Piece {

    public final int[][] blocks;

    public Piece(Pieces type, int c) {
        switch (type) {
            case O -> blocks = new int[][] { { c, c }, { c, c } };
            case S -> blocks = new int[][] { { 0, 0, 0 }, { 0, c, c }, { c, c, 0 } };
            case Z -> blocks = new int[][] { { 0, 0, 0 }, { c, c, 0 }, { 0, c, c } };
            case I -> blocks = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { c, c, c, c }, { 0, 0, 0, 0 } };
            case L -> blocks = new int[][] { { 0, c, 0 }, { 0, c, 0 }, { 0, c, c } };
            case J -> blocks = new int[][] { { 0, c, 0 }, { 0, c, 0 }, { c, c, 0 } };
            case T -> blocks = new int[][] { { 0, 0, 0 }, { 0, c, 0 }, { c, c, c } };
            default -> blocks = new int[][] { { c, c, c }, { 0, c, 0 }, { c, c, c } };
        }
    }

    public void rotateCw() {
        int[][] originalRotation = new int[blocks.length][blocks.length];
        for (int i = 0; i < blocks.length; i++) originalRotation[i] = blocks[i].clone();
        for (int y = 0; y < blocks.length; y++) {
            for (int x = 0; x < blocks.length; x++) {
                blocks[x][blocks.length - 1 - y] = originalRotation[y][x];
            }
        }
    }
}
