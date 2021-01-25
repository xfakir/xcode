package string;

public class MyAtoi {
    public int solution(String s) {
        if (s == null) return 0;
        //去前导空格
        char[] chars = s.toCharArray();
        int length = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] != ' ') {
                break;
            }
            length++;
            i++;
        }
        s = s.substring(length);
        System.out.println(s);
        chars = s.toCharArray();
        if (s.length() == 0) return 0;

        //检查正负号
        int isPositive = -1;
        char firstChar = chars[0];
        if (firstChar != '-') {
            isPositive = 1;
        }
        if (firstChar == '+' || firstChar == '-') {
            s = s.substring(1);
        }
        System.out.println(s);
        chars = s.toCharArray();

        //读取数字
        i = 0;
        length = 0;
        while (i < chars.length) {
            if (!Character.isDigit(chars[i])) {
                break;
            }
            length++;
            i++;
        }
        s = s.substring(0,length);

        /*i = 0;
        length = 0;
        while (i < chars.length) {
            if (!Character.isDigit(chars[i])) {
                break;
            }
            length++;
            i++;
        }
        s = s.substring(length);*/

        System.out.println(s);

        if (s.length() == 0) {
            return 0;
        }

        //前导0
        length = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] != '0') {
                break;
            }
            length++;
        }
        s = s.substring(length);
        if (s.length() == 0) {
            return 0;
        }
        System.out.println(s);

        //转整数
        int result = 0;
        chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            char currChar = chars[j];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            result = result * 10 + isPositive * (currChar - '0');

        }
        return result;

    }

    public static void main(String[] args) {
        MyAtoi a = new MyAtoi();
        String s = " -42";
        System.out.println(a.solution(s));
    }
}
