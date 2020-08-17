import java.util.Arrays;

public class Solution {
    //从右向左依次移动
    public void moveZeroes(int[] nums) {
        int y = nums.length - 1;
        for (int i = 0; i <= y; ) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            for (int j = i; j < y; j++) {
                int tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
            }
            y--;
        }
    }

    //直接把下一个不为零的数交换过来就行了
    public void moveZeroes2(int[] nums) {
        int y = nums.length - 1;
        for (int i = 0; i <= y; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = i + 1; j <= y; j++) {
                if (nums[j] != 0) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        }
    }

    //一次循环，把不等于0的都放到最左边
    public void moveZeroes3(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[x];
                nums[x] = tmp;
                x++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
