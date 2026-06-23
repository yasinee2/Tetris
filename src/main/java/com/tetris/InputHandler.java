package com.tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class InputHandler extends JPanel {

    //esc = pause
    //a,s,d = move block
    //space = soft fall
    //m = hard fall
    //e = turn clockwise
    //q = counterclockwise
    public void inputHandler() {
        addKeyListener(
                new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e
            ) {
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

    private void pause() {

    }

    private void moveBlock(char dir) { //NOTE: d = down; l = left; r = right
        System.out.println(dir);
    }

    private void softFall() {
    }

    private void hardFall() {
    }

    private void rotateBlock(char dir) { //NOTE: r = clockwise; l = counterclockwise
    }
}
