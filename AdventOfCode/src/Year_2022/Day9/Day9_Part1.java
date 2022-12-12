package Year_2022.Day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utilities.Problem;

public class Day9_Part1 extends Problem<Integer> {

    private final int ROPE_SIZE = 2;

    public Day9_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        Set<String> solutionSet = new HashSet<>();
        solutionSet.add("0,0");

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
                for (int j = 0; j < ROPE_SIZE-1; j++) {
                    move1Step(chain.get(j), chain.get(j + 1));
                }
                solutionSet.add(chain.get(ROPE_SIZE-1).getHash());
            }
        }
        return solutionSet.size();
    }

    public void move1Step(Pair head, Pair tail) {

        int xshift = head.x - tail.x;
        int yshift = head.y - tail.y;

        // Head is above tail by > 1
        if (yshift == 2) {
            tail.x += xshift;
            tail.y ++;
        }

        // Head is right of tail by > 1
        else if (xshift  == 2) {
            tail.x ++;
            tail.y += yshift;
        }

        // Head is below tail by > 1
        else if (yshift == -2) {
            tail.x += xshift;
            tail.y --;
        }

        // Head is left of tail by > 1
        else if (xshift == -2) {
            tail.x --;
            tail.y += yshift;
        }
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