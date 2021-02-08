package sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = {3,8,4,5,2,7,9,6,11,12,13,15,48,24,17,99,444,222,333,456,815,237,111,20,101,1};
        System.out.println(Arrays.toString(Shell.sort(nums)));
    }
}
