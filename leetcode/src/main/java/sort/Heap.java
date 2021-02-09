package sort;

public class Heap {
    static int len;
    public static int[] sort(int[] nums) {
        len = nums.length;
        buildHeap(nums);
        while (len > 0) {
            swap(nums,0,len-1);
            len--;
            adjustHeap(nums,0);
        }
        return nums;
    }

    public static void buildHeap(int[] nums) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) {
            adjustHeap(nums, i);
        }
    }

    public static void adjustHeap(int[] nums,int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && nums[i * 2] > nums[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && nums[i * 2 + 1] > nums[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(nums, maxIndex, i);
            adjustHeap(nums, maxIndex);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
