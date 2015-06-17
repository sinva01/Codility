/*
A non-empty zero-indexed array A consisting of N integers is given.
The leader of this array is the value that occurs in more than half of the elements of A.
An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
For example, given array A such that:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:
0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.
For example, given:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
Copyright 2009–2015 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*/


// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    private int fCount = 0;
    public int solution(int[] A) {
        int index = findMajority(A);
        if(index== -1)
        return 0;
        int candidate = A[index];
        int count = fCount;
        int firstHalfCount = 0;
        int secondHalfCount = fCount;
        int equiLeader = 0;
        for(int i = 0; i<A.length; i++)
        {
            if(candidate==A[i])
            {
                firstHalfCount++;
                secondHalfCount--;
            }
            if((firstHalfCount > (i+1)/2) && (secondHalfCount > (A.length-i-1)/2))
               equiLeader++; 
        }
        return equiLeader;
    }
    
    private int findMajority(int[] A) {
        int candidate = 0;
        int votes = 0;
		// Increase the vote for same item and decrease the vote for different item. if votes is 0 start with new candidate.
        for (int i = 0; i < A.length; i++) {
            if (votes == 0) {
                candidate = A[i];
                votes++;
            } else if (candidate == A[i]) {
                votes++;
            } else {
                votes--;
            }
        }
        int count = 0;
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
                index = i;
            }
        }
        fCount = count;
        return count > A.length / 2 ? index: -1;
    }
}