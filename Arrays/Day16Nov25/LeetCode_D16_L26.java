/*
Problem:
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

26. Remove Duplicates from Sorted Array
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int curNum=nums[0];
        int k=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=curNum){
                if(k!=i)
                    nums[k] = nums[i];
                k++;
                curNum = nums[i];
            }
        }
        return k;
    }
}