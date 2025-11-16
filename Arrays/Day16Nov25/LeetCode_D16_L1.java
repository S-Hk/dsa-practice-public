/*
Problem:
https://leetcode.com/problems/two-sum/

1. Two Sum
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap();
        for(int i=0; i< nums.length; i++){
            Integer tempMapRes = tempMap.get(nums[i]);
            if(tempMapRes==null){
                tempMap.put(target-nums[i], i);
            }else{
                return new int[] {tempMapRes, i};
            }
        }
        return new int[0]; 
    }
}