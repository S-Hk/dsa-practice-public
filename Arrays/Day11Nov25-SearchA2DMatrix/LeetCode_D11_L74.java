/*
Problem:
https://leetcode.com/problems/search-a-2d-matrix/
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n = matrix[0].length;
        int min = 0;
        int max = (m*n) -1;

        do{
            int middle = (min + max) / 2;
            int i = middle / n;
            int j = middle % n;

            if(matrix[i][j] == target) return true;

            if(matrix[i][j] < target)
                min = middle+1;
            else
                max = middle-1;

        }while(min <= max);

        return false;
    }
}
/*
Rough work:

| 0123 |
| 4567 |

m=2
n=4

01234567

total-8

search target pos - 7

7 [1][3]
7 = 4*1 + 3 
target = n*(i) + j

*/