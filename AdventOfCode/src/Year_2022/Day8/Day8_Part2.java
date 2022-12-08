package Year_2022.Day8;

import Utilities.Problem;

public class Day8_Part2 extends Problem<Integer> {

    public Day8_Part2(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        int rows = input.size();
        int cols = input.get(0).length();
        int[][] trees = new int[rows][cols];
        
        for(int row = 0 ; row < rows; row ++){
            for(int col = 0 ; col < cols; col ++){                
                trees[row][col] = input.get(row).charAt(col) - '0';
            }
        }

        int maxScore = 0;
        for(int row = 1 ; row < rows-1; row ++){
            for(int col = 1 ; col < cols-1; col ++){                
                int curSize = trees[row][col];

                //Left flow
                int left = 0;
                int lookLeft = col;
                while(lookLeft > 0){
                    left++;
                    int tempVal = trees[row][--lookLeft]; 
                    if( tempVal >= curSize) break;
                }

                //right flow
                int right = 0;
                int lookRight = col;
                while(lookRight < cols-1){
                    right++;
                    int tempVal = trees[row][++lookRight]; 
                    if(tempVal >= curSize) break;
                }

                //top flow
                int up = 0;
                int lookUp = row;
                while(lookUp > 0){
                    up++;
                    int tempVal = trees[--lookUp][col]; 
                    if(tempVal >= curSize) break;
                }

                //down flow
                int down = 0;
                int lookDown = row;
                while(lookDown < cols-1){
                    down++;
                    int tempVal = trees[++lookDown][col]; 
                    if(tempVal >= curSize) break;
                }

                int curScore = down*up*left*right; 
                if(maxScore < curScore){
                    maxScore = curScore;
                }
            }
        }

        return maxScore;
    }
}