package com.nhn.rectangle;

import java.awt.Color;

import com.nhn.effect.GameOver;

public class GameOverBlock extends Box implements GameOver{

    public GameOverBlock(int x, int y, int width, int height) {
        super(x, y, width, height, new Color(0, 0, 0, 0));
    }

    public GameOverBlock(int width, int height) {
        super(width/2, height/2, width, height, new Color(255, 255, 255, 125));
    }

}
