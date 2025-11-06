/*
Problem:
https://leetcode.com/problems/sort-colors/
 */

class Solution {
    public void sortColors(int[] nums) {
        int countRed0=0;
        int countWhite1=0;
        int countBlue2=0;
        for(int i=0; i<nums.length; i++){
            switch(nums[i]){
                case 0:
                    countRed0++;
                    break;
                case 1:
                    countWhite1++;
                    break;
                case 2:
                    countBlue2++;
                    break;
                default:
                    break;
            }
        }
        int i = 0;
        while(countRed0>0){
            nums[i]=0;
            i++;
            countRed0--;
        }
        while(countWhite1>0){
            nums[i]=1;
            i++;
            countWhite1--;
        }
        while(countBlue2>0){
            nums[i]=2;
            i++;
            countBlue2--;
        }
        
    }
}