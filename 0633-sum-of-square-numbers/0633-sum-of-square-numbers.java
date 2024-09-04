// class Solution {
//     static int helper(int num) {
//         // check if num is a perfect sq 
//         int value = (int) Math.sqrt(num);
//         return value * value == num ? value : -1;
//     }

//     public boolean judgeSquareSum(int c) {
//         if(c == 0) return true;
//         int i = 0, j = 0;

//         while(i * i < c) {
//             j = c - (i * i);
//             if(helper(j) != -1) {
//                 // is a perfect sq rt 
//                 return true;
//             }
//             i++;
//         }

//         return false;
//     }
// }


// class Solution {
//     public boolean judgeSquareSum(int c) {
//         if(c == 0) return true;

//         Set<Integer> arr = new HashSet<>();

//         for(int i = 0; i <= Math.sqrt(c); i++) {
//             // System.out.println("adding " + (i * i));
//             arr.add(i * i);
//         }

//         for(int i = 0; i < arr.size(); i++) {
//             // System.out.println(c - (i * i));
//             if(arr.contains(c - (i * i))) return true;
//         }

//         return false;
//     }
// }


class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0) return true;

        long r = (long) Math.sqrt(c);
        long s = 0;

        while(s <= r) {
            long result = (s * s) + (r * r);

            if(result == c) return true;
            else if(result > c) r--;
            else s++;
        }

        return false;
    }
}