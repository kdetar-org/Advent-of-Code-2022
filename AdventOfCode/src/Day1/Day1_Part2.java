package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;

public class Day1_Part2 implements Callable<Integer> {

    BufferedReader br;

    public Day1_Part2(String resource) {
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
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, Collections.reverseOrder());

            String oneSnack = br.readLine();
            int curCalories = 0;
            while (oneSnack != null) {
                if (oneSnack.isEmpty()) {
                    maxHeap.add(curCalories);
                    curCalories = 0;
                } else {
                    curCalories += Integer.parseInt(oneSnack);
                }
                oneSnack = br.readLine();
            }
            return (maxHeap.remove() + maxHeap.remove() + maxHeap.remove());
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
