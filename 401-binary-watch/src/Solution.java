import java.util.*;
import java.util.stream.Collectors;

//超时了
public class Solution {
    private int[] hours = {1, 2, 4, 8};
    private int[] minutes = {1, 2, 4, 8, 16, 32};
    private List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        brackTrace(num, new ArrayDeque<>(), new ArrayDeque<>());
        return res;
    }

    private void brackTrace(int nums, Deque<Integer> hoursList, Deque<Integer> minutesList) {
        if (nums == hoursList.size() + minutesList.size()) {
            int hourSum = hoursList.stream().collect(Collectors.summingInt(Integer::intValue));
            int minuteSum = minutesList.stream().collect(Collectors.summingInt(Integer::intValue));
            String time = String.format("%d:%02d", hourSum, minuteSum);
            if (!res.contains(time) && hourSum < 12 && minuteSum < 60) {
                res.add(time);
            }
            return;
        }

        for (int i = 0; i < hours.length; i++) {
            if (hoursList.contains(hours[i])) {
                continue;
            }
            hoursList.addLast(hours[i]);
            brackTrace(nums, hoursList, minutesList);
            hoursList.removeLast();

        }
        for (int i = 0; i < minutes.length; i++) {
            if (minutesList.contains(minutes[i])) {
                continue;
            }
            minutesList.addLast(minutes[i]);
            brackTrace(nums, hoursList, minutesList);
            minutesList.removeLast();
        }
    }

    public static void main(String[] args) {
        int num = 8;
        List<String> res = new Solution().readBinaryWatch(num);
        System.out.println(Arrays.toString(res.toArray()));

    }

}
