package com.nhn.rectangle;

import java.awt.Color;

import com.nhn.effect.Breakable;

public class Brick extends Box implements Breakable {

    public Brick(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    
    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
