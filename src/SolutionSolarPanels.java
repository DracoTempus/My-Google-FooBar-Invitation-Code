import java.math.BigInteger;
import java.util.Arrays;

public class SolutionSolarPanels {
    public static String solution(int[] xs) {
        if(xs.length == 0){
            return "0";
        }
        if(xs.length == 1){
            return String.valueOf(xs[0]);
        }
        System.out.println(Arrays.toString(xs));
        int adds = 0;
        int negatives = 0;
        for (int i = 0; i < xs.length; i++)
        {
            adds += xs[i];
            if(xs[i] < 0 )
                negatives++;

            int value = xs[i];
            int j = i;
            while (j > 0 && xs[j - 1] > value)
            {
                xs[j] = xs[j - 1];
                j--;
            }
            if(value == 0) {
                value = 1;
            }
            xs[j] = value;
        }
        if(adds < 0 && negatives < 2){
            return "0";
        }

        BigInteger sol = new BigInteger(String.valueOf(xs[xs.length-1]));
        boolean firstNeg = negatives % 2 == 0;

        for (int i = xs.length-2; i > -1; i--)
        {
            if(!firstNeg && xs[i]< 0){
                firstNeg = true;

            }else {
                System.out.println(sol + " " + xs[i]);
                sol = sol.multiply(new BigInteger(String.valueOf(xs[i])));
            }
        }
        System.out.println(Arrays.toString(xs));
        return String.valueOf(sol);
    }


    public static void main(String[] args){
        System.out.println(solution(new int[]{2, 2, 0, 0, 2,0}));
    }
}
