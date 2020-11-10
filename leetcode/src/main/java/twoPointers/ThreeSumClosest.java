package twoPointers;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeSumClosest {
    public int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int left,right;
        int sum;
        int difference=Integer.MAX_VALUE;
        int result=target;
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            left = i+1;
            right = nums.length-1;
            while (left<right){
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target){
                    while(left != right && nums[left] == nums[left-1])
                        left++;
                    left++;
                } else {
                    while(left != right && nums[right] == nums[right+1])
                        right--;
                    right--;
                }

                if (Math.abs(target - sum) < difference) {
                    result = sum;
                    difference = Math.abs(target - sum) ;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int[] a = {-1,2,1,-4};
        System.out.println(t.solution(a,1));
    }
}
