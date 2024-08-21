package com.nhn.circle;

import java.awt.Color;

import com.nhn.state.Movable;

public class MovableBall extends Ball implements Movable {
    private int dx;
    private int dy;

    public MovableBall(int x, int y, int radius, Color color, int dx, int dy) {
        super(x, y, radius, color);
        this.dx = dx;
        this.dy = dy;
    }
    
    public MovableBall(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public MovableBall(int x, int y, int radius, Color color) {
        this(x, y, radius, color, 1, -1);
    }

    public MovableBall(int x, int y, int radius) {
        this(x, y, radius, 1, -1);
    }

    @Override
    public int getDx() {
        return dx;
    }

    @Override
    public int getDy() {
        return dy;
    }

    @Override
    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public void setDy(int dy) {
        this.dy = dy;
    }
    
    @Override
    public void reverseDx() {
        dx = -dx;
    }

    @Override
    public void reverseDy() {
        dy = -dy;
    }
        
    @Override
    public void move() {
        moveTo(getCenterX() + getDx(), getCenterY() + getDy());
    }

    @Override
    public void moveTo(int x, int y) {
        setCenterX(x);
        setCenterY(y);
    }
}
