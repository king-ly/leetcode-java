import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int size = hm.get(c) == null ? 0 : hm.get(c);
            hm.put(c, size + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuffer response = new StringBuffer();
        for (Map.Entry<Character, Integer> map : list) {
            for (int i = 0; i < map.getValue(); i++) {
                response.append(map.getKey());
            }
        }
        return response.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(new Solution().frequencySort(s));
    }
}
