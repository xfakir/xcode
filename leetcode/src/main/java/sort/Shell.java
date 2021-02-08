package sort;

public class Shell {
    public static int[] sort(int[] nums) {
        int gap = nums.length/2;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > temp) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = temp;
            }
            gap /= 2;
        }

        return nums;
    }
}
