/*
Problem:
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */

class Solution {
    public boolean check(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int flipPos = -1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                if(flipPos != -1){
                    return false;
                }
                flipPos = i+1;
            }
        }
        if(flipPos == -1 && nums[nums.length-1]<nums[0]){
            return false;
        }
        if(flipPos != -1 && nums[nums.length-1]>nums[0]){
            return false;
        }
        return true;
    }
}
/*
Additional Test Cases:
[5]
[1,4,5,1]
[1,1,1,1]
[1,2,3,4,5,6,4,5]
[9,1,5,7,8,9]
*/