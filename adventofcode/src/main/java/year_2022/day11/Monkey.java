package year_2022.day11;

import java.util.List;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Monkey implements Comparable<Monkey>{

    List<Long> items;
    List<Monkey> troupe;

    String operation;
    int monkeyBizCount;
    int test;
    
    int monkeyTrue;
    int monkeyFalse;

    int worryDiv;
    int monkeyProduct;
    
    public Monkey(List<Long>items, String operation, int test, int monkeyTrue, int monkeyFalse, int worryDiv){
        monkeyProduct = 1;
        this.items = items;
        this.operation = operation;
        this.test = test;
        this.monkeyTrue = monkeyTrue;
        this.monkeyFalse = monkeyFalse;
        this.worryDiv = worryDiv;
    }

    public void inspect(){
        
        Long curItem; 
        while(items.size() > 0){
            monkeyBizCount++;

            //Always start at the start
            curItem = items.remove(0);
            String toEval = operation.replace("old", curItem + "");
            Expression ex = new ExpressionBuilder(toEval).build();

            //Monkey inspects the item
            Long result = (long)ex.evaluate();
            curItem = result/worryDiv;
            curItem = curItem % monkeyProduct;

            //Monkey tests my stress
            testAndToss(curItem);
        }
    }

    public void testAndToss(Long item){
        if(item % test == 0){
            toss(item, monkeyTrue);
        } else {
            toss(item, monkeyFalse);
        }
    }

    public void toss(Long item, int targetMonkey){
        troupe.get(targetMonkey).receive(item);
    }

    private void receive(Long item) {
        items.add(item);
    }

    @Override
    public int compareTo(Monkey other) {
        return other.monkeyBizCount - monkeyBizCount;
    }    
}
