package Day5;

import Utilities.Problem;

public class Day5_Part1 extends Problem<String> {

    public Day5_Part1(String resource) {
        super(resource);
    }

    @Override
    public String call() throws Exception {
        int x = 0;
        while (!(input.get(x).isEmpty())) {
            x++;
        }

        String[] stackNumbers = input.get(x-1).split(" ");
        int size = Integer.parseInt(stackNumbers[stackNumbers.length - 1]);

        PresentWarehouse pw = new PresentWarehouse(size, input.subList(0, x - 1));
        for (String s : input.subList(x + 1, input.size())) {
            String[] split = s.split(" ");
            pw.move(
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[3]),
                    Integer.parseInt(split[5]),
                    false);
        }

        return pw.getTopBoxes();
    }
}