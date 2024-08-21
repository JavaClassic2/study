package com.nhn.object;

import java.awt.Color;
import java.awt.Graphics;

public interface Paintable extends Reagionable{
    Color getColor();
    void setColor(Color color);

    void paint(Graphics g);
}
