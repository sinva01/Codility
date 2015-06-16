/*
Write a function:

int solution(int A, int B, int K);

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Assume that:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Complexity:

expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).
Copyright 2009–2015 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*/

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
       // System.out.println("A = " + A + " B = " + B + " K = " + K);
        int result = 0;
        int modA = A%K;
        int modB = B%K;
        if((A == B) && modA >0)
            return 0;
        if(modA == 0 || modB==0)
        {
            int diff = B - A;
            result = diff/K;
            result++;
        }else if(modA != 0)
        {
            int diff = B - A - K + modA;
            result = diff/K;
            result++;
        }
        return result;
    }
}