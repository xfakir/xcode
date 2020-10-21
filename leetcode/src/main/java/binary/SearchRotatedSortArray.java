package binary;

/**
 * L.33
 * 给定一个升序排列的整数数组nums，和一个整数target
 * 假设数组预先在未知的某一个点进行了旋转
 *
 * 在数组中搜索target，如果存在返回它的索引，否则返回-1
 *
 */
public class SearchRotatedSortArray {

    public int solution(int[] nums,int target) {
        return recursion(nums,target,0,nums.length-1);
    }

    public int recursion(int[] nums,int target,int left,int right) {
        if (left > right) return -1;
        int mid = (right-left)/2 + left;
        if (target == nums[mid]) return mid;
        if (nums[mid] > nums[left]) {
            if (target > nums[mid]) return recursion(nums,target,mid+1,right);
            else if (target < nums[mid]) {
                if (target > nums[left]) return recursion(nums,target,left,mid-1);
                else if (target < nums[left]) return recursion(nums,target,mid+1,right);
                else return left;
            }
        } else if (nums[mid] < nums[left]) {
            if (target < nums[mid]) return recursion(nums,target,left,mid-1);
            else if (target > nums[mid]) {
                if (target > nums[left]) return recursion(nums,target,left,mid-1);
                else if (target < nums[left]) return recursion(nums,target,mid+1,right);
                else return left;
            }
        } else {
            return recursion(nums,target,mid+1,right);
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortArray s = new SearchRotatedSortArray();
        int[] nums = {4,5,6,7,0,1,2};
        int r = s.solution(nums,0);
        System.out.println(r);
    }

}
