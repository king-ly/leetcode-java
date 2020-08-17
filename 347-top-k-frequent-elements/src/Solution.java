import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int size = hm.get(nums[i]) + 1;
                hm.put(nums[i], size);
            } else {
                hm.put(nums[i], 1);
            }
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue(new Comparator<Map.Entry<Integer, Integer>>() {
            //降序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry map : hm.entrySet()) {
            pq.add(map);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(pq.poll().getKey());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int size = hm.get(nums[i]) + 1;
                hm.put(nums[i], size);
            } else {
                hm.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(hm.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        return list.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).limit(k).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = new Solution().topKFrequent2(nums, k);
        System.out.println(Arrays.toString(result));

    }
}
