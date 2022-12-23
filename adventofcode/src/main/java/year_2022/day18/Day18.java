package year_2022.day18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import utilities.Problem;
import utilities.Triplet;

public class Day18 extends Problem<Integer> {

    int maxSize = 25;

    public Day18(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        // surface by cube = 6 * n - (adjacencies * 2)
        // x,y,z
        boolean[][][] space = new boolean[maxSize][maxSize][maxSize];

        int sa = 0;
        for (String s : input) {
            String[] saray = s.split(",");
            // x,y,z
            Triplet tri = new Triplet(Integer.valueOf(saray[0]) + 1, Integer.valueOf(saray[1]) + 1,
                    Integer.valueOf(saray[2]) + 1);
            sa += 6;
            sa -= 2 * adjacencies(tri, space);
            space[tri.x][tri.y][tri.z] = true;
        }
        // sa == total surface area
        System.out.println("Day 18 Part 1: " + sa);
        return calculateExternalSurfaceArea(space);
    }

    private int calculateExternalSurfaceArea(boolean[][][] space) {
        Stack<Triplet> toInvestigate = new Stack<>();
        toInvestigate.push(new Triplet(0, 0, 0));

        Set<Triplet> visited = new HashSet<>();
        visited.add(new Triplet(0, 0, 0));

        int sa = 0;
        while (!toInvestigate.isEmpty()) {
            Triplet t = toInvestigate.pop();
            sa += adjacencies(t, space);

            // we want to add all inbound, adjacent cubes that are not visited
            List<Triplet> toAdd = new ArrayList<>();
            toAdd.add(new Triplet(t.x + 1, t.y, t.z));
            toAdd.add(new Triplet(t.x - 1, t.y, t.z));
            toAdd.add(new Triplet(t.x, t.y + 1, t.z));
            toAdd.add(new Triplet(t.x, t.y - 1, t.z));
            toAdd.add(new Triplet(t.x, t.y, t.z + 1));
            toAdd.add(new Triplet(t.x, t.y, t.z - 1));

            for (Triplet trip : toAdd) {
                Boolean outOfBounds = trip.x < 0 || trip.y < 0 || trip.z < 0
                        || trip.x > maxSize - 1 || trip.y > maxSize - 1 || trip.z > maxSize - 1;
                if (!outOfBounds
                        && !space[trip.x][trip.y][trip.z]
                        && !visited.contains(trip)) {
                    toInvestigate.add(trip);
                    visited.add(trip);
                }

            }

        }
        return sa;
    }

    private int adjacencies(Triplet tri, boolean[][][] space) {
        int adjacentCubes = 0;
        // x + 1, x - 1
        if (tri.x < maxSize - 1 && space[tri.x + 1][tri.y][tri.z]) {
            adjacentCubes++;
        }
        if (tri.x > 0 && space[tri.x - 1][tri.y][tri.z]) {
            adjacentCubes++;
        }

        // y + 1, y - 1
        if (tri.y < maxSize - 1 && space[tri.x][tri.y + 1][tri.z]) {
            adjacentCubes++;
        }
        if (tri.y > 0 && space[tri.x][tri.y - 1][tri.z]) {
            adjacentCubes++;
        }

        // z + 1, z - 1;
        if (tri.z < maxSize - 1 && space[tri.x][tri.y][tri.z + 1]) {
            adjacentCubes++;
        }
        if (tri.z > 0 && space[tri.x][tri.y][tri.z - 1]) {
            adjacentCubes++;
        }
        return adjacentCubes;
    }
}
