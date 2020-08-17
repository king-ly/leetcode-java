import java.util.*;

public class Solution {
    //使用hashmap的方式
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) == null) {
                hm.put(nums[i], i);
            } else {
                if (i - hm.get(nums[i]) <= k) {
                    return true;
                } else {
                    hm.put(nums[i], i);
                }
            }
        }
        return false;
    }

    //使用滑动窗口方式
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Queue q = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if (q.contains(nums[i])) {
                return true;
            }
            q.add(nums[i]);
            if (q.size() == k + 1) {
                q.remove();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(new Solution().containsNearbyDuplicate2(nums, k));
    }
}

