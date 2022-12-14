package year_2022.day13;

import java.util.ArrayList;
import java.util.List;

public class DistressSignalProcessor {

    List<String[]> pairs;

    public DistressSignalProcessor(List<String> input) {
        pairs = new ArrayList<>();
        for (int i = 0; i < input.size(); i += 3) {
            String[] toAdd = new String[2];
            toAdd[0] = input.get(i);
            toAdd[1] = input.get(i + 1);
            pairs.add(toAdd);
        }
    }

    public int getNumberInOrder() {
        int numInOrder = 0;
        for (int i = 0 ; i < pairs.size(); i++) {
            numInOrder = inOrder(pairs.get(i)[0], pairs.get(i)[1]) ? numInOrder + (i+1) : numInOrder;
        }
        return numInOrder;
    }

    public boolean inOrder(String a, String b) {
        String[]aStrArr = a.replace("[","").replace("]","").split(",");
        String[]bStrArr = b.replace("[","").replace("]","").split(",");

        if(aStrArr[0] == "" || bStrArr[0] == ""){
            return a.length() < b.length();
        }
        
        for(int i = 0 ; i < a.length(); i ++){
            if( i >= aStrArr.length){
                return true;
            } else if(i >= bStrArr.length){
                return false;
            } else if( Integer.valueOf(aStrArr[i]) != Integer.valueOf(bStrArr[i])){
                return Integer.valueOf(aStrArr[i]) < Integer.valueOf(bStrArr[i]);
            } 
        }

        return true;
    }
}
