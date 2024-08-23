public class Solution {
    public String multiply(String num1, String num2) {
        // let us multiply the smaller string with the bigger one 
        // though there won't be any difference the other way around
        
        String smol = num1.length() < num2.length() ? num1 : num2;
        String large = smol.equals(num1) ? num2 : num1;
        
        int carry = 0;
        
        StringBuilder finalResult = new StringBuilder("0");
        int k = 0; // counter for place value
        
        for(int i = smol.length() - 1; i >= 0 ; i--) {
            StringBuilder result = new StringBuilder();
            int val = smol.charAt(i) - '0';
            carry = 0;
            
            for(int j = large.length() - 1; j >= 0; j--) {
                int number = large.charAt(j) - '0';
                int product = val * number + carry;
                
                if(j == 0) {
                    result.insert(0, product);
                }
                else {
                    result.insert(0, ((char)((product % 10) + '0')));
                }
                
                carry = product / 10;
            }
            
            // append k number of zeroes to result for place value
            int x = k;
            while(x-- > 0) {
                result.append('0');
            }
            
            // Add this partial product to the final result
            finalResult = new StringBuilder(addTwoStrings(finalResult.toString(), result.toString()));
            k++;
        }
        
        return finalResult.toString();
    }
    
    private String addTwoStrings(String X, String Y) {
        int i = X.length() - 1;
        int j = Y.length() - 1;
        
        int carry = 0;
        
        StringBuilder result = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            
            if(i >= 0) {
                int value = X.charAt(i) - '0';
                sum += value;
                i--;
            }
            
            if(j >= 0) {
               int value = Y.charAt(j) - '0';
               sum += value; 
               j--;
            }
            
            result.insert(0, (char)((sum % 10) + '0'));
            carry = sum / 10;
        }
        
        // handling 0000000
        while(result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}