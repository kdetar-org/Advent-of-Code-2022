package year_2022.day1;

import utilities.Problem;

public class Day1_Part1 extends Problem<Integer> {
    
    public Day1_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        int maxCalories = 0;
        int curCalories = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isEmpty()) {
                maxCalories = Math.max(maxCalories, curCalories);
                curCalories = 0;
            } else {
                curCalories += Integer.parseInt(input.get(i));
            }
        }
        return maxCalories;
    }
}
