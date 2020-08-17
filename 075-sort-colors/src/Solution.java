import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int[] cnt = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < cnt[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < cnt[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < cnt[2]; i++) {
            nums[index++] = 2;
        }
    }

    //选择排序
    public void sortColors2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //交换位置
            int tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
    }

    //冒泡排序
    public void sortColors3(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j + 1 <= i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    //插入排序
    public void sortColors4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    //三路快排
    public void sortColors5(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 2) {
                //交换 i ,two
                two--;
                int tmp = nums[two];
                nums[two] = nums[i];
                nums[i] = tmp;

            } else if (nums[i] == 0) {
                //交换 i ,zero
                zero++;
                int tmp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = tmp;
                i++;
            } else {
                //当 num[i] == 1 时
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1};
        new Solution().sortColors5(nums);
        System.out.println(Arrays.toString(nums));
    }
}
