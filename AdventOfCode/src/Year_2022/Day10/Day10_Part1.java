package Year_2022.Day10;
import Utilities.Problem;

public class Day10_Part1 extends Problem<Integer> {

    public Day10_Part1(String resource) {
        super(resource);
    }

    @Override
    public Integer call() throws Exception {
        CathodeRayTube crt = new CathodeRayTube();
        int sum = 0;

        for(String s : input){
            crt.opp(s);
        }
        sum += crt.signalStrength.get(20) * 20;
        sum += crt.signalStrength.get(60) * 60;
        sum += crt.signalStrength.get(100) * 100;
        sum += crt.signalStrength.get(140) * 140;
        sum += crt.signalStrength.get(180) * 180;
        sum += crt.signalStrength.get(220) * 220;
        
        return sum;
    }
}