package Year_2022.Day3;

import java.util.HashSet;
import java.util.Set;

import Utilities.Problem;

public class Day3_Part1 extends Problem<Integer>{

    public Day3_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(String s : input){
            // System.out.println(s);
            //first half
            Set<Character> set = new HashSet<Character>();
            for(int i = 0; i < s.length()/2; i++){
                set.add(s.charAt(i));
            } 
            //second half
            for(int i = s.length()/2; i < s.length(); i ++){
                char c = s.charAt(i);
                if(set.remove(c)){
                    if (Character.isLowerCase(c)){
                        sum += c - 96; 
                        // System.out.print(c);
                        // System.out.println(c-96);
                    } else {
                        sum += c - 38; 
                        // System.out.print(c);
                        // System.out.println(c-38);
                    }
                }
            }
        }
        return sum;
    }

}
