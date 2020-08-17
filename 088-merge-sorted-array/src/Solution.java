import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newInt = Arrays.copyOf(nums1, m);
        for (int i = 0, x = 0, y = 0; i < m + n; i++) {
            if (x < m && (y >= n || newInt[x] <= nums2[y])) {
                nums1[i] = newInt[x];
                x++;
            } else {
                nums1[i] = nums2[y];
                y++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
