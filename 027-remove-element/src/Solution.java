public class Solution {
    public int removeElement(int[] nums, int val) {
        int j = nums.length;
        for (int i = 0; i < j; ) {
            if (nums[i] == val) {
                j--;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                i++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(new Solution().removeElement(nums,val));
    }
}
