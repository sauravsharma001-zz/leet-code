/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (44.45%)
 * Total Accepted:    227.9K
 * Total Submissions: 512K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new LinkedList<>();
        if(numRows < 1) return result;

        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        result.add(temp);
        if(numRows == 1) {
            return result;
        } else {
            int i = 2, num = 0;
            while( i <= numRows) {
                List<Integer> level = new LinkedList<>();
                level.add(1);
                for(int t = 1; t < i-1; t++) {
                    num = result.get(i-2).get(t-1) + result.get(i-2).get(t);
                    level.add(num);
                }
                level.add(1);
                result.add(level);
                i++;
            }
        }


        return result;
    }
}

