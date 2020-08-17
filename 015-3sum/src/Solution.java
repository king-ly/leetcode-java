import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    //这个超时
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int taget = 0 - nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int key = taget - nums[j];
                if (hm.containsKey(key)) {
                    if (hm.get(key) != j) {
                        Integer[] tmp = {nums[hm.get(key)], nums[j], nums[i]};
                        Arrays.sort(tmp);
                        lists.add(Arrays.asList(tmp));
                    }
                }
            }
            hm.put(nums[i], i);
        }
        return lists.stream().distinct().collect(Collectors.toList());
    }

    //也超时了
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                if (nums[j] + nums[k] == target) {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                while (k >= 0 && nums[j] + nums[k] > target) {
                    k--;
                }
                while (j < k && nums[j] + nums[k] < target) {
                    j++;
                }
            }
        }
        return lists.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum2(nums);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
