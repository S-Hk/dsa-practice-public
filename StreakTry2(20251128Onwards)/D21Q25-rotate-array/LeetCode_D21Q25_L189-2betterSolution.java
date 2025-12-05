/*
189. Rotate Array
https://leetcode.com/problems/rotate-array/
 */

class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length){
            k=k%nums.length;
        }
        int[] temp = new int[k];
        int n = nums.length -1 ;
        if(n==0) return;
        int i=0;
        for(i=0; i<k; i++){
            temp[k-i-1] = nums[n-i];
        }
        i=n-k;
        while(i>=0){
            nums[i+k]=nums[i];
            i--;
        }
        for(i=0; i<k; i++){
            nums[i]=temp[i];
        }
        
    }
}
/*
nums = [-1], k = 2
nums = [1,2], k = 7 >> 7%2 >> k=1
*/
/* This is still not most optimal solution*/