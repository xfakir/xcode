package heap;

import java.util.Random;

public class FindKthLargest {
    private Random random = new Random();
    public int solution(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums,left,right);
            System.out.println(index);
            if (index > target) {
                right = index-1;
            } else if (index < target) {
                left = index+1;
            } else {
                return nums[index];
            }

        }
    }

    public int partition(int[] nums,int left,int right) {
        if (right > left) {
            int randomIndex = left + random.nextInt(right-left) + 1;
            swap(nums,left,randomIndex);
            System.out.println(randomIndex);
        }
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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] a = {3,2,3,1,2,4,5,5,6};
        System.out.println(f.solution(a,4));
    }
}
