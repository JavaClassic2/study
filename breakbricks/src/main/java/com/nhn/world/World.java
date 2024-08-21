package com.nhn.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JPanel;

import com.nhn.effect.Breakable;
import com.nhn.effect.GameOver;
import com.nhn.rectangle.GameOverBlock;
import com.nhn.state.Collision;
import com.nhn.state.Movable;
import com.nhn.state.Paintable;
import com.nhn.state.Reagionable;

public class World extends JPanel {
    private static final int DEFAULT_DT = 10;
    private static final Logger log = Logger.getLogger("World");

    private int dt;
    private List<Reagionable> regionableList;
    private List<Reagionable> breakList;
    private List<Collision> collisionList;

    public World() {
        this(DEFAULT_DT);
    }

    public World(int dt) {
        super();
        this.dt = dt;
        this.regionableList = new ArrayList<>();
    }

    public void add(Reagionable r) {
        regionableList.add(r);
        repaint();
        log.info("world.add(" + r + ")");
    }
    
    public void remove(Reagionable r) {
        regionableList.remove(r);
        repaint();
        log.info("world.remove(" + r + ")");
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                move();
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void move() {
        breakList = new ArrayList<>();
        collisionList = new ArrayList<>();

        for (Reagionable r : regionableList){
            if (r instanceof Movable) {
                Movable m = (Movable)r;
                m.move();
                checkOutOfBounds(m);
                
                for (Reagionable other: regionableList) {
                    if (!r.equals(other))
                    checkCollision(m, other);
                }

                repaint();
            }
        }

        for (Reagionable r : breakList) {
            remove(r);
        }

        for (Collision c : collisionList) {
            if (c.getDirection().equals("x")) {
                c.getMovable().reverseDx();;
            } else {
                c.getMovable().reverseDy();
            }
        };
    }

    public void checkOutOfBounds(Movable m){
        if (m.getMinX() < getBounds().getMinX()) {
            m.reverseDx();
            m.moveTo((int)getBounds().getMinX() + m.getWidth()/2, m.getCenterY());
        }
    
        if (m.getMaxX() > getBounds().getMaxX()) {
            m.reverseDx();
            m.moveTo((int)getBounds().getMaxX() - m.getWidth()/2, m.getCenterY());
        }
        
        if (m.getMinY() < getBounds().getMinY()) {
            m.reverseDy();
            m.moveTo(m.getCenterX(), (int)getBounds().getMinY() + m.getHeight()/2);
        }
        
        if (m.getMaxY() > getBounds().getMaxY()) {
            m.reverseDy();
            m.moveTo(m.getCenterX(), (int)getBounds().getMaxY() - m.getHeight()/2);
        }
    }

    public void checkCollision(Movable m, Reagionable r) {
        if (r.getReagion().intersects(m.getReagion())) {
            if (r instanceof Breakable) {
                breakList.add(r);
            }

            if (r instanceof GameOver) {
                System.out.println("Game Over");
                regionableList.add(new GameOverBlock(getWidth(), getHeight()));
                repaint();
                Thread.currentThread().interrupt();
            }

            bounce(m, r);
        }
    }

    private void bounce(Movable m, Reagionable r) {
        Rectangle collision = m.getReagion().intersection(r.getReagion());

        if (collision.getWidth() <= collision.getHeight()) {
            addCollision(m, "X");

            if (r instanceof Movable){
                addCollision(((Movable)r), "X");
            }
        }

        if (collision.getWidth() >= collision.getHeight()) {
            addCollision(m, "Y");

            if (r instanceof Movable){
                addCollision(((Movable)r), "Y");
            }
        }
    }

    private void addCollision(Movable m, String direction) {
        Collision c = new Collision(m, direction);

        if (!collisionList.contains(c)) {
            collisionList.add(c);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        for(Reagionable r : regionableList) {
            if (r instanceof Paintable){
                ((Paintable)r).paint(g);
            }
        }
    }

    
}
