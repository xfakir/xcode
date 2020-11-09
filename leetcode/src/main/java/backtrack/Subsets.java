package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Subsets {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0) return result;
        backtrace(nums,new ArrayList<>(),0,result);
        return result;
    }

    public void backtrace(int[] nums,List<Integer> list,int begin,List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);
            System.out.println("递归之前 => " + list);
            backtrace(nums, list, i+1, result);
            list.remove(list.size() - 1);
            System.out.println("递归之后 => " + list);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(s.solution(nums));
    }
}
