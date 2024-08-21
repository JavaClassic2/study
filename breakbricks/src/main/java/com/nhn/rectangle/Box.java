package com.nhn.rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.nhn.object.Paintable;

public class Box implements Paintable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    
    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.PINK;
    }

    public Box(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
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
        g.fillRect(getMinX(), getMinY(), getWidth(), getHeight());
    }

    @Override
    public String toString(){
        return new StringBuilder("Box : x, y = (").append(getCenterX()).append(", ").append(getCenterY()).append(")")
                    .append(", width, height = (").append(getWidth()).append(", ").append(getHeight()).append(")").toString();
    }
}
