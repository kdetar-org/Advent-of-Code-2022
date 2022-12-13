package year_2022.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utilities.Problem;

public class Day11_Part2 extends Problem<Long>{
    
    public Day11_Part2(String resource) {
        super(resource);
    }

    @Override
    public Long call() throws Exception {
        List<Monkey> troupe = new ArrayList<>();
        int testProduct = 1;

        for(int i = 0; i < input.size(); i += 7){

            //populate items
            String[] arrOfItemStr = input.get(i+1).trim().replace("Starting items: ","").split(", ");
            Long[] arrOfItem = new Long[arrOfItemStr.length];
            for(int j = 0; j < arrOfItemStr.length; j ++){
                arrOfItem[j] = Long.valueOf(arrOfItemStr[j]);
            }

            //items
            List<Long> listOfItems = new ArrayList<>(Arrays.asList(arrOfItem));

            //operation
            String op = input.get(i+2).trim().replace("Operation: new = ", "");

            //test
            int test = Integer.parseInt(input.get(i+3).trim().replace("Test: divisible by ", ""));
            testProduct *= test;
            int trueMonkey = input.get(i+4).charAt(input.get(i+4).length()-1)-'0';
            int falseMonkey = input.get(i+5).charAt(input.get(i+5).length()-1)-'0';
            troupe.add(new Monkey(listOfItems, op, test, trueMonkey, falseMonkey, 1));
        }

        //add the troupe to all the monkeys
        for(Monkey m : troupe){
            m.troupe = troupe;
            m.monkeyProduct = testProduct;
        }

        for(int i = 0 ; i < 10000; i ++){
            for(Monkey m : troupe){
                m.inspect();
            }        
        }

        Collections.sort(troupe);
        return Long.valueOf(troupe.get(0).monkeyBizCount) * Long.valueOf(troupe.get(1).monkeyBizCount);
    }
}
