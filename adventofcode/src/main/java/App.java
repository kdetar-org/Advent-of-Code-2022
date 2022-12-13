import year_2022.day11.*;
import year_2022.day1.*;
import year_2022.day2.*;
import year_2022.day3.*;
import year_2022.day4.*;
import year_2022.day5.*;
import year_2022.day6.*;
import year_2022.day7.*;
import year_2022.day8.*;
import year_2022.day9.*;
import year_2022.day10.*;



public class App {

    private static final String DAY1_INPUT = "Day1_Calories.txt";
    private static final String DAY2_INPUT = "Day2_Encoded_RPS.txt";
    private static final String DAY3_INPUT = "Day3_Rucksacks.txt";
    private static final String DAY4_INPUT = "Day4_Cleaning_Schedule.txt";
    private static final String DAY5_INPUT = "Day5_Crate_Stacks.txt";
    private static final String DAY6_INPUT = "Day6_Elf_Signal.txt";
    private static final String DAY6_FISHY_INPUT = "Day6_2021_LanternFish.txt";
    private static final String DAY7_INPUT = "Day7_DirectoryInput.txt";
    private static final String DAY8_INPUT = "Day8_Tree_Patch.txt";
    private static final String DAY9_INPUT = "Day9_Elfen_Rope_Dynamics.txt";
    private static final String DAY10_INPUT = "Day10_CRT.txt";
    private static final String DAY11_INPUT = "Day11_MonkeyBusiness.txt";

    
    public static void main(String[] args) throws Exception {
        
        System.out.println("\n -----Start of Block-----");
        // new Day1_Part1(DAY1_INPUT).callWithMetrics("day1 Part1: ");
        // new Day1_Part2(DAY1_INPUT).callWithMetrics("day1 Part2: ");
        

        // new Day2_Part1(DAY2_INPUT).callWithMetrics("\nday2 Part1: ");
        // new Day2_Part2(DAY2_INPUT).callWithMetrics("day2 Part2: ");
        
        // new Day3_Part1(DAY3_INPUT).callWithMetrics("\nday3 Part1: ");
        // new Day3_Part2(DAY3_INPUT).callWithMetrics("day3 Part2: ");
        
        // new Day4_Part1(DAY4_INPUT).callWithMetrics("\nday4 Part1: ");
        // new Day4_Part2(DAY4_INPUT).callWithMetrics("day4 Part2: ");
        

        // new Day5_Part1(DAY5_INPUT).callWithMetrics("\nday5 Part1: ");
        // new Day5_Part2(DAY5_INPUT).callWithMetrics("day5 Part2: ");
        
        // new Day6_Part1(DAY6_INPUT).callWithMetrics("\nday6 Part1: ");
        // new Day6_Part2(DAY6_INPUT).callWithMetrics("day6 Part2: ");
        // //Last Year's day6
        // new day6(DAY6_FISHY_INPUT).callWithMetrics("\nday6 2021: ");

        // new Day7_Part1(DAY7_INPUT).callWithMetrics("\nday7 Part1: ");
        // new Day7_Part2(DAY7_INPUT).callWithMetrics("day7 Part2: ");

        // new Day8_Part1(DAY8_INPUT).callWithMetrics("\nday8 Part1: ");
        // new Day8_Part2(DAY8_INPUT).callWithMetrics("day8 Part2: ");

        //new Day9_Part1(DAY9_INPUT).callWithMetrics("\nday9 Part1: ");
        //new Day9_Part2(DAY9_INPUT).callWithMetrics("day9 Part2: ");

        //new Day10_Part1(DAY10_INPUT).callWithMetrics("\nday10 Part1: ");
        //new Day10_Part2(DAY10_INPUT).callWithMetrics("day10 Part2: \n");

        new Day11_Part1(DAY11_INPUT).callWithMetrics("\nday11 Part1: ");
        new Day11_Part2(DAY11_INPUT).callWithMetrics("day11 Part2: ");

        System.out.println("\n -----End of Block-----\n"); 

    }
}
