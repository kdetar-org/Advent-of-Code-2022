package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Utilities.Problem;

public class Day2_Part2 extends Problem<Integer>{

    private BufferedReader br;
    public Day2_Part2(String resource){
        try {
            FileReader fr = new FileReader(new File(resource));
            br = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        prework();
    }

    @Override
    protected void prework() {
        input = new ArrayList<String>();
        String line;
        try {
            line = br.readLine();

            while (line != null) {
                input.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
