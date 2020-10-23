package binary;

/**
 * 给定排序数组和一个target 找出开始位置和结束位置
 * 若不存在，则返回[-1,-1]
 */
public class SearchRange {
    public int[] solution(int[] nums,int target) {
        int[] result={-1,-1};
        if (nums.length == 0) {
            return result;
        }
        int mid;
        int left = 0, right = nums.length-1;
        while (left < right) {
            mid = (right-left)/2 + left;
            if (target == nums[mid]) {
                result[0] = mid;
                right = mid-1;
            }
            else if(target > nums[mid]) left = mid+1;
            else right = mid-1;
        }
        if (nums[left] == target) {
            result[0] = left;
        }
        if (result[0] == -1) {
            return result;
        }
        left = 0;
        right = nums.length-1;
        while (left < right) {
            mid = (right-left)/2 + left;
            if (target == nums[mid]) {
                result[1] = mid;
                left = mid+1;
            }
            else if(target > nums[mid]) left = mid+1;
            else right = mid-1;
        }
        if (nums[left] == target) {
            result[1] = left;
        }
        return result;
    }
}
