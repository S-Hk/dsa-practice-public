/*
1922. Count Good Numbers
https://leetcode.com/problems/count-good-numbers/
 */


class Solution {
    public int countGoodNumbers(long n) {

        long count4_odd = n/2; 
        long count5_even = n%2==0? n/2: n/2+1;

        //ans = 4^count4_odd + 5^count5_even;
        return (int)((powWithMod(4, count4_odd, 1000000007) * powWithMod(5, count5_even, 1000000007))%1000000007);
    }

    private long powWithMod(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
/*
Need to get further understanding of powWithMod > refer md file and learn
*/