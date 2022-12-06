package Day2;

import Utilities.Problem;

public class Day2_Part1 extends Problem<Integer>{

    public Day2_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        int points = 0;

        //1 for rock, 2 for paper, 3 for scissors
        for(String s : input){
            points += (compare(s.charAt(0),s.charAt(2))+1)*3; //win
            points+= s.charAt(2)-'W'; //shape
        }
        return points;
    }

    public int compare(Character them, Character me) {
        int val1 = them -'A';    
        int val2 = me -'X';

        int calc = val2-val1;
        if(Math.abs(calc) == 1){
            return calc;
        }
        return -1 * (calc/2);
    }
}
