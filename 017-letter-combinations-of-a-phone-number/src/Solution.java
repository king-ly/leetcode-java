import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digists, int index, String s) {
        System.out.println(index+" : " + s);
        if (digists.length() == index) {
            res.add(s);
            return;
        }
        char c = digists.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digists, index + 1, s + letters.charAt(i));
        }
        return;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> list = new Solution().letterCombinations(digits);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
