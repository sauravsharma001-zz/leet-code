/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (30.07%)
 * Total Accepted:    317.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        
        if(s == null || s.trim().length() < 2) return true;

        int start = 0, end = s.length()-1;
        s = s.toLowerCase();
        while(start < end) {
            char a = s.charAt(start);
            char b = s.charAt(end);
            if(a < 48 ||( a > 57 && a < 97) || a > 122) {
                start++;
            } else if (b < 48 ||( b > 57 && b < 97) || b > 122)  {
              end--;  
            } else {
                if(a != b) return false;
                start++; end--;
            }
        }

        return true;
    }
}
