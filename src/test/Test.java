package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k][0];
        for(int i = 0; i < k ; i++){
            dp[i][0] = -prices[0];
            dp[i][1] = 0;
        }

        for(int i = 1; i < prices.length; i++){
            for(int j = 1;j<k;j++){
                dp[j][0] = Math.max(dp[j][0],dp[j-1][1]-prices[i]);
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0]+prices[i]);
            }
        }
        System.out.println(dp[k-1][1]);
        return dp[k-1][1];
    }

    public static void main(String[] args) {
        System.out.println(findNum(12));
    }

    public static int findNum(int n){
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        for (int i = 1;  dp.get(dp.size()-1)<n ; i++) {
            dp.add(i,dp.get(i-1)+i+1);
        }
        System.out.println(dp);
        return n-dp.get(dp.size()-2);
    }


}
