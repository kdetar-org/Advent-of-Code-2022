package utilities.shapes;

import utilities.Point;

public class Cross extends Shape{

    public Cross(Point origin) {
        super(origin);
    }

    @Override
    public void buildShape() {
        // plus shape
        //.#
        //###
        //O#

        area.add(new Point(origin.x + 1, origin.y));
        area.add(new Point(origin.x + 1, origin.y + 1));
        area.add(new Point(origin.x + 1, origin.y + 2));
        area.add(new Point(origin.x + 2, origin.y + 1));
        area.add(new Point(origin.x, origin.y + 1));
    }
    
    @Override
    public void shift(Point shiftValues){
        for(Point p : area){
            p.x = p.x + shiftValues.x;
            p.y = p.y + shiftValues.y;
        }
        origin.x = origin.x + shiftValues.x;
        origin.y = origin.y + shiftValues.y;
    }
}
