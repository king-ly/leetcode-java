import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            List list = hm.get(String.valueOf(c)) == null ? new ArrayList() : hm.get(String.valueOf(c));
            list.add(i);
            hm.put(String.valueOf(c), list);
        }
        for (Map.Entry<String, List<Integer>> map : hm.entrySet()) {
            List<String> list = new ArrayList();
            for (Integer index : map.getValue()) {
                list.add(strs[index]);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(strs);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
