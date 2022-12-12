import Year_2021.Day6;
import Year_2022.Day1.*;
import Year_2022.Day2.*;
import Year_2022.Day3.*;
import Year_2022.Day4.*;
import Year_2022.Day5.*;
import Year_2022.Day6.*;
import Year_2022.Day7.*;
import Year_2022.Day8.*;
import Year_2022.Day9.Day9_Part1;
import Year_2022.Day9.Day9_Part2;



public class App {

    private static final String DAY1_INPUT = "resources/Day1_Calories.txt";
    private static final String DAY2_INPUT = "resources/Day2_Encoded_RPS.txt";
    private static final String DAY3_INPUT = "resources/Day3_Rucksacks.txt";
    private static final String DAY4_INPUT = "resources/Day4_Cleaning_Schedule.txt";
    private static final String DAY5_INPUT = "resources/Day5_Crate_Stacks.txt";
    private static final String DAY6_INPUT = "resources/Day6_Elf_Signal.txt";
    private static final String DAY6_FISHY_INPUT = "resources/Day6_2021_LanternFish.txt";
    private static final String DAY7_INPUT = "resources/Day7_DirectoryInput.txt";
    private static final String DAY8_INPUT = "resources/Day8_Tree_Patch.txt";
    private static final String DAY9_INPUT = "resources/Day9_Elfen_Rope_Dynamics.txt";

    
    public static void main(String[] args) throws Exception {
        
        System.out.println("\n -----Start of Block-----");
        // new Day1_Part1(DAY1_INPUT).callWithMetrics("Day1 Part1: ");
        // new Day1_Part2(DAY1_INPUT).callWithMetrics("Day1 Part2: ");
        

        // new Day2_Part1(DAY2_INPUT).callWithMetrics("\nDay2 Part1: ");
        // new Day2_Part2(DAY2_INPUT).callWithMetrics("Day2 Part2: ");
        
        // new Day3_Part1(DAY3_INPUT).callWithMetrics("\nDay3 Part1: ");
        // new Day3_Part2(DAY3_INPUT).callWithMetrics("Day3 Part2: ");
        
        // new Day4_Part1(DAY4_INPUT).callWithMetrics("\nDay4 Part1: ");
        // new Day4_Part2(DAY4_INPUT).callWithMetrics("Day4 Part2: ");
        

        // new Day5_Part1(DAY5_INPUT).callWithMetrics("\nDay5 Part1: ");
        // new Day5_Part2(DAY5_INPUT).callWithMetrics("Day5 Part2: ");
        
        // new Day6_Part1(DAY6_INPUT).callWithMetrics("\nDay6 Part1: ");
        // new Day6_Part2(DAY6_INPUT).callWithMetrics("Day6 Part2: ");
        // //Last Year's Day6
        // new Day6(DAY6_FISHY_INPUT).callWithMetrics("\nDay6 2021: ");

        // new Day7_Part1(DAY7_INPUT).callWithMetrics("\nDay7 Part1: ");
        // new Day7_Part2(DAY7_INPUT).callWithMetrics("Day7 Part2: ");

        // new Day8_Part1(DAY8_INPUT).callWithMetrics("\nDay8 Part1: ");
        // new Day8_Part2(DAY8_INPUT).callWithMetrics("Day8 Part2: ");

        new Day9_Part1(DAY9_INPUT).callWithMetrics("\nDay9 Part1: ");
        new Day9_Part2(DAY9_INPUT).callWithMetrics("Day9 Part2: ");

        System.out.println("\n -----End of Block-----\n"); 

    }
}
