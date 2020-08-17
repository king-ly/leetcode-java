/**
 * 35. 搜索插入位置
 * 这是一个选择排序算法的思想
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) return i;
            if (target > nums[i]) return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(new Solution().searchInsert(nums,target));
    }
}
