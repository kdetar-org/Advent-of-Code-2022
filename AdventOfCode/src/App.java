import Day1.*;
public class App {
    final static String DAY1_INPUT = "resources/Day1_Calories.txt";

    public static void main(String[] args) throws Exception {
        Day1_Part1 d1 = new Day1_Part1(DAY1_INPUT);
        Day1_Part2 d2 = new Day1_Part2(DAY1_INPUT);

        d1.call();
        d2.call();
        
        System.out.println("\n -----Start of Block-----");
        
        d1.callWithMetrics("Day1_Part1: ");
        d2.callWithMetrics("Day1_Part2: ");

        System.out.println("\n -----End of Block-----\n"); 
    }
}
