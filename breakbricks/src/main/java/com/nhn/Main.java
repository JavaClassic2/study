package com.nhn;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhn.world.BreakBricks;

public class Main {
    private static final int FRAME_WIDTH = 1600;
    private static final int FRAME_HEIGHT = 900;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Break Bricks");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        BreakBricks breakBricks = new BreakBricks(5);
        frame.add(breakBricks);
        frame.setVisible(true);

        breakBricks.prepareWorld();
        breakBricks.setBricks(10, 3);

        breakBricks.run();
    }
}
