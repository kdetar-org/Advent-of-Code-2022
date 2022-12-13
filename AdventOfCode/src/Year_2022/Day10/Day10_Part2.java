package Year_2022.Day10;

import java.util.List;

import Utilities.Problem;

public class Day10_Part2 extends Problem<String>{
    
    public Day10_Part2(String resource) {
        super(resource);
    }

    @Override
    public String call() throws Exception {
        CathodeRayTube crt = new CathodeRayTube();

        for(String s : input){
            crt.opp(s);
        }

        List<Integer> crtSignals = crt.signalStrength;
        StringBuilder sb = new StringBuilder();
        for(int rowStart = 1; rowStart < crt.signalStrength.size(); rowStart += 40){
            for(int scan = 0; scan < 40; scan ++){

                int index = rowStart + scan;
                int sprite = crtSignals.get(index)+1;
                if(crtSignals.size() <= index){
                    break;
                }

                if(Math.abs(sprite-(index%40)) < 2){
                    sb.append("#");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
