package slidingWindow;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *
 */
public class MaxTurbulenceSize {
    public int solution(int[] arr) {
        if (arr.length == 0) return 0;
        int start=0,end=0;
        //0: arr[end]<arr[end-1]
        //1: arr[end]>arr[end-1]
        int flag=0;
        int max = 0;
        while (end<arr.length) {
            if (end == arr.length-1){
                max = Math.max(max,end-start+1);
                break;
            }
            else if (end==start) {
                end++;
                flag = arr[end] > arr[end-1]?1:0;
                if (arr[end] == arr[end-1]) {
                    start++;
                }
            }

            else if (arr[end] > arr[end+1] && flag == 1) {
                end++;
                flag=0;
            }
            else if (arr[end] < arr[end+1] && flag == 0) {
                end++;
                flag=1;
            } else {
                System.out.println("---------------");
                System.out.println(start);
                System.out.println(end);
                System.out.println("---------------");
                max = Math.max(max,end-start+1);
                start = end;
                end++;
                flag = arr[end] > arr[end-1]?1:0;
            }
        }
        return max;
    }
    //8ms
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                if (c != 0) ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }

    //5ms
    public int maxTurbulenceSize2(int[] arr) {
        int num = 0;
        int maxNum = 0;
        char a = '>';
        for (int i = 1; i < arr.length; i++) {
            if ((a == '>' && arr[i] > arr[i - 1]) || (a == '<' && arr[i] < arr[i - 1])) {
                num++;
                if (maxNum < num) {
                    maxNum = num;
                }
            } else {
                if(arr[i] != arr[i - 1]){
                    i--;
                }
                num = 0;
            }
            if (a == '>') {
                a = '<';
            } else {
                a = '>';
            }
        }
        return maxNum+1;
    }

    //4ms
    public int maxTurbulenceSize3(int[] arr) {
        boolean begin = false;

        int position = -1;//0为左大于右，1为右大于左
        int maxLength = 1;
        int length = 1;
        for(int i = 1;i < arr.length;i++)
        {
            if(begin == false)
            {
                if(arr[i] > arr[i - 1])
                {
                    if(position == 0) length++;
                    position = 1;
                    begin = true;
                    length++;
                }
                else if(arr[i] < arr[i - 1])
                {
                    if(position == 1) length++;
                    position = 0;
                    begin = true;
                    length++;
                }
            }
            else
            {
                if(position == 1)
                {
                    if(arr[i] > arr[i - 1])
                    {
                        begin = false;
                        if(length > maxLength)
                        {
                            maxLength = length;
                        }
                        length = 1;
                    }
                    else if(arr[i] < arr[i - 1])
                    {
                        position = 0;
                        length++;
                    }
                    else
                    {
                        position = -1;
                        begin = false;
                        if(length > maxLength)
                        {
                            maxLength = length;
                        }
                        length = 1;
                    }
                }
                else
                {
                    if(arr[i] < arr[i - 1])
                    {
                        begin = false;
                        if(length > maxLength)
                        {
                            maxLength = length;
                        }
                        length = 1;
                    }
                    else if(arr[i] > arr[i - 1])
                    {
                        position = 1;
                        length++;
                    }
                    else
                    {
                        position = -1;
                        begin = false;
                        if(length > maxLength)
                        {
                            maxLength = length;
                        }
                        length = 1;
                    }
                }
            }
        }
        if(length > maxLength)
        {
            maxLength = length;
        }
        return maxLength;
    }

    //TODO dp

    public static void main(String[] args) {
        MaxTurbulenceSize m = new MaxTurbulenceSize();
        int[] arr = {0,8,45,88,48,68,28,55,17,24};
        System.out.println(m.solution(arr));
    }
}
