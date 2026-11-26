package ru.suntsov.geometry;

public class PointExtended extends Point{
    private final int Z;

    public PointExtended(int new_X, int new_Y, int new_Z) {
        super(new_X, new_Y);
        this.Z = new_Z;
    }

    public int getZ() { return Z; }

    @Override
    public String toString(){
        return "{"+super.getX()+";"+super.getY()+";"+Z+"}";
    }    
}