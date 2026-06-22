package com.tetris;

import java.util.Random;

public class Cells {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 24;
    private final int[][] cells = new int[WIDTH][HEIGHT];
    public static final Random random = new Random();
    private Piece currentPiece;
    private int currentX;
    private int currentY;
    private PieceType nextPiece;
    private static final PieceType[] PIECES = PieceType.values();

    //public Piece activePiece;

    public Cells() {}

    public void addPiece(PieceType pieceType) {
        int color = random.nextInt(9) + 1;
        currentPiece = new Piece(pieceType, color);
        currentX = WIDTH / 2 - currentPiece.getWidth() / 2;
        currentY = 4 - currentPiece.getWidth();
    }

    public boolean canMoveTo(int destX, int destY, int[][] piece) {
        for (int y = 0; y < piece.length; y++) {
            for (int x = 0; x < piece.length; x++) {
                if (piece[y][x] == 0) continue;
                else if (destY + y >= HEIGHT || destX + x >= WIDTH || destX + x < 0) return false;
                else if (cells[destY + y][destX + x] != 0) return false;
            }
        }
        return true;
    }

    public boolean canMoveTo(int destX, int destY) {
        return canMoveTo(destX, destY, currentPiece.blocks);
    }

    public void tryMoveDown() {
        if (!canMoveTo(currentX, currentY - 1)) {
            setDown();
            return;
        }
        currentY -= 1;
    }

    public void tryMoveLeft() {
        if (!canMoveTo(currentX - 1, currentY)) return;
        currentX--;
    }

    public void tryMoveRight() {
        if (!canMoveTo(currentX + 1, currentY)) return;
        currentX++;
    }

    public void tryRotateCw() {
        Piece clone = currentPiece.clone();
        clone.rotateCw();
        if (!canMoveTo(currentX, currentY, clone.blocks));
    }

    public void tryRotateCcw() {
        Piece clone = currentPiece.clone();
        clone.rotateCcw();
        if (!canMoveTo(currentX, currentY, clone.blocks));
    }

    public void setDown() {
        for (int y = 0; y < currentPiece.getWidth(); y++) {
            for (int x = 0; x < currentPiece.getWidth(); x++) {
                if (!currentPiece.isAtIndex(x, y)) continue;
                cells[y + currentY][x + currentX] = currentPiece.blocks[y][x];
            }
        }
        addPiece(nextPiece);
        nextPiece = PIECES[random.nextInt(PIECES.length)];
    }
}
