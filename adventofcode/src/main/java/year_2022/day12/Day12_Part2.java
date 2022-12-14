package year_2022.day12;

import utilities.Problem;

public class Day12_Part2 extends Problem<Integer>{
    
    public Day12_Part2(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        MapTravellerFlip map = new MapTravellerFlip(input);
        return map.findFewestSteps();
    }
}
