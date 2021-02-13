package dp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            result = Math.max(dp[i],result);
        }

        return result;
    }

    public int maxSubArray_O1(int[] nums) {
        int pre = 0;
        int result = nums[0];
        for (int num : nums) {
            pre = Math.max(pre+num,num);
            result = Math.max(result,pre);
        }

        return result;
    }
}
