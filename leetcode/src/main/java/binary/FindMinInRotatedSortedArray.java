package binary;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 */
public class FindMinInRotatedSortedArray {
    public int solution(int[] nums) {
        int mid;
        int left=0,right=nums.length-1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            mid = left + (right-left)/2;
            min = Math.min(nums[mid], min);
            if (nums[mid] < nums[left]) {
                right = mid-1;
            } else if (nums[mid] > nums[left] && nums[mid] < nums[right]){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return Math.min(nums[left],min);
    }

    public int solution2(int[] nums) {
        int mid;
        int left=0,right=nums.length-1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            mid = left + (right-left)/2;
            min = Math.min(nums[mid], min);
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return Math.min(nums[left],min);
    }

    public int solution_better(int[] nums) {
        int mid;
        int left=0,right=nums.length-1;
        while (left < right) {
            mid = left + (right-left)/2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArray f =new FindMinInRotatedSortedArray();
        int[] a = {4,5,6,7,0,1,2};
        f.solution(a);
    }
}
