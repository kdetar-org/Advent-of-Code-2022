package year_2022.day12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MapTraveller {

    Cell[][] map;
    Cell start, goal;
    int maxY, maxX;
    Set<String> visited;

    public MapTraveller(List<String> input) {
        maxY = input.size();
        maxX = input.get(0).length();

        map = new Cell[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {

                char square = input.get(y).charAt(x);
                switch (square) {
                    case 'S':
                        start = new Cell(y, x, 'a');
                        map[y][x] = start;
                        break;
                    case 'E':
                        goal = new Cell(y, x, 'z');
                        map[y][x] = goal;
                        break;
                    default:
                        map[y][x] = new Cell(y, x, square);
                }
            }
        }
    }

    public int findFewestSteps() {
        Cell cur = start;

        visited = new HashSet<String>();
        visited.add(cur.getHash());

        Queue<Cell> toGo = new LinkedList<>();
        toGo.add(cur);
        visited.add(cur.getHash());

        while (cur != goal && !toGo.isEmpty()) {
            cur = toGo.poll();
            // up
            if (cur.y - 1 >= 0 && canMove(cur, map[cur.y - 1][cur.x])) {
                toGo.add(map[cur.y - 1][cur.x].setSteps(cur.steps + 1));
                visited.add(map[cur.y - 1][cur.x].getHash());
            }
            // right
            if (cur.x + 1 < maxX && canMove(cur, map[cur.y][cur.x + 1])) {
                toGo.add(map[cur.y][cur.x + 1].setSteps(cur.steps + 1));
                visited.add(map[cur.y][cur.x + 1].getHash());
            }
            // down
            if (cur.y + 1 < maxY && canMove(cur, map[cur.y + 1][cur.x])) {
                toGo.add(map[cur.y + 1][cur.x].setSteps(cur.steps + 1));
                visited.add(map[cur.y + 1][cur.x].getHash());
            }
            // left
            if (cur.x - 1 >= 0 && canMove(cur, map[cur.y][cur.x - 1])) {
                toGo.add(map[cur.y][cur.x - 1].setSteps(cur.steps + 1));
                visited.add(map[cur.y][cur.x - 1].getHash());
            }
        }
        return goal.steps;
    }

    private Boolean canMove(Cell cur, Cell next) {
        Boolean canMove = (cur.height - next.height >= -1) && !visited.contains(next.getHash()); 
        return canMove;
    }

    private class Cell {
        int x, y;
        int height;
        int steps;

        Cell(int y, int x, char height) {
            steps = 0;
            this.x = x;
            this.y = y;
            this.height = height - 'a';
        }

        String getHash() {
            return x + "," + y;
        }

        Cell setSteps(int steps) {
            this.steps = steps;
            return this;
        }
    }

    public void print() {
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                int h = map[y][x].height;
                if (h > 9) {
                    System.out.print("[" + h + "]");
                } else {
                    System.out.print("[ " + h + "]");
                }
            }
            System.out.println();
        }
    }
}
