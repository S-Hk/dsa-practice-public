/*
496. Next Greater Element I
https://leetcode.com/problems/next-greater-element-i/
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngeMap = new HashMap<>();
        int[] mem = new int[nums2.length];
        mem[0]=-1;
        int memSize=0;
        for (int i=nums2.length-1; i>=0; i--){
            if(memSize==0){
                ngeMap.put(nums2[i], -1);
                mem[memSize] = nums2[i];
                memSize+=1;
            }else if(nums2[i]>=mem[0]){
                    ngeMap.put(nums2[i], -1);
                    mem[0]=nums2[i];
                    memSize=1;
            }else{
                for(int j=memSize-1; j>=0; j--){
                    if(mem[j]>nums2[i]){
                        ngeMap.put(nums2[i], mem[j]);
                        break;
                    }else{
                        memSize = j+1;
                    }
                }
                mem[memSize] = nums2[i];
                memSize+=1;
            }
        }
        for(int i=0; i<nums1.length; i++){
            nums1[i] = ngeMap.get(nums1[i]);
        }
        return nums1;
    }
}
/*
Rough work:
[5,1,3,6,7,2,4,8]-nums2

[5,4,3]

5,-1
4,
*/