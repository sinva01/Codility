// you can also use imports, for example:
import java.util.*;


// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int cache[] = new int[A.length];
        Arrays.fill(cache,Integer.MIN_VALUE);
        return solution(A,0,cache);
    }
    
    private int solution(int[]A, int start, int[] cache)
    {
            if(cache[start]!=Integer.MIN_VALUE)
                return cache[start];
            if(start == A.length-1)
            {
                cache[start] = A[start];
                return A[start];
            }
            int max = solution(A, start+1,cache);
            for(int i=start+2; i<A.length && i <= start + 6; i++)
            {
                int result = solution(A, i,cache);
                System.out.println("Value at " + i + " :" + result);
                if(max < result)
                {
                    max = result;
                }
            }
            cache[start] = A[start] + max;
            System.out.println("Value at " + start + " :" + cache[start]);
            return cache[start] ;
        
    }
}