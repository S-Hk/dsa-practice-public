/*
485. Max Consecutive Ones
https://leetcode.com/problems/max-consecutive-ones/description/
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum=0;
        int maxSum=0;
        for(int n :  nums){
            if(n == 0){
                maxSum=sum>maxSum?sum:maxSum;
                sum = 0;
                continue;
            }
            sum++;
        }
        maxSum=sum>maxSum?sum:maxSum;
        return maxSum;
    }
}