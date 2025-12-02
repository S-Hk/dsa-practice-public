/*
283. Move Zeroes
https://leetcode.com/problems/move-zeroes/
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int pos=0;
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                zeroCount++;
            }else {
                if(pos==i){
                    pos++;
                    continue;
                }else{
                    nums[pos]=nums[i];
                    pos++;
                }
            }
        }
        int n=nums.length-1;
        for(int i = 0; i<zeroCount; i++){
            nums[n-i]=0;
        }
    }
}