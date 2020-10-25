package binary;

/**
 * 二分查找 704
 */
public class BasicBinarySearch {
    public int solution(int[] nums, int target) {
        return recursion(nums,target,0,nums.length-1);
    }

    public int recursion(int[] nums,int target,int left,int right) {
        if (left > right) return -1;
        int mid = (right-left)/2 + left;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return recursion(nums,target,left,mid-1);
        if (nums[mid] < target) return recursion(nums,target,mid+1,right);
        return -1;
    }

    public int solution_iteration(int[] nums,int target) {
        int mid;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            mid = (right-left)/2 + left;
            if (target == nums[mid]) return mid;
            else if(target > nums[mid]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }

    public int solution_iteration2(int[] nums,int target) {
        int mid;
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            mid = (right-left)/2 + left;
            System.out.println("left: "+left+" right: "+right+" mid: "+mid);
            if (target == nums[mid]) return mid;
            else if(target > nums[mid]) left = mid+1;
            else right = mid-1;
        }
        return nums[left]==target?left:-1;
    }

    public static void main(String[] args) {
        BasicBinarySearch b = new BasicBinarySearch();
        int[] nums = {1,2,3,4};
        System.out.println(b.solution_iteration2(nums,3));
    }
}
