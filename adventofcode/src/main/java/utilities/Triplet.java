package utilities;

import java.util.Objects;

public class Triplet {
    public int x,y,z;

    public Triplet(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z; 
    }
    @Override
    public int hashCode(){
        return Objects.hash(x,y,z);
    }

    @Override
    public boolean equals(Object p){
        if(p instanceof Triplet)
            return ((Triplet)p).x == x && ((Triplet)p).y == y && ((Triplet)p).z == z;
        return false;
    }
}
