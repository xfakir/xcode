package twoPointers;

/**
 *  Leetcode.11
 */
public class MaxArea {
    public int solution(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        int area = 0;
        while (left != right) {
            area = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left]<height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
