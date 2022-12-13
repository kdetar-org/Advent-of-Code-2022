package year_2022.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utilities.Problem;

public class Day9_Part2 extends Problem<Integer> {

    private final int ROPE_SIZE = 10;

    public Day9_Part2(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        Set<String> solutionSet = new HashSet<>();
        List<Pair> chain = new ArrayList<Pair>();
        for (int i = 0; i < ROPE_SIZE; i++) {
            chain.add(new Pair(0, 0));
        }

        //for all commands
        for (String s : input) {
            char direction = s.charAt(0);
            int magnitude = Integer.parseInt(s.substring(2));
            for (int i = 0; i < magnitude; i++) {
                switch (direction) {
                    case 'U':
                        chain.get(0).y++;
                        break;
                    case 'L':
                        chain.get(0).x--;
                        break;
                    case 'R':
                        chain.get(0).x++;
                        break;
                    case 'D':
                        chain.get(0).y--;
                        break;
                }

                //for every segment, do 1 move
                for (int j = 0; j < ROPE_SIZE-1; j++) {
                    move1Step(chain.get(j), chain.get(j + 1));
                }
                solutionSet.add(chain.get(ROPE_SIZE-1).getHash());
            }
        }
        return solutionSet.size();
    }

    public void move1Step(Pair head, Pair tail) {

        int xshift = Math.abs(head.x - tail.x);
        int yshift = Math.abs(head.y - tail.y);
        int newx = tail.x;
        int newy = tail.y;
        
        if(xshift > 1 ){
            newx = tail.x + (head.x > tail.x? xshift-1 : -1*xshift+1);
            if(yshift > 0)
                newy = tail.y + (head.y > tail.y ? 1 : -1);
        }else if(yshift > 1 ){
            newy = tail.y + (head.y > tail.y ? yshift-1 : -1*yshift+1);
            if(xshift > 0)
                newx = tail.x + (head.x > tail.x ? 1 : -1);
        }
        tail.x = newx;
        tail.y = newy;
    }

    private class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String getHash() {
            return x + "," + y;
        }
    }
}