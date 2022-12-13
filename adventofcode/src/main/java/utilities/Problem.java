package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class Problem<T> implements Callable<T> {

    protected List<String> input;
    protected BufferedReader br;

    public Problem(String resource){
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStreamReader sr = new InputStreamReader(classLoader.getResourceAsStream(resource));
        br = new BufferedReader(sr);
        prework();
    }

    protected void prework() {
        input = new ArrayList<String>();
        String line;
        try {
            line = br.readLine();

            while (line != null) {
                input.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    public void callWithMetrics(String problem) throws Exception {
        long startTime = 0;
        long endTime = 0;
        long startingMemory = 0;
        long endingMemory = 0;
        long runTimeInNanoSeconds = -1;
        long memoryUsedInBytes = -1;
        // System.gc(); // used to get heap memory measurement to behave
        // startingMemory = Runtime.getRuntime().totalMemory() -
        // Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        T t = call();
        endTime = System.nanoTime();
        // endingMemory = Runtime.getRuntime().totalMemory() -
        // Runtime.getRuntime().freeMemory();
        runTimeInNanoSeconds = (endTime - startTime);
        if ((endingMemory != startingMemory) || memoryUsedInBytes == -1) {
            memoryUsedInBytes = endingMemory - startingMemory;
        }
        System.out.println(problem + t);
        System.out.println("Time in Milliseconds: " + (float) runTimeInNanoSeconds / 1000000.0);
        // System.out.println("Memory Usage in Bytes: " + memoryUsedInBytes);
    }


}
