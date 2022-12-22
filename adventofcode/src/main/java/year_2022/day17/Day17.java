package year_2022.day17;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import utilities.Point;
import utilities.Problem;
import utilities.shapes.*;

public class Day17 extends Problem<Integer> {
    
    public Day17(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {

        Set<Point> shapeStack = new HashSet<>();
        String commands = input.get(0);

        int verticalSpawnPoint = 3;
        int horizontalSpawnPoint = 2;
        int windex = 0;
        
        //1,000,000,000,000
        //579,710,143 full cycles
        //Missing 3,325 blocks = 5198
        //total heigh gained over 1T blocks = 1,566,376,811,584
        int prevHeight = 0;
        int spawnedShapes = 0;
        for(int i = 0; i < 3325; i ++){
            Shape shape = shapeEngine(horizontalSpawnPoint, verticalSpawnPoint);
            spawnedShapes++;
            do{
                char cmd = commands.charAt(windex% commands.length());
                windex++;

                if(windex % commands.length() == 0){
                    System.out.println("Spawned Shapes: " + spawnedShapes);
                    System.out.println("Height Gain: " + (verticalSpawnPoint - 3 - prevHeight));
                    prevHeight = verticalSpawnPoint - 3;
                    spawnedShapes = 0;
                }

                shape.slide(shapeStack, cmd);
            }while(shape.fall(shapeStack));

            //add to my stack of shapes
            for(Point p : shape.getArea()){
                shapeStack.add(p);
            }

            //printStack(shapeStack);

            verticalSpawnPoint = Math.max(verticalSpawnPoint, 4 + shape.highestPoint());    
        }

        return verticalSpawnPoint - 3;
    }

    private void printStack(Set<Point> shapeStack){
        Boolean printed = true;
        int row = 0;
        Stack<String> s = new Stack<>(); 

        while(printed || row < 4){
            StringBuilder sb = new StringBuilder();
            printed = false;
            for(int i = 0; i < 7; i ++){

                if(shapeStack.contains(new Point(i,row))){
                    sb.append("#");
                    printed = true;
                } else {
                    sb.append(".");
                }
            }
            s.push(sb.toString());
            row ++;
        }

        System.out.println("--------------------------");
        while(s.size() > 0){
            System.out.println(s.pop());
        }
        System.out.println("--------------------------\n");
    }

    private int shapeIndex = 0;
    private Shape shapeEngine(int x, int y){
        Shape shape;
        switch(shapeIndex){
            case 0:
                shape = new HorizontalLine(new Point(x, y));
                break;
            case 1:
                shape = new Cross(new Point(x, y));
            break;
            case 2:
                shape = new Corner(new Point(x, y));
            break;
            case 3:
                shape = new VerticalLine(new Point(x, y));
                break;
            default:
                shape = new Square(new Point(x, y));
            break;
        }
        shapeIndex = (shapeIndex+1)%5;
        return shape;
    }
}
