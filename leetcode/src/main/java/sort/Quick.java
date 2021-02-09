package sort;

public class Quick {
    public static int[]  sort(int[] nums) {
        return sort(nums,0,nums.length-1);
    }

    public static int[]  sort(int[] nums, int left, int right) {
        if (left >= right) {
            return nums;
        }
        int pivot = partition(nums,left,right);
        sort(nums,left,pivot-1);
        sort(nums,pivot+1,right);
        return nums;
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
