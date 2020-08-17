import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int size = hm1.get(nums1[i]) == null ? 1 : hm1.get(nums1[i]) + 1;
            hm1.put(nums1[i], size);
        }
        for (int i = 0; i < nums2.length; i++) {
            int size = hm2.get(nums2[i]) == null ? 1 : hm2.get(nums2[i]) + 1;
            hm2.put(nums2[i], size);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : hm1.keySet()) {
            int minSize = Math.min(hm1.get(key) == null ? 0 : hm1.get(key), hm2.get(key) == null ? 0 : hm2.get(key));
            for (int i = 0; i < minSize; i++) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int size = hm1.get(nums1[i]) == null ? 1 : hm1.get(nums1[i]) + 1;
            hm1.put(nums1[i], size);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int size = hm1.get(nums2[i]) == null ? 0 : hm1.get(nums2[i]);
            if (size > 0) {
                list.add(nums2[i]);
                hm1.put(nums2[i], size - 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] result = new Solution().intersect2(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
