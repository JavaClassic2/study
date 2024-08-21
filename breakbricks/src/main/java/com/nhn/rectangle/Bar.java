package com.nhn.rectangle;

import java.awt.Color;

import com.nhn.object.Controllable;

public class Bar extends Box implements Controllable {

    public Bar(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public Bar(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void moveTo(int x, int y) {
        setCenterX(x);
        setCenterY(y);
    }
    
}
