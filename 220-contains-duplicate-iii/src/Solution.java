import java.util.*;

public class Solution {
    //滑动窗口,超时
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (Integer j : set) {
                if (Math.abs((long) nums[i] - (long) j) <= t) {
                    return true;
                }
            }
            set.add(nums[i]);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //这里需要思考一下
            if (set.ceiling((long) nums[i] - (long) t) != null && set.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2, t = 3;
        System.out.println(new Solution().containsNearbyAlmostDuplicate2(nums, k, t));
//        System.out.println(Math.abs(-2147483648) - t);
    }
}
