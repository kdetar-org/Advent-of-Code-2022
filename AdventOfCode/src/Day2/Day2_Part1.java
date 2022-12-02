package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Utilities.Problem;

public class Day2_Part1 extends Problem<Integer>{

    private BufferedReader br;
    public Day2_Part1(String resource){
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
