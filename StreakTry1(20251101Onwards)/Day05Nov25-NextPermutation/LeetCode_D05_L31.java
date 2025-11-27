/*
Problem:
https://leetcode.com/problems/next-permutation/
 */

class Solution {
    public void nextPermutation(int[] nums) {
        int maxPos=nums.length;
        int minPos=nums.length;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1]<nums[i]){
                minPos = i-1;
                break;
            }
        }
        if(minPos==nums.length){
            reverseArr(nums,0, nums.length-1);
            return;
        }
        for(int i=nums.length-1; i>minPos; i--){
            if(nums[i]>nums[minPos]){
                maxPos = i;
                break;
            }
        }
        int temp = nums[minPos];
        nums[minPos] = nums[maxPos];
        nums[maxPos] = temp;
        reverseArr(nums, minPos+1, nums.length-1); //reverse sub array from minPos+1 to end of new array
    }

    private void reverseArr(int[] nums, int startPos, int endPos){
        for(int i=startPos; i<=((endPos+startPos)/2); i++){
            int temp = nums[i];
            nums[i]=nums[endPos-(i-startPos)];
            nums[endPos-(i-startPos)] = temp;
            
        }
    }
}
/*test cases
[1,6,4,1,9,5]
[1,6,4,3,9,5,4,2]
[1,6,4,3,9,5,5,4,2]
*/