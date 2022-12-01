package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Utilities.Problem;

public class Day1_Part1 extends Problem<Integer> {
    BufferedReader br;

    public Day1_Part1(String resource) {
        try {
            FileReader fr = new FileReader(new File(resource));
            br = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        prework();
    }

    @Override
    protected void prework() {
        input = new ArrayList<String>();
        String line;
        try {
            line = br.readLine();

            while (line != null) {
                input.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> input;

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
