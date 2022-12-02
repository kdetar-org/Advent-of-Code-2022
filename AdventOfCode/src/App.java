import Day1.*;
import Day2.*;
public class App {
    private static final String DAY1_INPUT = "resources/Day1_Calories.txt";
    private static final String DAY2_INPUT = "resources/Day2_Encoded_RPS.txt";

    public static void main(String[] args) throws Exception {
        
        System.out.println("\n -----Start of Block-----");
        // new Day1_Part1(DAY1_INPUT).callWithMetrics("Day1 Part1: ");
        // new Day1_Part2(DAY1_INPUT).callWithMetrics("Day2 Part2: ");
        new Day2_Part1(DAY2_INPUT).callWithMetrics("Day2 Part1: ");
        new Day2_Part2(DAY2_INPUT).callWithMetrics("Day2 Part2: ");
        
        
        System.out.println("\n -----End of Block-----\n"); 
    }
}
