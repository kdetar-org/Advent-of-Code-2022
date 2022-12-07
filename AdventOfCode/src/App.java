import Year_2021.Day6;
import Year_2022.Day1.*;
import Year_2022.Day2.*;
import Year_2022.Day3.*;
import Year_2022.Day4.*;
import Year_2022.Day5.*;
import Year_2022.Day6.*;


public class App {

    private static final String DAY1_INPUT = "resources/Day1_Calories.txt";
    private static final String DAY2_INPUT = "resources/Day2_Encoded_RPS.txt";
    private static final String DAY3_INPUT = "resources/Day3_Rucksacks.txt";
    private static final String DAY4_INPUT = "resources/Day4_Cleaning_Schedule.txt";
    private static final String DAY5_INPUT = "resources/Day5_Crate_Stacks.txt";
    private static final String DAY6_INPUT = "resources/Day6_Elf_Signal.txt";
    private static final String DAY6_FISHY_INPUT = "resources/Day6_2021_LanternFish.txt";
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("\n -----Start of Block-----");
        new Day1_Part1(DAY1_INPUT).callWithMetrics("Day1 Part1: ");
        new Day1_Part2(DAY1_INPUT).callWithMetrics("Day1 Part2: ");
        new Day2_Part1(DAY2_INPUT).callWithMetrics("\nDay2 Part1: ");
        new Day2_Part2(DAY2_INPUT).callWithMetrics("Day2 Part2: ");
        new Day3_Part1(DAY3_INPUT).callWithMetrics("\nDay3 Part1: ");
        new Day3_Part2(DAY3_INPUT).callWithMetrics("Day3 Part2: ");
        new Day4_Part1(DAY4_INPUT).callWithMetrics("\nDay4 Part1: ");
        new Day4_Part2(DAY4_INPUT).callWithMetrics("Day4 Part2: ");
        new Day5_Part1(DAY5_INPUT).callWithMetrics("\nDay5 Part1: ");
        new Day5_Part2(DAY5_INPUT).callWithMetrics("Day5 Part2: ");
        new Day6_Part1(DAY6_INPUT).callWithMetrics("\nDay6 Part1: ");
        new Day6_Part2(DAY6_INPUT).callWithMetrics("Day6 Part2: ");
        

        //Last Year's Advent
        new Day6(DAY6_FISHY_INPUT).callWithMetrics("\nDay6 2021: ");

                
        System.out.println("\n -----End of Block-----\n"); 
    }
}
