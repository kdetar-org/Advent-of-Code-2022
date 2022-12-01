import java.util.concurrent.Callable;

import Day1.*;
public class App {
    final static String DAY1_INPUT = "resources/Day1_Calories.txt";

    public static void main(String[] args) throws Exception {
        System.out.println("\n -----Start of Block-----");
        
        
        runWithMetrics("\nDay1_Part1", new Day1_Part1(DAY1_INPUT));
        runWithMetrics("\nDay1_Part2", new Day1_Part2(DAY1_INPUT));


        System.out.println("\n -----End of Block-----\n"); 
    }
    

    public static void runWithMetrics(String problem, Callable input) throws Exception {
        long startTime = 0;
        long endTime = 0;
        long startingMemory = 0;
        long endingMemory = 0;
        long runTimeInNanoSeconds = -1;
        long memoryUsedInBytes = -1;

        System.gc(); //used to get heap memory measurement to behave
        startingMemory =Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        System.out.println(problem + input.call());
        endTime = System.nanoTime();
        endingMemory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        runTimeInNanoSeconds = (endTime - startTime);
        if((endingMemory != startingMemory) || memoryUsedInBytes == -1) {
          memoryUsedInBytes = endingMemory - startingMemory;
        }
        System.out.println("Time in Nanoseconds: " + runTimeInNanoSeconds);
        System.out.println("Memory Usage in Bytes: " + memoryUsedInBytes);
      }
}
