package year_2022.day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.Point;
import utilities.Problem;
import utilities.Range;

public class Day15_Part1 extends Problem<Integer> {

    public Day15_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        // set up our regex
        String patternString = "Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)";
        Pattern pattern = Pattern.compile(patternString);

        List<Point[]> beaconPairs = new ArrayList<>();
        Set<String> beacons = new HashSet<>();
        
        Long startTime = System.nanoTime();
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
            beacons.add(toAdd[1].x + "," + toAdd[1].y);
        }

        System.out.println("Parsed input: " + ((System.nanoTime()-startTime)/ 1000000.0));
        startTime = System.nanoTime();
        
        // I need to store a Set that contains lists of ranges
        Map<Integer, List<Range>> rowOccupancy = new HashMap<>();

        // we have everything we need to calculate part1
        int i = 0;
        for (Point[] p : beaconPairs) {

            //Or distance is what determines our pyramid
            int distance = Math.abs(p[0].x - p[1].x) + Math.abs(p[0].y - p[1].y);

            System.out.println("Building Point p" + i++ + ", time: " + ((System.nanoTime()-startTime)/ 1000000.0));

            // from -distance -1 -> + distance +1
            for (int y = (distance * -1); y <= distance; y++) {
                int yPos = p[0].y + y;
                int width = distance - Math.abs(y);
                
                // our range is from [sensor -x,sensor +x]
                Range newRange = new Range(p[0].x - width, p[0].x + width);
                
                if(yPos > 4000000 || yPos < 0){
                    break;
                }

                if (!rowOccupancy.containsKey(yPos)) {
                    rowOccupancy.put(Integer.valueOf(yPos), new ArrayList<Range>());
                }

                rowOccupancy.get(Integer.valueOf(yPos)).add(newRange);
            }
        }
        System.out.println("Built ranges: " + ((System.nanoTime()-startTime)/ 1000000.0));
        startTime = System.nanoTime();
        
        
        int lookIndex = 2000000;
        int count = 0;
        // merge our ranges
        List<Range> lor = rowOccupancy.get(lookIndex);
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

        for (Range r : lor) {
            count += r.size();
        }
        
        System.out.println("merged ranges: " + ((System.nanoTime()-startTime)/ 1000000.0));
        startTime = System.nanoTime();
        
        // lor now contains the complete ranges for the row
        for (String beacon : beacons) {
            int x = Integer.valueOf(beacon.split(",")[0]);
            int y = Integer.valueOf(beacon.split(",")[1]);
            if (y == lookIndex) {
                for (Range r : lor) {
                    if (r.contains(x))
                        count--;
                }
            }
        }
        System.out.println("Removed Beacons: " + ((System.nanoTime()-startTime)/ 1000000.0));
        
        return count;
    }
}
