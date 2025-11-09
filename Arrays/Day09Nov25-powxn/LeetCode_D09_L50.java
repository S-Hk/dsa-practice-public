/*
Problem:
https://leetcode.com/problems/powx-n/
 */

class Solution {
    public double myPow(double x, int n) {
        //if(n==-1) return 1/x;
        if(n==1) return x;
        if(n!=0){
            while(n%2==0){
                x=x*x;
                n=n/2;
            }
        }
        if(n<0) return 1/(x*myPow(x,(-n-1)));
        if(n>0) return x*myPow(x, n-1);
        //if(n==0) 
        return 1;
    }
}