/*
Problem:
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        if(prices.length==2){
            int profit = prices[1]-prices[0];
            return profit>0?profit: 0;
        }
        int buyPos=0;
        int sellPos=1;
        int maxProfit=0;
        for(int i =1; i<prices.length; i++){
            if(prices[i]<prices[buyPos]){
                buyPos=i;
                sellPos=i;
            }else{
                if(prices[i]>=prices[sellPos] && i>buyPos){
                    sellPos = i;
                }
            }
            int currProfit = sellPos>buyPos? prices[sellPos] - prices[buyPos] : 0;
            if(currProfit>maxProfit){
                maxProfit = currProfit;
            }
        }
        return maxProfit;
    }
}
/*
Additional Test cases:
[2,1,2,1,0,1,2]
[3,3,5,0,0,3,1,4]
*/