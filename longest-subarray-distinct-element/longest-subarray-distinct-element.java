import java.util.*;

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        // intuition is to find the max subarray which has only two digits in them
        // two digits as we have only two baskets
        
        // we can use a set to store elements upon each iteration and check it size if its greater than 2 or not
        
        int i = 0, j = 0, len = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(; i < N; i++) {
            set.clear();
            
            for(j = i; j < N; j++) {
                set.add(fruits[j]);    
                
                if(set.size() > 2) { // here we are using 2, but the code will work for N distinct elements also
                    // subarray is not valid
                    break;
                }
                else {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        
        return len;
    }
}