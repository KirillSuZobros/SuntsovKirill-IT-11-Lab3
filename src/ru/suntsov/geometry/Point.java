package ru.suntsov.geometry;

import java.util.Objects;

public class Point implements Cloneable{
    private final int X;
    private final int Y;

    public Point(int new_X, int new_Y) {
        this.X = new_X;
        this.Y = new_Y;
    }    

    public int getX() { return X; }
    public int getY() { return Y; }

    @Override
    public String toString(){
        return "{"+X+";"+Y+"}";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point)obj;
        return this.X == other.X && this.Y == other.Y;
    } 

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    
}