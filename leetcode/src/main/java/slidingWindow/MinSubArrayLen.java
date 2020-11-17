package slidingWindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *  
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 */
public class MinSubArrayLen {
    public int solution(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        int start=0,end=0;
        while (end<nums.length) {
            if (isSumOver(nums,start,end,s)) {
                result = Math.min(result,end-start+1);
                start++;
            } else {
                end++;
            }
        }
        return result == Integer.MAX_VALUE?0:result;
    }

    public int solution2(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start=0,end=0;
        while (end<nums.length) {
            sum += nums[end];
            while (sum >= s) {
                result = Math.min(result,end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;

        }
        return result == Integer.MAX_VALUE?0:result;
    }

    //TODO O(nlogn)

    private boolean isSumOver(int[] nums,int start,int end,int s) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum >= s;
    }
}
