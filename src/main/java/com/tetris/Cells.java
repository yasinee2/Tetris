package com.tetris;

import java.util.Random;

public class Cells {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 24;
    private final int[][] cells = new int[HEIGHT][WIDTH];
    public static final Random random = new Random();
    private Piece currentPiece;
    private int currentX;
    private int currentY;
    private PieceType nextPiece;
    private static final PieceType[] PIECES = PieceType.values();

    public Cells() {
        nextPiece = PIECES[random.nextInt(PIECES.length)];
    }

    public void addPiece(PieceType pieceType) {
        int color = random.nextInt(7) + 1;
        currentPiece = new Piece(pieceType, color);
        currentX = WIDTH / 2 - currentPiece.getWidth() / 2;
        currentY = 4 - currentPiece.getWidth();
    }

    public boolean canMoveTo(int destX, int destY, int[][] piece) {
        for (int y = 0; y < piece.length; y++) {
            for (int x = 0; x < piece.length; x++) {
                if (piece[y][x] == 0) continue;
                if (destY + y < 0) continue;
                if (destY + y >= HEIGHT || destX + x >= WIDTH || destX + x < 0) return false;
                if (cells[destY + y][destX + x] != 0) return false;
            }
        }
        return true;
    }

    public boolean canMoveTo(int destX, int destY) {
        return canMoveTo(destX, destY, currentPiece.blocks);
    }

    public void update() {
        tryMoveDown();
        Render.renderCells(buildRenderFrame());
    }

    public int[][] buildRenderFrame() {
        int[][] frame = new int[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++) frame[y] = cells[y].clone();
        for (int y = 0; y < currentPiece.getWidth(); y++) {
            for (int x = 0; x < currentPiece.getWidth(); x++) {
                if (!currentPiece.isAtIndex(x, y)) continue;
                int ry = currentY + y;
                int rx = currentX + x;
                if (ry >= 0 && ry < HEIGHT && rx >= 0 && rx < WIDTH) {
                    frame[ry][rx] = currentPiece.blocks[y][x];
                }
            }
        }
        return frame;
    }

    public void tryMoveDown() {
        if (!canMoveTo(currentX, currentY + 1)) {
            setDown();
            return;
        }
        currentY += 1;
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
        if (canMoveTo(currentX, currentY, clone.blocks)) currentPiece.rotateCw();
    }

    public void tryRotateCcw() {
        Piece clone = currentPiece.clone();
        clone.rotateCcw();
        if (canMoveTo(currentX, currentY, clone.blocks)) currentPiece.rotateCcw();
    }

    public void softFall() {
        tryMoveDown();
    }

    public void hardFall() {
        while (canMoveTo(currentX, currentY + 1)) currentY++;
        setDown();
    }

    public void setDown() {
        for (int y = 0; y < currentPiece.getWidth(); y++) {
            for (int x = 0; x < currentPiece.getWidth(); x++) {
                if (!currentPiece.isAtIndex(x, y)) continue;
                int ry = y + currentY;
                int rx = x + currentX;
                if (ry >= 0 && ry < HEIGHT && rx >= 0 && rx < WIDTH) {
                    cells[ry][rx] = currentPiece.blocks[y][x];
                }
            }
        }
        PieceType toSpawn = nextPiece;
        nextPiece = PIECES[random.nextInt(PIECES.length)];
        addPiece(toSpawn);
    }
}
