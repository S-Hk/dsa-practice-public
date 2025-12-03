# 1922. Count Good Numbers
https://leetcode.com/problems/count-good-numbers/description/

---


A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.  
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 10^9 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

---

### Example 1

**Input:**  
```

n = 1

```

**Output:**  
```

5

```

**Explanation:**  
The good numbers of length 1 are "0", "2", "4", "6", "8".

---

### Example 2

**Input:**  
```

n = 4

```

**Output:**  
```

400

```

---

### Example 3

**Input:**  
```

n = 50

```

**Output:**  
```

564908303

```

---

### Constraints

```
1 <= n <= 10^15
```


---

# Solution Explanation

## Concepts

### Good Digit Strings

A **digit string** is good if:

* Digits at **even indices** (0-indexed) are **even digits**:
  **0, 2, 4, 6, 8** → 5 possibilities

* Digits at **odd indices** are **prime digits**:
  **2, 3, 5, 7** → 4 possibilities

---

#### Examples

* **"2582"** is good

  * even indices → 2, 8 (both even)
  * odd indices → 5, 2 (both prime)

* **"3245"** is **not** good

  * index 0 has digit **3**, which is not even

---

#### Attempt: 1 > wrong
```java
/*
Logic:
even - even(0,2,4,6,8)=5 options
odd-prime(2,3,5,7)=4 options

1=5
2=4*5
3=5*4*5
4=4*5*4*5
*/

class Solution {
    public int countGoodNumbers(long n) {
        if(n==0) return 0;
        if(n==1) return 5;

        if(n%2==0){
            return (4*countGoodNumbers(n-1));
        }else{
            return (5*countGoodNumbers(n-1));
        }        
    }
}
```
Issues: 
1. using recursion - stack will become so large easily
2. this is so brutforce, it can't handle n = 10^15 
3. int can't store such a large value. int max is (2^31-1) and 5^14 itself exceeds that. So it can't even handle n=28, max it can handle is n=26 or 27 maybe?



#### Attempt: 2 (after quickly glancing explanation and solution and hints - text, no video)
```java
/*
Logic:
even - even(0,2,4,6,8)=5 options
odd-prime(2,3,5,7)=4 options

consider number when n=6
325476 - sample number string
012345 - 0 indexed string indices -- n= 6 means this string of length 6(0 to 5 index)
212121 - odd/even indices
454545 - number of options in that indices


i = 0 to 5

Index 0 → 5 choices (even) till here when n=1

Index 1 → 4 choices (odd) till here when n=2

Index 2 → 5 choices (even) till here when n=3

Index 3 → 4 choices (odd) till here when  n=4

Index 4 → 5 choices (even)

Index 5 → 4 choices (odd)

how about n = 10,000
i = 0 to i = 9999

Let's see pattern
n=6-even
ans= 5*4*5*4*5*4 = (4^3) * (5^3)
4 > n/2
5 > n/2

n=5-odd
ans= 5*4*5*4*5 = (4^2) * (5^3)
4 > n/2
5 > n/2 +1 
*/


class Solution {
    public int countGoodNumbers(long n) {

        long count4_odd = n/2; 
        long count5_even = n%2==0? n/2: n/2+1;

        //ans = 4^count4_odd + 5^count5_even;
        double ans = Math.pow(4, count4_odd) * Math.pow(5, count5_even);

        return (int)(ans%1000000007);
    }
}
```
Its better than last, as it doesn't use recursion.

But still Wrong - it fails for slighly large numbers, even n=45. 

So n=50 it fails test case as the operation ans%1000000007 looses precision

Also double gets better range, but it looses precision as numbers increase.

##### double Java Primitive Type Notes
- **Max value double can store:** ~1.797 × 10^308  
- **Max integer double can store precisely:** 2^53 (~9 × 10^15)  
- **Min positive value:** 4.9 × 10^-324  
- **Size:** 64 bits (8 bytes)  
- **Note:** Beyond 2^53, double cannot represent all integers exactly.

2^53 is in range for 5^22, but 5^23 falls out of range

#### Attempt: 3 (after understanding solution from ChatGPT)

The issue in last solution was using Math.pow which is limited by range of double to store value precisely

So now we need a better method, than that, which doesn't have any limitation. 
In python we have built in pow method and we can use 
```python
MOD = 10**9 + 7
count4_odd = n // 2
count5_even = (n + 1) // 2

ans = (pow(4, count4_odd, MOD) * pow(5, count5_even, MOD)) % MOD
```

But java, we need to impement custom pow method with modulus operation as required in the question. This needs knowledge on some csc maths concepts

## ✅ Recommended Concepts to Learn First

1. Modular arithmetic (remainders, properties of modulo)
2. Binary numbers & bit manipulation (`& 1`, `>> 1`)
3. Fast exponentiation / binary exponentiation


## Understanding Modular Exponentiation (`modPow`)

### 1️⃣ Modular Arithmetic
- **Concept:** Working with numbers “modulo `m`” means you only care about the remainder.
- **Property:** `(a * b) % m = ((a % m) * (b % m)) % m`
- **Example:**
```text
  7 * 8 % 5 = 56 % 5 = 1
  (7 % 5) * (8 % 5) % 5 = 2 * 3 % 5 = 6 % 5 = 1 ✅
````

* **Use:** Keeps numbers small to avoid overflow.

---

### 2️⃣ Exponentiation (Power)

* **Concept:** Repeated multiplication.

  ```text
  3^4 = 3 * 3 * 3 * 3 = 81
  ```
* **Problem:** Large powers take too long and can overflow.

---

### 3️⃣ Fast (Binary) Exponentiation

* **Idea:** Use the **binary representation** of the exponent to reduce multiplications.
* **Formula:**

  ```text
  base^exp = base^(2^0 * b0) * base^(2^1 * b1) * ...
  ```

  where `b0, b1, ...` are bits of `exp`.
* **Example:** 13 in binary = `1101`

  ```text
  base^13 = base^8 * base^4 * base^1
  ```
* **Complexity:** O(log exp) instead of O(exp).

---

## 4️⃣ Bitwise Operations

* `exp & 1` → checks if current least significant bit is 1 (odd)
* `exp >>= 1` → right shift → divide exp by 2
* **Use:** Walk through binary digits of `exp`.

---

## 5️⃣ Combining Modular Arithmetic + Fast Exponentiation

* Compute `(base^exp) % mod` **step by step**:

  1. Multiply `result` only when the current bit is 1
  2. Square the `base` each step
  3. Reduce modulo `mod` each step
* **Benefit:** Keeps numbers small and avoids overflow.

---

```java
class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long countEven = (n + 1) / 2; // even indices (0-indexed)
        long countOdd = n / 2;         // odd indices

        long pow5 = modPow(5, countEven, MOD); // even positions can be 0,2,4,6,8 → 5 choices
        long pow4 = modPow(4, countOdd, MOD);  // odd positions can be 2,3,5,7 → 4 choices

        return (int) ((pow5 * pow4) % MOD);
    }

    // Fast modular exponentiation: (base^exp) % mod
    private long modPow(long base, long exp, long mod) {
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

```


---