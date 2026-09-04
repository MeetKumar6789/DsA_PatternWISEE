import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0) return false;

        String s = Integer.toString(x);
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = s1.nextInt();  

        Solution sol = new Solution();
        boolean result = sol.isPalindrome(x);
        System.out.println(result);

        s1.close();
    }
}
