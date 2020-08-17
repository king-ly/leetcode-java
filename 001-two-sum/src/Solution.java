class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] points = {i, j};
                    return points;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        Solution s = new Solution();
        int[] points = s.twoSum(nums, target);
        if (points != null) {
            System.out.println(points[0] + "_" + points[1]);
        } else {
            System.out.println("没有找到结果集");
        }
    }
}
