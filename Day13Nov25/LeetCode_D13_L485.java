/*
Problem:
https://leetcode.com/problems/max-consecutive-ones/

485. Max Consecutive Ones
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount =0;
        int currentCount = 0;
        for(int n: nums){
            if(n==1){
                currentCount++;
            }else{
                currentCount = 0;
            }
            if(currentCount>maxCount){
                maxCount = currentCount;
            }
        }
        return maxCount;
    }
}
/*
easy
*/