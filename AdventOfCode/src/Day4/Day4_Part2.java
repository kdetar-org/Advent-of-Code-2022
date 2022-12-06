package Day4;

import Utilities.Problem;

public class Day4_Part2 extends Problem<Integer>{

    public Day4_Part2(String resource) {
        super(resource);
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
