package Year_2022.Day7;

import java.util.HashMap;
import java.util.Map;

import Utilities.Problem;

public class Day7_Part1 extends Problem<Integer> {

    public Day7_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        String[] cmd = input.remove(0).split(" ");
        Map<String, ElfNode> map = new HashMap<String,ElfNode>();
        ElfNode elfNode = new ElfNode(0, cmd[2], input, map);
        elfNode.getSize();
        int sum = 0;
        for(ElfNode e : map.values()){
            if(e.path.charAt(e.path.length()-1) == '/' && e.size <= 100000)
                sum += e.size;
        }
        return sum;
    }
}