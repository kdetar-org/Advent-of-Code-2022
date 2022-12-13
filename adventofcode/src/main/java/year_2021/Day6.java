package year_2021;

import utilities.Problem;

public class Day6 extends Problem<Long>{

    public Day6(String resource) {
        super(resource);
    }

    @Override
    public Long call() throws Exception {
        long[] fishBuckets = new long[9];
        String[] fishyStr = input.get(0).split(",");


        //add our fishies to virtual buckets.
        for(int i = 0; i < fishyStr.length; i++){
            fishBuckets[Integer.parseInt(fishyStr[i])]++;
        }

        int cycles = 256;
        long floatingFishies = 0;
        for(int i = 0; i < cycles; i++){
            floatingFishies = 0;
            for(int j = 0 ; j <= 8; j ++){
                if(j == 0){
                    floatingFishies = fishBuckets[0];
                } else {
                    fishBuckets[j-1] = fishBuckets[j];
                }
            }
            fishBuckets[8] = floatingFishies;
            fishBuckets[6] = fishBuckets[6] + floatingFishies;
        }

        long sumFish = 0;
        for(int i = 0 ; i < fishBuckets.length; i ++){
            sumFish += fishBuckets[i]; 
        }

        return sumFish;
    }
}
