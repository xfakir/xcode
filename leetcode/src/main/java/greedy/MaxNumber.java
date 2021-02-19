package greedy;

public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxSequence = new int[k];
        int start = Math.max(0,k-n);
        int end = Math.min(k,m);
        for (int i = start; i <= end; i++) {
            int[] subSequence1 = maxSubSequence(nums1,i);
            int[] subSequence2 = maxSubSequence(nums2,k-i);
            int[] curMaxSequence = merge(subSequence1,subSequence2);
            if (compare(curMaxSequence, 0, maxSequence, 0) > 0) {
                System.arraycopy(curMaxSequence, 0, maxSequence, 0, k);
            }
        }
        return maxSequence;
    }

    private int[] merge(int[] subSequence1, int[] subSequence2) {
        int x = subSequence1.length, y = subSequence2.length;
        if (x == 0) {
            return subSequence2;
        }
        if (y == 0) {
            return subSequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subSequence1, index1, subSequence2, index2) > 0) {
                merged[i] = subSequence1[index1++];
            } else {
                merged[i] = subSequence2[index2++];
            }
        }
        return merged;

    }

    private int compare(int[] subSequence1, int index1, int[] subSequence2, int index2) {
        int x = subSequence1.length, y = subSequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subSequence1[index1] - subSequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    private int[] maxSubSequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length-k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k-1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }
}
