/*
189. Rotate Array
https://leetcode.com/problems/rotate-array/
 */

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length>k){
            rotateBig(nums, k);
        }else{
            for(int i=0; i<k; i++){
                int temp = nums[nums.length-1];
                for(int j =nums.length-1; j>0; j--){
                    nums[j] = nums[j-1];
                }
                nums[0] = temp;
            }
        }
    }
    private void rotateBig(int[] nums, int k) {
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
Failed test cases, had to retry to fix:
nums = [-1], k = 2
nums = [1,2], k = 7
*/