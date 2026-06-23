package com.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class InputHandler extends JPanel {

    private Cells cells;
    //esc = pause
    //a,s,d = move block
    //space = soft fall
    //m = hard fall
    //e = turn clockwise
    //q = counterclockwise
    public void inputHandler() {
        setFocusable(true);
        addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        pause();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_A) {
                        moveBlock('l');
                    }
                    if (e.getKeyCode() == KeyEvent.VK_D) {
                        moveBlock('r');
                    }
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        moveBlock('d');
                    }
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        softFall();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_M) {
                        hardFall();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_E) {
                        rotateBlock('r');
                    }
                    if (e.getKeyCode() == KeyEvent.VK_Q) {
                        rotateBlock('l');
                    }
                }
            }
        );
    }

    public void setCells(Cells cells) {
        this.cells = cells;
    }

    private void pause() {}

    private void moveBlock(char dir) {
        if (cells == null) return;
        switch (dir) {
            case 'l' -> cells.tryMoveLeft();
            case 'r' -> cells.tryMoveRight();
            case 'd' -> cells.tryMoveDown();
        }
        Render.renderCells(cells.buildRenderFrame());
    }

    private void softFall() {
        if (cells == null) return;
        cells.softFall();
        Render.renderCells(cells.buildRenderFrame());
    }

    private void hardFall() {
        if (cells == null) return;
        cells.hardFall();
        Render.renderCells(cells.buildRenderFrame());
    }

    private void rotateBlock(char dir) {
        if (cells == null) return;
        if (dir == 'r') cells.tryRotateCw();
        else cells.tryRotateCcw();
        Render.renderCells(cells.buildRenderFrame());
    }
}
