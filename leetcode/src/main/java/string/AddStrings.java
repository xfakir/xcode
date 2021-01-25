package string;

public class AddStrings {
    public String solution(String num1, String num2) {
        StringBuilder result = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >=0 || j >= 0) {
            int n1 = i>=0?num1.charAt(i)-'0':0;
            int n2 = j>=0?num2.charAt(j)-'0':0;
            int temp = n1 + n2 + carry;
            carry = temp/10;
            result.append(temp%10);
            i--;
            j--;
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "0123456789";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i)-'0');
        }
    }
}
