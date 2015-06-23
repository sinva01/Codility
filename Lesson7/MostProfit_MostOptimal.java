/*
A zero-indexed array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
For example, consider the following array A consisting of six elements such that:
  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.
Write a function,
class Solution { public int solution(int[] A); }
that, given a zero-indexed array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.
For example, given array A consisting of six elements such that:
  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
the function should return 356, as explained above.
Assume that:
N is an integer within the range [0..400,000];
each element of array A is an integer within the range [0..200,000].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
Copyright 2009–2015 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*/

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        if(A.length==0)
        return 0;
		// Just assume that you sell on the day and buy on the previous day. Calculate the profit/loss on the daily. Find the maximum sum that can be achieved.
		// Eventually that will be the maximum profit that can be achieved.
        for(int i=A.length-1; i>0; i--)
        {
            A[i] = A[i] - A[i-1];
        }
        A[0] = 0;
        int result = maxSum(A);
        return result>=0 ? result : 0;
    }
    
    private int maxSum(int[] A)
    {
       int max_ending =A[0], max_slice=A[0];
       for(int i=1; i<A.length; i++)
       {
           max_ending = Math.max(A[i],max_ending + A[i]);
           max_slice = Math.max(max_slice,max_ending);
       }
       return max_slice;
    }
}