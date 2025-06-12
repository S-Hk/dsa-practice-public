/*
Problem:
https://leetcode.com/problems/two-sum/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairMap = new HashMap<Integer, Integer>();
        int i=0;
        while(i<nums.length){
            if(pairMap.get(nums[i])!=null){
                return new int[]{pairMap.get(nums[i]),i};
            }else{
                pairMap.put(target-nums[i], i);
            }
            i++;
        }
        return new int[0];
    }
}