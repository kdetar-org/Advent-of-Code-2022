package year_2022.day6;

import java.util.HashSet;
import java.util.Set;

import utilities.Problem;

public class Day6_Part1 extends Problem<Integer> {

    public Day6_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        int size = 4;
        String inboundSignal = input.get(0);
        for(; i < inboundSignal.length()-size+1; i++){
            Set<Character> signalFrag = new HashSet<>();
            for(int j = i; j < i+size; j ++){
                if(signalFrag.contains(inboundSignal.charAt(j))){
                    break;
                } else {
                    signalFrag.add(inboundSignal.charAt(j));
                }
            }
            if(signalFrag.size() == size){
                break;
            }
        }
        return i+size;
    }
}