/*
Problem:
https://leetcode.com/problems/maximum-subarray/
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int tempSum = nums[0];
        int maxSum = nums[0];
        for(int i =1; i<nums.length; i++){
            if(tempSum<0){
                tempSum = nums[i];
            }else{
                tempSum =  tempSum + nums[i];
            }
            if(tempSum>maxSum){
                maxSum = tempSum;
            }
        }
        return maxSum;
    }
}

/*
Additional Tests:
[-5,-4,-1,-7,-8]
[-5,-6,-7,-8]
*/