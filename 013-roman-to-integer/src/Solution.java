class Solution {
    public int romanToInt(String s) {
        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            if (i + 2 <= s.length() && getValue(s.substring(i, i + 2)) != 0) {
                sum = sum + getValue(s.substring(i, i + 2));
                i = i + 2;
            } else {
                sum = sum + getValue(s.substring(i, i + 1));
                i = i + 1;
            }
        }
        return sum;
    }

    private int getValue(String ch) {
        switch(ch) {
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            case "IV": return 4;
            case "IX": return 9;
            case "XL": return 40;
            case "XC": return 90;
            case "CD": return 400;
            case "CM": return 900;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(new Solution().romanToInt(str));
    }
}