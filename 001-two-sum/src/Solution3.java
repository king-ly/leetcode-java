import java.util.HashMap;

public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(target - nums[i])) {
                int[] points = {i, h.get(target - nums[i])};
                return points;
            }
            h.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] points = new Solution3().twoSum(nums, target);
        if (points != null) {
            System.out.println(points[0] + "_" + points[1]);
        } else {
            System.out.println("没有找到结果集");
        }
    }
}
