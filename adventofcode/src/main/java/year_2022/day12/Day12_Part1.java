package year_2022.day12;

import utilities.Problem;

public class Day12_Part1 extends Problem<Integer> {

    public Day12_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        MapTraveller map = new MapTraveller(input);
        return map.findFewestSteps();
    }
}