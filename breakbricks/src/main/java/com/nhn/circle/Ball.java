package com.nhn.circle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.nhn.state.Paintable;

public class Ball implements Paintable {
    private int x;
    private int y;
    private int radius;
    private Color color;
    
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = Color.ORANGE;
    }

    public Ball(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Rectangle getReagion() {
        return new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    @Override
    public int getCenterX() {
        return x;
    }

    @Override
    public int getCenterY() {
        return y;
    }
    
    @Override
    public void setCenterX(int x) {
        this.x = x;
    }

    @Override
    public void setCenterY(int y) {
        this.y = y;
    }

    @Override
    public int getMinX() {
        return getCenterX() - getWidth()/2;
    }
    
    @Override
    public int getMinY() {
        return getCenterY() - getHeight()/2;
    }
    
    @Override
    public int getMaxX() {
        return getCenterX() + getWidth()/2;
    }
    
    @Override
    public int getMaxY() {
        return getCenterY() + getHeight()/2;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int getWidth() {
        return getRadius() * 2;
    }

    @Override
    public int getHeight() {
        return getRadius() * 2;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getMinX(), getMinY(), getWidth(), getHeight());
    }

    @Override
    public String toString(){
        return new StringBuilder("Ball : x, y = (").append(getCenterX()).append(", ").append(getCenterY()).append(")")
                    .append(", radius = ").append(getRadius()).toString();
    }
}
