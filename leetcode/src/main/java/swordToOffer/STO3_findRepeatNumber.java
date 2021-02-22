package swordToOffer;

public class STO3_findRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] occur = new int[nums.length];
        for (int num : nums) {
            occur[num]++;
        }
        for (int i = 0; i < occur.length; i++) {
            if (occur[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                if (nums[nums[i]] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[nums[i]] = temp;
                }else {
                    return nums[i];
                }
            }
            i++;
        }
        return -1;
    }
}
