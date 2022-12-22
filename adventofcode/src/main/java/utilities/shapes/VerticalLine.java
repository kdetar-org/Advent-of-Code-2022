package utilities.shapes;

import utilities.Point;

public class VerticalLine extends Shape{

    public VerticalLine(Point origin) {
        super(origin);
    }

    @Override
    public void buildShape() {
        //a line extending up
        area.add(origin);
        area.add(new Point(origin.x, origin.y + 1));
        area.add(new Point(origin.x, origin.y + 2));
        area.add(new Point(origin.x, origin.y + 3));
    }
    
}
