package year_2022.day14;

import java.util.ArrayList;
import java.util.List;

import utilities.Point;
import utilities.Problem;

public class Day14_Part2 extends Problem<Integer> {

    public Day14_Part2(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        //Skip, this is awful
        List<Point[]> commands = new ArrayList<>();
        Point min = new Point(500, 0);
        Point max = new Point(500, 0);

        // 504,28 -> 509,28
        for(String s : input){

            // ["504,28","509,28"]
            String[] split = s.split(" -> ");

            // [[504,28],[509,28]]
            List<Point> points =  new ArrayList<>(); 
            for(int i = 0 ; i < split.length; i ++){
                String[] singlePoint = split[i].split(",");
                //create our points and track max/min points
                int x = Integer.valueOf(singlePoint[0]);
                int y = Integer.valueOf(singlePoint[1]);
                min.x = x < min.x ? x : min.x;
                min.y = y < min.y ? y : min.y;
                max.x = x > max.x ? x : max.x;
                max.y = y > max.y ? y : max.y;

                points.add(new Point(x,y));
            }

            // Pairs our commands up int to start stops
            for(int i = 0 ; i< points.size()-1; i ++){
                Point[] toAdd = new Point[2];
                toAdd[0] = points.get(i);
                toAdd[1] = points.get(i+1);
                commands.add(toAdd);
            }

        }
        SandChamber sc = new SandChamber(new Point(500,0), commands, min, max);
        int sand = sc.sandToFill();
        //sc.print();
        return sand;
    }
}
