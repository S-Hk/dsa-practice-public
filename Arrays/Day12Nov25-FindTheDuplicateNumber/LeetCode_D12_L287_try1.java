/*
Problem:
https://leetcode.com/problems/find-the-duplicate-number/
 */

class Solution {
    public int findDuplicate(int[] nums) {
        //int sum = 0;
        int n = nums.length-1;
        
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                if(i!=j && nums[j]==nums[i]){
                    return nums[i];
                }
            }
        }
        return 0;

        /*for(int i=0; i<n+1; i++){
            sum+=nums[i];
        }
        int difference = sum - ((n*(n+1))/2);

        if(difference>n){

        }else if(difference<0){

        }else{
            
        }*/
    }
}
/*
1,2,3,4,5,6,7,8,9,9
9,2,3,4,5,9,9,8,9,9
*/

/*
Got Time Limit Exceeded
*/