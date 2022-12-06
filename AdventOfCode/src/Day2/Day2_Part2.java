package Day2;

import java.util.List;
import Utilities.Problem;

public class Day2_Part2 extends Problem<Integer>{

    public Day2_Part2(String resource) {
        super(resource);
    }
    
    List<String> input;
    @Override
    public Integer call() throws Exception {
        int points = 0;
        int winLose;
        //1 for rock, 2 for paper, 3 for scissors
        for(String s : input){
            //X = 0, Y = 1, Z = 2;
            winLose = s.charAt(2)-'X'; 
            //Z To win, we need to shift 4
            //Y To tie, we need to shift 3
            //X To lose, we need to shift 2
            //A = 2, B = 3 , C = 4
            points += ((s.charAt(0)-'A' + winLose + 2)%3) + 1;
            points += winLose*3;
        }
        return points;
    }
}
