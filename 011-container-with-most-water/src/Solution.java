public class Solution {
    //双层循环，时间复杂度高
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length - 1; j > i; j--) {
                if (Math.min(height[i], height[j]) * (j - i) > max) {
                    max = Math.min(height[i], height[j]) * (j - i);
                }
            }
        }
        return max;
    }

    //对撞指针方法
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (r > l) {
            if (max < Math.min(height[l], height[r]) * (r - l)) {
                max = Math.min(height[l], height[r]) * (r - l);
            }
            //谁小谁移动，移动完成之后比max面积
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea2(height));
    }
}
