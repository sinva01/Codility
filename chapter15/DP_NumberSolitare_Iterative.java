// you can also use imports, for example:
import java.util.*;


// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int cache[] = new int[A.length];
        Arrays.fill(cache,Integer.MIN_VALUE);
        cache[A.length-1] = A[A.length-1];
    for(int i = A.length-2; i>=0; i--)
    {
        int max = cache[i];
        for(int j = i+1; j <= cache.length-1 && j <= i+6; j++)
        {
            if(max < cache[j])
            {
                max = cache[j];
            }
        }
        cache[i] = A[i] + max;
    }        
    return cache[0];
    }
}