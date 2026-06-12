package com.tetris;

import java.awt.Point;

public class Tetrominoes {

    public Point[] z() {
        Point[] output = new Point[6];
        output[0] = new Point(2, 1);
        output[1] = new Point(1, 1);
        output[4] = new Point(1, 0);
        output[5] = new Point(0, 0);
        return output;
    }

    public Point[] s() {
        Point[] output = new Point[6];
        output[1] = new Point(1, 1);
        output[2] = new Point(0, 1);
        output[3] = new Point(2, 0);
        output[4] = new Point(1, 0);
        return output;
    }

    public Point[] l() {
        Point[] output = new Point[6];
        output[0] = new Point(1, 2);
        output[1] = new Point(0, 2);
        output[3] = new Point(0, 1);
        output[5] = new Point(0, 0);
        return output;
    }

    public Point[] j() {
        Point[] output = new Point[6];
        output[0] = new Point(1, 2);
        output[1] = new Point(0, 2);
        output[2] = new Point(1, 1);
        output[4] = new Point(1, 0);
        return output;
    }

    public Point[] o() {
        Point[] output = new Point[4];
        output[0] = new Point(1, 2);
        output[1] = new Point(0, 2);
        output[2] = new Point(1, 1);
        output[3] = new Point(0, 1);
        return output;
    }

    public Point[] i() {
        Point[] output = new Point[5];
        output[0] = new Point(0, 0);
        output[1] = new Point(0, 1);
        output[2] = new Point(0, 2);
        output[3] = new Point(0, 3);
        output[4] = new Point(0, 4);
        return output;
    }

}
