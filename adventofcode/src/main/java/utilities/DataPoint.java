package utilities;

public class DataPoint<I> extends Point{
    I value;

    public DataPoint (int x, int y, I value){
        super(x,y);
        this. value = value;
    }
}
