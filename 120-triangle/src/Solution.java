import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    private Integer[][] nums;

    public int minimumTotal(List<List<Integer>> triangle) {
        nums = new Integer[triangle.size() + 1][triangle.get(0).size() + 1];
        return recursion2(triangle, 0, 0);
    }

    private int recursion(List<List<Integer>> triangle, int x, int y) {
        if (x == triangle.size()) {
            return 0;
        }
        return Math.min(recursion(triangle, x + 1, y), recursion(triangle, x + 1, y + 1)) + triangle.get(x).get(y);
    }

    private int recursion2(List<List<Integer>> triangle, int x, int y) {
        if (x == triangle.size()) {
            return 0;
        }
        if (nums[x][y] == null) {
            nums[x][y] = Math.min(recursion2(triangle, x + 1, y), recursion2(triangle, x + 1, y + 1)) + triangle.get(x).get(y);
        }
        return nums[x][y];
    }



    public static void main(String[] args) {
        Integer[][] nums = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                list.add(nums[i][j]);
            }
            triangle.add(list);
        }
        int n = new Solution().minimumTotal(triangle);
        System.out.println(n);
    }

}
