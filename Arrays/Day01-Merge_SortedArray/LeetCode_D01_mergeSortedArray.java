/*
Problem:
https://leetcode.com/problems/merge-sorted-array/description/
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for(int i=0; i<m;i++){
            temp[i]=nums1[i];
        }
        int i=0;//temp
        int j=0;//nums2
        int k=0;//nums1(final)
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