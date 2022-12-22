package utilities.shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utilities.Point;

public class Shape {

    protected List<Point> area;
    protected Point origin;
    
    public Shape(Point origin){
        area = new ArrayList<>();
        this.origin = origin;
        buildShape();
    }

    public List<Point> getArea(){
        return area;
    }

    public void buildShape(){
        // Default is square cube
        area.add(origin);
        area.add(new Point(origin.x, origin.y + 1));
        area.add(new Point(origin.x + 1, origin.y));
        area.add(new Point(origin.x + 1, origin.y + 1));
    }

    public void shift(Point shiftValues){
        for(Point p : area){
            p.x = p.x + shiftValues.x;
            p.y = p.y + shiftValues.y;
        }
    }

    public boolean isValid(Set<Point> shapeStack, Point shift){
        for(Point p : area){
            int moveX = p.x + shift.x;
            int moveY = p.y + shift.y;
            if (shapeStack.contains(new Point(moveX, moveY))){
                return false;
            } else if((moveX < 0 || moveX > 6) || moveY < 0){
                return false;
            }
        }
        return true;
    }

    public boolean slide(Set<Point> shapeStack, char direction){
        switch(direction){
            case '<':
                if(isValid(shapeStack, new Point(-1, 0))){
                    shift(new Point(-1, 0));
                }
                break;
            case '>':
                if(isValid(shapeStack, new Point(1, 0))){
                    shift(new Point(1, 0));
                }
            break;
        }
        return false;
    }

    public boolean fall(Set<Point> shapeStack){
            if(isValid(shapeStack, new Point(0, -1))){
                shift(new Point(0, -1));
                return true;
            }
        return false;
    }

    public int highestPoint(){
        int highest = 0;
        for(Point p : area){
            highest = Math.max(p.y, highest);
        }
        return highest;
    }

    public void printLocation(){
        for(Point p : area){
            System.out.print("("+p.x + ", " +  p.y+"),");
        }
        System.out.println();
    }

}
