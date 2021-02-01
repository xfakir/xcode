package string;

public class Multiply {
    public String solution(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < num2.length() - i - 1; j++) {
                temp.append("0");
            }
            int n1 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n2 = num1.charAt(j) - '0';
                temp.append((n1 * n2 + carry)%10);
                carry = (n1 * n2 + carry)/10;
            }
            if (carry != 0) {
                temp.append(carry);
            }
            System.out.println(temp);
            result = addString(result,temp.reverse().toString());
        }
        return result;
    }

    private String addString(String num1,String num2) {
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
        Multiply m = new Multiply();
        System.out.println(m.solution("9", "99"));
    }
}
