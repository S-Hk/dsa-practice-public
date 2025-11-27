/*
Problem:
https://leetcode.com/problems/set-matrix-zeroes/
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean hasZeroFirstColumn = false;
        boolean hasZeroFirstRow = false;
        for(int i=0; i< matrix.length; i++){
            if(matrix[i][0]==0){
                hasZeroFirstColumn = true;
                break;
            }
        }
        for(int j=0; j< matrix[0].length; j++){
            if(matrix[0][j]==0){
                hasZeroFirstRow = true;
                break;
            }
        }

        for(int i=1; i< matrix.length; i++){
            for(int j=1; j< matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1; i< matrix.length; i++){
            if(matrix[i][0]==0){
                for(int j=1; j< matrix[0].length; j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=1; j< matrix[0].length; j++){
            if(matrix[0][j]==0){
                for(int i=1; i< matrix.length; i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(hasZeroFirstColumn){
            for(int i=0; i< matrix.length; i++){
                matrix[i][0]=0;
            }
        }
        if(hasZeroFirstRow){
            for(int j=0; j< matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }
    }
}
/*
Matrix ref:
00 01 02
10 11 12
20 21 22

Additional test cases:
[[0]]
*/