package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class Day1_Part1 implements Callable<Integer> {
    BufferedReader br;

    public Day1_Part1(String resource) {
        try {
            FileReader fr = new FileReader(new File(resource));
            br = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        try {
            String oneSnack = br.readLine();
            int maxCalories = 0;
            int curCalories = 0;
            while (oneSnack != null) {
                if (oneSnack.isEmpty()) {
                    maxCalories = Math.max(maxCalories, curCalories);
                    curCalories = 0;
                } else {
                    curCalories += Integer.parseInt(oneSnack);
                }
                oneSnack = br.readLine();
            }
            return maxCalories;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
