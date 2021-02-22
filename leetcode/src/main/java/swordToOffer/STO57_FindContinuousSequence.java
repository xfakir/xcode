package swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class STO57_FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int left = 1;
        int right = left;
        int sum = 0;
        while (right < target) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum == target) {
                int[] arr = new int[right-left];
                for (int i = left; i < right; i++) {
                    arr[i-left] = i;
                }
                result.add(arr);

                sum -= left;
                left++;
            } else {

                sum -= left;
                left++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
