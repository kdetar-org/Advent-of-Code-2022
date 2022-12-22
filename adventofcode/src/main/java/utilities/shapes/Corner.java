package utilities.shapes;

import utilities.Point;

public class Corner extends Shape{

    public Corner(Point origin) {
        super(origin);
    }
    
    @Override
    public void buildShape() {
        // Left facing L
        area.add(origin);
        area.add(new Point(origin.x + 1, origin.y));
        area.add(new Point(origin.x + 2, origin.y));
        area.add(new Point(origin.x + 2, origin.y + 1));
        area.add(new Point(origin.x + 2, origin.y + 2));        
    }
    
}
