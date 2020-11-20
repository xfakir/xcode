package slidingWindow;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 *
 */
public class LongestOnes {
    public int solution(int[] A, int K) {
        int start=0,end=0;
        int firstZero = 0;
        int zero = 0;
        int max = 0;
        while (end < A.length) {
            if (A[end] == 1) {
                end++;
            } else {
                if (zero == 0) {
                    firstZero = end;
                }

                if (zero+1 <= K) {
                    zero++;
                    end++;
                } else {
                    System.out.println(max);
                    start = firstZero+1;
                    end++;
                }
            }

            max = Math.max(max,end-start);
        }
        return max;
    }

    public int solution2(int[] A, int K) {
        if (A == null || K < 0) {
            return 0;
        }
        int sum = 0;
        int windowSize =0;
        int right =0;
        int left = 0;
        while(right<A.length){
            sum +=A[right];
            if(sum + K > windowSize){
                // 是 1 扩大窗口
                windowSize++;
            }else{
                // 是 0 平移窗口
                sum -= A[left];
                left++;
            }
            right++;
        }
        return windowSize;
    }

    public static void main(String[] args) {
        LongestOnes l = new LongestOnes();
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(l.solution2(A,2));
    }
}
