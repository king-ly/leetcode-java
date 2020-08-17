import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> ab = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                int value = ab.get(sum) == null ? 0 : ab.get(sum);
                ab.put(sum, value + 1);
            }
        }
        HashMap<Integer, Integer> cd = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                int value = cd.get(sum) == null ? 0 : cd.get(sum);
                cd.put(sum, value + 1);
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> map : ab.entrySet()) {
            int target = 0 - map.getKey();
            if (cd.containsKey(target)) {
                sum = sum + map.getValue() * cd.get(target);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(new Solution().fourSumCount(A, B, C, D));
    }
}
