package TwoSum;

/**
 * @program: leetcode
 * @description: two sum TwoSum.solution
 * @author: Irving Wei
 * @create: 2019-03-13 11:11
 **/
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    // 用于验证
                   /*System.out.println(i);
                    System.out.println(j);*/
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // 官方用例
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }
}
