package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Utilities.Problem;

public class Day1_Part2 extends Problem<Integer> {

    private BufferedReader br;
    public Day1_Part2(String resource) {
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
        int [] top3 = new int[3];
        
        int curCalories = 0;
        int swap = -1;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isEmpty()) {
                //We insert into array
                for(int j = 0; j < 3; j ++){
                    if(curCalories > top3[j]){
                      swap = top3[j];
                      top3[j] = curCalories;
                      curCalories = swap;   
                    }
                }
                curCalories = 0;
            } else {
                curCalories += Integer.parseInt(input.get(i));
            }
        }
        return (top3[0] + top3[1] + top3[2]);

    }
}
