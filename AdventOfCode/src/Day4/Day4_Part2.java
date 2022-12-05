package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utilities.Problem;

public class Day4_Part2 extends Problem<Integer>{

    private BufferedReader br;
    public Day4_Part2(String resource){
        try {
            FileReader fr = new FileReader(new File(resource));
            br = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        prework();
    }

    List<String> input;
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

    @Override
    public Integer call() throws Exception {
        
        int sum = 0;
        for(String s : input){
            sum += intersect(s)? 1 : 0;
        }
        return sum;
    }

    public boolean intersect(String str){
        String[] regions = str.split(",");
        String[] range1 = regions[0].split("-");
        String[] range2 = regions[1].split("-");

        int r1Start = Integer.parseInt(range1[0]);
        int r1End = Integer.parseInt(range1[1]);
        int r2Start = Integer.parseInt(range2[0]);
        int r2End = Integer.parseInt(range2[1]);

        //range1 encompasses range2
        if(r1Start <= r2Start && r1End >= r2Start || r1Start <= r2End && r1End >= r2End){
            return true;
        } else if(r2Start <= r1Start && r2End >= r1Start || r2Start <= r1End && r2End >= r1End)
            return true;
        return false;
    }
}
