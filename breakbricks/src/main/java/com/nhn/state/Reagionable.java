package com.nhn.state;

import java.awt.Rectangle;

public interface Reagionable {
    Rectangle getReagion();

    int getCenterX();
    int getCenterY();

    void setCenterX(int x);
    void setCenterY(int y);

    int getMinX();
    int getMinY();

    int getMaxX();
    int getMaxY();

    int getWidth();
    int getHeight();
}
