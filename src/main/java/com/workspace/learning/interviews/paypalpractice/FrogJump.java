package com.workspace.learning.interviews.paypalpractice;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
    //https://leetcode.com/problems/frog-jump/description/
    public static void main(String[] args) {


    //    int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
    //    System.out.println(canCross(stones));  // Output: true

        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(stones2));  // Output: false

    }
    public static boolean canCross(int[] stones) {
        HashMap<Integer , HashSet<Integer>> map = new HashMap<>();
        int n =stones.length;
        for(int ele:stones)
        {
            map.put(ele,new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for(int i=0;i<n-1;i++)
        {
            int num=stones[i];
            HashSet<Integer> jumps = map.get(num);
            for(int k:jumps)
            {
                int vs=num+k;
                if(vs==stones[n-1])return true;
                if(map.containsKey(vs))
                {
                    if(k-1>0)map.get(vs).add(k-1);
                    map.get(vs).add(k);
                    map.get(vs).add(k+1);



                }
            }
        }
        return false;
    }
}
