package com.nhn;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhn.world.World;

public class Main {
    private static final int FRAME_WIDTH = 1600;
    private static final int FRAME_HEIGHT = 900;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Break Bricks");
        World world = new World(5);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(world);
        frame.setVisible(true);

        BreakBricks breakBricks = new BreakBricks(world);
        breakBricks.setBricks(10, 3);

        world.run();
    }
}
