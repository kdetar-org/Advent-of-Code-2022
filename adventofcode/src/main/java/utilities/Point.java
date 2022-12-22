package utilities;

import java.util.Objects;

public class Point{
    public int x;
    public int y;

    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object p){
        if(p instanceof Point)
            return ((Point)p).x == x && ((Point)p).y == y;
        return false;
    }
}
