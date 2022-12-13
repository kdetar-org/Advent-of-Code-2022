package Year_2022.Day10;

import java.util.ArrayList;
import java.util.List;

public class CathodeRayTube {
    int signal;
    int cycle;
    List<Integer> signalStrength;

    public CathodeRayTube(){
        signalStrength = new ArrayList<>();
        signalStrength.add(1);
        signal = 1;
        cycle = 1;
    }

    public void opp(String fullOp){
        String[] split = fullOp.split(" ");
        String op = split[0];
        int mag = split.length <= 1 ? 0 : Integer.parseInt(split[1]);
        
        switch(op){
            case "noop":
                signalStrength.add(signal);
                cycle++;
                break;
            case "addx":
                signalStrength.add(signal);
                cycle++;
                signalStrength.add(signal);
                cycle++;
                signal += mag;
                break;
        }
    }
    
}
