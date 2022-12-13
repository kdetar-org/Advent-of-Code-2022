package year_2022.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PresentWarehouse {

    List<LinkedList<Character>> stacks;
    int size;

    public PresentWarehouse(int size , List<String> rows){
        this.size = size;
        stacks = new ArrayList<>(size);
        for(int i = 0 ; i < size; i++){
            stacks.add(i, new LinkedList<Character>());
        }

        for(String s : rows){
            for(int i = 0; i < size; i++){
                if(s.charAt((i*4) + 1) != ' '){
                    stacks.get(i).add(s.charAt((i*4) + 1));
                }
            }
        }
    }

    public void move(int quantity, int from, int to, Boolean reverse){
        LinkedList<Character> toMove = stacks.get(from-1);
        LinkedList<Character> sub = new LinkedList<>(toMove.subList(0, quantity));
        
        //Whether we reverse the moved boxes (whether we move 1 at a time)
        if(reverse) Collections.reverse(sub);

        //We add all of our boxes to the
        for(Character c : sub){
            stacks.get(to-1).addFirst(c);
            toMove.removeFirstOccurrence(c);
        }
    }

    public String getTopBoxes(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < size; i++){
            sb.append(stacks.get(i).get(0));
        }
        return sb.toString();
    }

    public void printStacks(){
        int index = 1;
        for(LinkedList<Character> l : stacks){
            System.out.print(index + " | ");
            for(Character c : l){
                System.out.print(" [" + c + "] ");
            }
            index ++;
            System.out.println();
        }
        System.out.println();
    }
    
}
