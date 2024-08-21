package com.nhn.world;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import com.nhn.circle.MovableBall;
import com.nhn.rectangle.Bar;
import com.nhn.rectangle.Brick;
import com.nhn.rectangle.GameOverBlock;

public class BreakBricks extends World{
    private Bar bar;
    MovableBall ball;

    public BreakBricks() {
        super();
    }
    
    public BreakBricks(int dt) {
        super(dt);
    }

    public void prepareWorld(){
        bar = new Bar(getWidth()/2, getHeight()*8/9, getWidth()/5, getHeight()/50);
        add(bar);

        MovableBall ball = new MovableBall(getWidth()/2, (getHeight()*8/9)-(getHeight()/50)*3/2, getHeight()/50);
        add(ball);

        GameOverBlock overBlock = new GameOverBlock(getWidth()/2, getHeight()*49/50, getWidth(), getHeight()/50);
        add(overBlock);

        addEvent();
    }

    private void addEvent() {
        setFocusable(true);
        requestFocus();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    bar.moveTo(bar.getCenterX()-getHeight()/50, bar.getCenterY());
                }

                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    bar.moveTo(bar.getCenterX()+getHeight()/50, bar.getCenterY());
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               super.mouseDragged(e);
               bar.moveTo(e.getX(), bar.getCenterY());
           } 
        });

    }

    /**
     * 상단에 x * y 개의 벽돌을 d 간격으로 생성
     * @param x 가로줄에 위치할 블록 갯수 
     * @param y 세로줄에 위치할 블록 갯수
     */
    public void setBricks(int x, int y) {
        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                Brick brick = new Brick((getWidth()/2/x)*(1+2*j), getHeight()/20*(1+2*i), getWidth()/x-10, getHeight()/10-10);
                add(brick);
            }
        }
    }

    /**
     * 상단에 x * y 개의 벽돌을 d 간격으로 생성
     * @param x 가로줄에 위치할 블록 갯수
     * @param y 세로줄에 위치할 블록 갯수
     * @param d 벽돌 사이 간격 (가로, 세로 간격은 동일함)
     */
    public void setBricks(int x, int y, int d) {
        int width = getWidth()/x;
        int height = getHeight()/10;

        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                Brick brick = new Brick((width/2)*(1+2*j), height/2*(1+2*i), width-d, height-d);
                add(brick);
            }
        }
    }
}