package utilities.shapes;

import utilities.Point;

public class HorizontalLine extends Shape{

    public HorizontalLine(Point origin) {
        super(origin);
    }

    @Override
    public void buildShape() {
        area.add(origin);
        area.add(new Point(origin.x + 1, origin.y));
        area.add(new Point(origin.x + 2, origin.y));
        area.add(new Point(origin.x + 3, origin.y));
    }
    
}
