package com.tetris;

public class Piece {

    public final int[][] blocks;

    public Piece(PieceType type, int c) {
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

    private Piece(int[][] blocks) {
        this.blocks = blocks;
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

    public void rotateCcw() {
        int[][] originalRotation = new int[blocks.length][blocks.length];
        for (int i = 0; i < blocks.length; i++) originalRotation[i] = blocks[i].clone();
        for (int y = 0; y < blocks.length; y++) {
            for (int x = 0; x < blocks.length; x++) {
                blocks[blocks.length - 1 - x][y] = originalRotation[y][x];
            }
        }
    }

    public int getWidth() {
        return blocks.length;
    }

    public boolean isAtIndex(int x, int y) {
        return blocks[y][x] != 0;
    }

    public Piece clone() {
        return new Piece(blocks);
    }
}
