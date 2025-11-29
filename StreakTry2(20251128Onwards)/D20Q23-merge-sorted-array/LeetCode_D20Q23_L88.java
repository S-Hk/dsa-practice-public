/*
88. Merge Sorted Array
https://leetcode.com/problems/merge-sorted-array/
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int[] temp = new int[m];
        for(int i=0; i<m;i++){
            temp[i]=nums1[i];
        }
        int i=0;
        int j=0;
        int k=0;
        while(k<(m+n)){
            if(i<m){
                if((j<n)&&(nums2[j]<=temp[i])){
                    nums1[k]=nums2[j];
                    j++;
                }else{
                    nums1[k]=temp[i];
                    i++;
                }
            }else{
                nums1[k]=nums2[j];
                j++;
            }
            k++;
        }
    }
}