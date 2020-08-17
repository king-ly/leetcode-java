/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *  最后的结果还得排序。说明这就是一个排序的算法。只要在排序基础上添加了去重
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int size =nums.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; ) {
                if (nums[j] < nums[min]) {
                    min = j;
                    j++;
                }else if (nums[j] == nums[min]){
                    size --;
                    int tmp = nums[j];
                    nums[j] = nums[size];
                    nums[size] = tmp;
                }else {
                    j++;
                }
            }
            //进行交换
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}
