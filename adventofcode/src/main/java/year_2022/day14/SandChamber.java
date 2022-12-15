package year_2022.day14;

import java.util.List;

import utilities.Point;

public class SandChamber {

    char[][] grid;
    int yOffset,xOffset;
    List<Point[]> commands;
    Point sandSpawn;

    public SandChamber(Point sandSpawn, List<Point[]> commands, Point min, Point max){
        this.sandSpawn = sandSpawn;

        //Commands are offset by min.x or min.y;
        this.commands = commands;
        yOffset = min.y;
        xOffset = min.x;
        grid = new char[max.y-min.y+1][max.x-min.x+1];
        for(Point[] command : commands){
            draw(command[0], command[1]);
        }
    }

    int sandToFill(){
        int sand = 0;
        while(createSand(new Point(sandSpawn.x-xOffset,sandSpawn.y-yOffset))){
            sand++;
        }
        return sand;
    }

    boolean createSand(Point point){
        Boolean canMove = true;
        while(canMove){
            if(grid[point.y][point.x] == 'o'){
                return false;
            }
            
            char d = 'X';
            char dl = 'X';
            char dr = 'X';

            if(point.y + 1 < grid.length){
                d = grid[point.y+1][point.x];
                if(point.x - 1 >= 0)
                    dl = grid[point.y+1][point.x-1];
                if(point.x + 1 < grid[0].length)
                    dr = grid[point.y+1][point.x+1];
            }

            //if below me is sand...
            if(d == '#' || d == 'o'){
                //I check left
                if(dl == '#' || dl == 'o'){
                    //I check right
                    if(dr == '#' || dr == 'o'){
                        grid[point.y][point.x] = 'o';
                        return true;
                    }
                    point.y = point.y+1;
                    point.x = point.x+1;
                } else{
                    point.y = point.y+1;
                    point.x = point.x-1;
                }
            } else {
                point.y = point.y+1;
            }
            if(d == 'X' || dl == 'X' || dr == 'X')
                return false;
        }
        return false;
    }

    void draw(Point a, Point b){
        if(a.x == b.x){
            //we are drawing vertically
            for(int i = Math.min(a.y,b.y); i <= Math.max(a.y,b.y); i++){
                grid[i-yOffset][a.x-xOffset] = '#';
            }
        } else {
            //we are drawing horizontally
            for(int i = Math.min(a.x,b.x); i <= Math.max(a.x,b.x); i++){
                grid[a.y-yOffset][i-xOffset] = '#';
            }
        }
    }

    void print(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                char c = grid[i][j];
                if(c != 0){
                    System.out.print(c);
                } else if(i == 0 && j == 500-xOffset) {
                    System.out.print('+');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
    
}
