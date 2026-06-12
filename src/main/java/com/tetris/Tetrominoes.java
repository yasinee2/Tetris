package com.tetris;

import java.awt.Point;

public class Tetrominoes {

    public Point[] z() {
        Point[] output = new Point[6];
        output[0] = new Point(0, 0);
        output[1] = new Point(1, 0);
        output[4] = new Point(1, 1);
        output[5] = new Point(2, 1);

        System.out.print("Z piece:");
        for (Point cell : output) {
            System.out.print(" " + cell);

        }
        return output;
    }
}
