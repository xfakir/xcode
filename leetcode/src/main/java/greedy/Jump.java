package greedy;

public class Jump {
    public int jump(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos,i+nums[i]);
            }
            start = end;
            end = maxPos + 1;
            ans++;
        }
        return ans;

    }
}
