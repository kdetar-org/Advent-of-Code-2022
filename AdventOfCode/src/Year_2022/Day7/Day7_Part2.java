package Year_2022.Day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utilities.Problem;

public class Day7_Part2 extends Problem<Integer> {

    public Day7_Part2(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        String[] cmd = input.remove(0).split(" ");
        Map<String, ElfNode> map = new HashMap<String,ElfNode>();
        ElfNode elfNode = new ElfNode(0, cmd[2], input, map);

        int memUsed = elfNode.getSize();
        int target = 30000000 - (70000000 - memUsed);

        List<ElfNode> directories = new ArrayList<>();
        for(ElfNode e : map.values()){
            if(e.path.charAt(e.path.length()-1) == '/')
                directories.add(e);
        }
        Collections.sort(directories);
        for(ElfNode dir : directories){
            if(dir.size > target)
                return dir.size;
        }
        return -1;
    }
}