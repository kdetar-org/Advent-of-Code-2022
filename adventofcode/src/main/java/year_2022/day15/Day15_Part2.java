package year_2022.day15;

import utilities.Problem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.Point;
import utilities.Range;

public class Day15_Part2 extends Problem<Long> {

    public Day15_Part2(String resource) {
        super(resource);
    }

    @Override
    public Long call() throws Exception {
        // set up our regex
        String patternString = "Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)";
        Pattern pattern = Pattern.compile(patternString);

        List<Point[]> beaconPairs = new ArrayList<>();
        
        for (String s : input) {
            // parse all of our inputs and create our points
            Matcher m = pattern.matcher(s);
            m.find();
            Point sensor = new Point(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)));
            Point beacon = new Point(Integer.valueOf(m.group(3)), Integer.valueOf(m.group(4)));

            Point[] toAdd = new Point[2];
            toAdd[0] = sensor;
            toAdd[1] = beacon;
            beaconPairs.add(toAdd);
        }
        
        // I need to store a Set that contains lists of ranges
        Map<Integer, List<Range>> rowOccupancy = new HashMap<>();

        // we have everything we need to calculate part1
        int i = 0;
        for (Point[] p : beaconPairs) {

            //Or distance is what determines our pyramid
            int distance = Math.abs(p[0].x - p[1].x) + Math.abs(p[0].y - p[1].y);

            // System.out.println("Building Point p" + i++ + ", time: " + ((System.nanoTime()-startTime)/ 1000000.0));

            // from -distance -1 -> + distance +1
            for (int y = (distance * -1); y <= distance; y++) {
                int yPos = p[0].y + y;
                int width = distance - Math.abs(y);
                
                // our range is from [sensor -x,sensor +x]
                Range newRange = new Range(p[0].x - width, p[0].x + width);

                if (!rowOccupancy.containsKey(yPos)) {
                    rowOccupancy.put(Integer.valueOf(yPos), new ArrayList<Range>());
                }

                rowOccupancy.get(Integer.valueOf(yPos)).add(newRange);
            }
        }
        
        Long x = Long.valueOf(0);
        Long y = Long.valueOf(0);
        // merge our ranges
        for(int key : rowOccupancy.keySet()){
            List<Range> lor = rowOccupancy.get(key);
            Collections.sort(lor);
            
            i = 0;
            while (i < lor.size() - 1) {
                // try to merge two ranges
                if (lor.get(i).merge(lor.get(i + 1))) {
                    lor.remove(i + 1);
                }
                // if we fail we move on
                else {
                    i++;
                }
            }

            if(lor.get(0).boundedSize(0,4000000) != 4000000){
                x = Long.valueOf(lor.get(0).high+1);
                y = Long.valueOf(key);
                break;
            }
        }        
        //2,639,111,249,595
        return (x * 4000000) + y;
    }
}
