/*
Problem:
https://leetcode.com/problems/pascals-triangle/
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<1){
            return null;
        }
        List<List<Integer>> finalAnswer = new ArrayList<List<Integer>>();
        Integer rowCount = 0;
        while(rowCount<numRows){
            rowCount++;
            List<Integer> rowList = new ArrayList<Integer>();
            for(int i=1; i<=rowCount; i++){
                if(i==1){
                    rowList.add(1);
                }
                else{
                    rowList.add(rowList.get(i-1-1)*(rowCount-(i-1)) / (i-1));
                }
            }
            finalAnswer.add(rowList);
        }
        return finalAnswer;
    }
}
/*
#TookHint: nCr
*/