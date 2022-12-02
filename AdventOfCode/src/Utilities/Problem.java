package Utilities;

import java.util.concurrent.Callable;

public abstract class Problem<T> implements Callable<T> {

  protected abstract void prework();

  public void callWithMetrics(String problem) throws Exception {
    long startTime = 0;
    long endTime = 0;
    long startingMemory = 0;
    long endingMemory = 0;
    long runTimeInNanoSeconds = -1;
    long memoryUsedInBytes = -1;
    //System.gc(); // used to get heap memory measurement to behave
    //startingMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    startTime = System.nanoTime();
    T t = call();
    endTime = System.nanoTime();
    //endingMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    runTimeInNanoSeconds = (endTime - startTime);
    if ((endingMemory != startingMemory) || memoryUsedInBytes == -1) {
      memoryUsedInBytes = endingMemory - startingMemory;
    }
    System.out.println(problem + t);
    System.out.println("Time in Milliseconds: " + (float) runTimeInNanoSeconds / 1000000.0);
    //System.out.println("Memory Usage in Bytes: " + memoryUsedInBytes);
  }
}
