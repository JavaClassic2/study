package com.nhn.object;

public class Collision {
    private Movable movable;
    private String direction;

    public Collision(Movable movable, String direction) {
        this.movable = movable;
        this.direction = direction;
    }

    public Movable getMovable() {
        return movable;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Collision 
                && ((Collision)o).getMovable().equals(getMovable())
                && ((Collision)o).getDirection().equals(getDirection());
    }

    @Override
    public int hashCode() {
        return movable.hashCode() + direction.hashCode();
    }

    
}
