package leetcode.dailyquestion;

import java.util.Arrays;

public class GasStation134 {
    public static void main(String[] args) {

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum =0;
        int gasCostSum =0;

        for(int val: gas){
            gasSum+=val;
        }
        for(int val: cost){
            gasCostSum+=val;
        }

        if(gasCostSum>gasSum){
            return -1;
        }

        int result =0;
        int diff =0;
        for (int i = 0; i < gas.length; i++) {
            diff += gas[i]-cost[i];
            if(diff<0){
                diff =0;
                result= i+1;
            }
        }
        return result;
    }
}
