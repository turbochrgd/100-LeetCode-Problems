class Solution {
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static final int TEN = 10;
    public static final int HUNDRED = 100;
    public static final int THOUSAND = 1000;
    public static final int MILLION = 1000000;
    public static final int BILLION = 1000000000;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return helper(num).trim();
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= BILLION) {
            sb.append(helper(num / BILLION)).append(" Billion ").append(helper(num % BILLION));
        } else if (num >= MILLION) {
            sb.append(helper(num / MILLION)).append(" Million ").append(helper(num % MILLION));
        } else if (num >= THOUSAND) {
            sb.append(helper(num / THOUSAND)).append(" Thousand ").append(helper(num % THOUSAND));
        } else if (num >= HUNDRED) {
            sb.append(helper(num / HUNDRED)).append(" Hundred ").append(helper(num % HUNDRED));
        } else if (num >= 20) {
            sb.append(tens[num / TEN]).append(" ").append(helper(num % TEN));
        } else {
            sb.append(ones[num]);
        }
        return sb.toString().trim();
    }
}


