package twoPointers;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *  
 *
 * 提示：
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 */
public class Merge {

    public void solution(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;

        for (int i = length; i >= 0; i--) {
            if (m - 1 < 0) {
                nums1[i] = nums2[n - 1];
                n--;
            } else if (n - 1 < 0) {
                nums1[i] = nums1[m - 1];
                m--;

            } else if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;

            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        Merge m = new Merge();
        int[] a = {2,0};
        int[] b = {1};
        m.solution(a,1,b,1);
        System.out.println(Arrays.toString(a));
    }
}
