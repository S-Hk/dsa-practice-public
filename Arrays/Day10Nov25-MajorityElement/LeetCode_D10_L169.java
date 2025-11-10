/*
Problem:
https://leetcode.com/problems/majority-element/
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int maxValue = nums[0];
        for(int i=1; i< nums.length; i++){
            if(count==0){
                count =1;
                maxValue = nums[i];
            }else{
                if(maxValue == nums[i])
                count++;
                else
                count--;
            }
        }  
        return maxValue; 
    }
}
/*
Initally solved with Map
Needed multiple hints for applying Boyer–Moore majority vote algorithm
*/