import java.util.*;

public class Main
{
    private static Integer result = 0;
    
    public static Integer getBit(int num, int i) {
        return ((num & (1 << i)) >> i);
    }
    
    public static void setBit(int i) {
        // we are setting the bit in the result
        result = result | (1 << i);
    }
    
	public static void main(String[] args) {
	    int arr[] = {5, 5, 5, 2, 4, 4, 4, 1, 1, 1};
	    // in this array, elements appears thrice, only 1 element appears only once, find that element
	    
	    // 1) use frequency mapping
	    Map<Integer, Integer> map = new HashMap<>();
	    
	    for(int i = 0; i < arr.length; i++) {
	        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
	    }
	    
	    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
	    }
	    
	    // 2) using bit manipulation, 
	   // Power of  5	5	5	2	1	1	1
    //         2^2  1	1	1	0	0	0	0
    //         2^1	0	0	0	1	0	0	0
    //         2^0	1	1	1	0	1	1	1
    
        // in each row above, count the no of set bits and see if they are a multiple of three, if not set the bit
        
        // iterate over all the numbers in the array first 
        // then iterate from 0 to 31, get all the bits set to high at each ith (0, 1, 2, 3 . . . .) and see if the no of times they appear is a multiple of three or not
        
        int count = 0;
        int ans = 0;
        
        for(int i = 0; i < 32; i++) {
            count = 0;
            
            for(int element: arr) {
                ans = getBit(element, i);
                
                if(ans == 1) count++;
            }
            
            if(count % 3 != 0) {
                setBit(i);
            }
        }
        
        System.out.println(result);
	} 
}