package greedy;

public class WiggleMaxLength {
    public int solution(int[] nums) {
        if (nums.length<=1) return nums.length;
        int length = 1;
        int preDiff=0;
        int curDiff=0;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];
            if ((curDiff>0 && preDiff <= 0) || (curDiff <=0 && preDiff > 0)) {
                length++;
                preDiff = curDiff;
            }
        }
        return length;
    }
}
