import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (i != j && numbers[i] + numbers[j] == target) {
                    return new int[]{j + 1, i + 1};
                }
            }
        }
        return null;
    }

    //借助于hashMap实现
    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            hm.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (hm.containsKey(target - numbers[i])) {
                int y = hm.get(target - numbers[i]);
                if (i != y) {
                    return new int[]{i + 1, y + 1};
                }
            }
        }
        return null;
    }


    //借助于二分查找
    public int[] twoSum3(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int y = search(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (y != -1) {
                return new int[]{i + 1, y + 1};
            }
        }
        return null;
    }

    //二分查找
    private int search(int[] nums, int target, int l, int r) {
        //这里不要漏了 l>r 退出的条件
        if (nums == null || l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (target < nums[mid]) {
            return search(nums, target, l, mid - 1);
        } else {
            return search(nums, target, mid + 1, r);
        }
    }

    //双撞指针
    public int[] twoSum4(int[] numbers, int target) {
        int x = 0, y = numbers.length - 1;
        while (y > x) {
            if (numbers[x] + numbers[y] == target) {
                return new int[]{x + 1, y + 1};
            }
            if (numbers[x] + numbers[y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 25, 75};
        int target = 100;
        System.out.println(Arrays.toString(new Solution().twoSum4(numbers, target)));

    }
}
