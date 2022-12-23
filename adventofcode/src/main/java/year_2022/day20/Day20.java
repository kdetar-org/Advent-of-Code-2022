package year_2022.day20;

import java.util.HashMap;
import java.util.Map;

import utilities.LinkedListLoop;
import utilities.Node;
import utilities.Problem;

public class Day20 extends Problem<String> {

    public Day20(String resource) {
        super(resource);
    }

    @Override
    public String call() throws Exception {
        Map<Integer, Node<Long>> indexMap = new HashMap<>();
        LinkedListLoop<Long> lll = new LinkedListLoop<>();
        // create map of original index to current index
        // add list of values
        int decoder = 811589153;
        int offset = decoder%input.size(); 
        for (int i = 0; i < input.size(); i++) {
            indexMap.put(i, lll.insert(Long.valueOf(input.get(i))*decoder));
        }
        
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < input.size(); i++) {

                int distance = (int) (indexMap.get(i).value % (lll.getSize()-1));
                lll.move(indexMap.get(i), distance);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        int zeroIndex = lll.getFirstIndex(Long.valueOf(0));
        Long a = lll.get(zeroIndex + 1000);
        Long b = lll.get(zeroIndex + 2000);
        Long c = lll.get(zeroIndex + 3000); 

        sb.append("\n"+ a + ", ");
        sb.append(b + ", ");
        sb.append(c);
        sb.append("\n SUM: " + (a+b+c));

        return sb.toString();
    }

}
