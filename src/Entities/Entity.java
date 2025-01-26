package Entities;

import java.io.Serializable;

public abstract class Entity implements Cloneable{
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public Entity() {}

    @Override
    public Entity clone() {
        try {
            return (Entity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
