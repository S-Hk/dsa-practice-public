/*
Problem:
https://leetcode.com/problems/rotate-image/
 */

class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length!=matrix[0].length) return;
        if(matrix.length==1) return;
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<(matrix[0].length)/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j] = temp;
            }
        }
    }
}