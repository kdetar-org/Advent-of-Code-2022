import Day1.*;
import Day2.*;
import Day3.*;
import Day4.*;
import Day5.*;
public class App {
    private static final String DAY1_INPUT = "resources/Day1_Calories.txt";
    private static final String DAY2_INPUT = "resources/Day2_Encoded_RPS.txt";
    private static final String DAY3_INPUT = "resources/Day3_Rucksacks.txt";
    private static final String DAY4_INPUT = "resources/Day4_Cleaning_Schedule.txt";

    public static void main(String[] args) throws Exception {
        
        System.out.println("\n -----Start of Block-----");
        // new Day1_Part1(DAY1_INPUT).callWithMetrics("Day1 Part1: ");
        // new Day1_Part2(DAY1_INPUT).callWithMetrics("Day2 Part2: ");
        // new Day2_Part1(DAY2_INPUT).callWithMetrics("Day2 Part1: ");
        // new Day2_Part2(DAY2_INPUT).callWithMetrics("Day2 Part2: ");
        // new Day3_Part1(DAY3_INPUT).callWithMetrics("Day3 Part1: ");
        // new Day3_Part2(DAY3_INPUT).callWithMetrics("Day3 Part2: ");
        new Day4_Part1(DAY4_INPUT).callWithMetrics("Day4 Part1: ");
        new Day4_Part2(DAY4_INPUT).callWithMetrics("Day4 Part2: ");
        
        
        System.out.println("\n -----End of Block-----\n"); 
    }
}
