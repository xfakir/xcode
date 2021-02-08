package sort;

/**
 * 冒泡排序
 */
public class Bubble {
    public static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length -1 ; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     *
     * 优化1：
     * flag标志，若一次遍历未发生交换，说明已经排序完成 直接返回
     *
     * @param nums
     * @return
     */
    public static int[] sortOpt1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                return nums;
            }
        }
        return nums;
    }

    /**
     *
     * 在优化1的基础上优化2
     * 若一趟中一次遍历 某次交换之后未发生交换，那么之后也不会发生交换
     *
     * @param nums
     * @return
     */
    public static int[] sortOpt2(int[] nums) {
        int len = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int flag = 0;
            int lastSwapPos = -1;
            for (int j = 0; j < len; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = 1;
                    lastSwapPos = j;
                }
            }
            len = lastSwapPos;
            if (flag == 0) {
                return nums;
            }
        }
        return nums;
    }
}
