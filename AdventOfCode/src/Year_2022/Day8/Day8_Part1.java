package Year_2022.Day8;

import Utilities.Problem;

public class Day8_Part1 extends Problem<Integer> {

    public Day8_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        int rows = input.size();
        int cols = input.get(0).length();
        int[][] trees = new int[rows][cols];
        boolean[][] visible = new boolean [rows][cols];

        //From left
        for(int row = 0 ; row < rows; row ++){
            int localMax = input.get(row).charAt(0) - '0';
            for(int col = 0 ; col < cols; col ++){
                
                trees[row][col] = input.get(row).charAt(col) - '0';
                if(localMax < trees[row][col] ){
                    visible[row][col] = true;
                    localMax = trees[row][col];
                }
            }
        }

        //From top
        for(int col = 0 ; col < cols; col ++){
            int localMax = trees[0][col];
            for(int row = 0 ; row < rows; row ++){
                if(localMax < trees[row][col] ){
                    visible[row][col] = true;
                    localMax = trees[row][col];
                }
            }
        }

        //From right
        for(int row = 0 ; row < rows; row ++){
            int localMax = trees[row][cols-1];
            for(int col = cols-1 ; col >= 0; col --){
                trees[row][col] = input.get(row).charAt(col) - '0';
                if(localMax < trees[row][col] ){
                    visible[row][col] = true;
                    localMax = trees[row][col];
                }
            }
        }

        //From bottom
        for(int col = 0 ; col < cols; col ++){
            int localMax = trees[rows-1][col];
            for(int row = rows-1 ; row >= 0 ; row --){
                if(localMax < trees[row][col] ){
                    visible[row][col] = true;
                    localMax = trees[row][col];
                }
            }
        }

        int count = 0;
        for(int row = 0 ; row < rows; row ++){
            for(int col = 0 ; col < trees[row].length; col ++){
                if(row == 0 || row == rows-1 || col == 0 || col == cols-1 || visible[row][col]){
                    count++;
                }
            }
        }

        return count;
    }
}