package com.nhn.object;

public interface Movable extends Paintable{
    int getDx();
    int getDy();

    void setDx(int dx);
    void setDy(int dy);

    void reverseDx();
    void reverseDy();

    void move();
    void moveTo(int x, int y);
}
