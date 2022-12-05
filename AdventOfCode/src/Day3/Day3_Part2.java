package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utilities.Problem;

public class Day3_Part2 extends Problem<Integer> {

    private BufferedReader br;

    public Day3_Part2(String resource) {
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
        List<Character> toSum = new ArrayList<Character>();

        for (int i = 0; i < input.size(); i += 3) {
            Set<Character> set1 = new HashSet<Character>();
            Set<Character> set2 = new HashSet<Character>();

            // set1 populate
            String str1 = input.get(i);
            for (int j = 0; j < str1.length(); j++) {
                set1.add(str1.charAt(j));
            }

            // set2 populate
            String str2 = input.get(i + 1);
            for (int j = 0; j < str2.length(); j++) {
                set2.add(str2.charAt(j));
            }

            String str3 = input.get(i + 2);
            for (int j = 0; j < str3.length(); j++) {
                if (set1.contains(str3.charAt(j)) && set2.contains(str3.charAt(j))) {
                    toSum.add(str3.charAt(j));
                    break;
                }
            }

        }
        for (Character c : toSum) {
            // System.out.println(c);
            if (Character.isLowerCase(c)){
                sum += c - 96; 
            } else {
                sum += c - 38; 
            }
        }
        return sum;
    }

}
