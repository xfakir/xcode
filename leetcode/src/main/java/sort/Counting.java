package sort;

import java.util.Arrays;

public class Counting {
    public static int[] sort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket,0);
        for (int num : nums) {
            bucket[num - min]++;
        }
        int index = 0;
        int i = 0;
        while (index < nums.length) {
            if (bucket[i] != 0) {
                nums[index] = i + min;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return nums;
    }
}
