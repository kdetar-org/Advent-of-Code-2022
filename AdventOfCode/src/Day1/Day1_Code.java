package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Day1_Code{

    //elves are 1 indexed, not 0
    public static int part1(){
        try (FileReader fr = new FileReader(new File("resources/Day1_Calories.txt"))) {
            BufferedReader br = new BufferedReader(fr);
            
            String oneSnack = br.readLine();
            int maxCalories = 0;
            int curCalories = 0;
            while(oneSnack != null){
                if(oneSnack.isEmpty()){
                    maxCalories = Math.max(maxCalories, curCalories);
                    curCalories = 0;
                } else {
                    curCalories += Integer.parseInt(oneSnack);
                }
                oneSnack = br.readLine();
            }
            return maxCalories;
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    
    //we want top 3, sounds like a size 3 max heap to me
    public static int part2(){
        try (FileReader fr = new FileReader(new File("resources/Day1_Calories.txt"))) {
            BufferedReader br = new BufferedReader(fr);

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, Collections.reverseOrder());
            
            String oneSnack = br.readLine();
            int curCalories = 0;
            while(oneSnack != null){
                if(oneSnack.isEmpty()){
                    maxHeap.add(curCalories);
                    curCalories = 0;
                } else {
                    curCalories += Integer.parseInt(oneSnack);
                }
                oneSnack = br.readLine();
            }
            return maxHeap.remove() + maxHeap.remove() + maxHeap.remove() ;
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
