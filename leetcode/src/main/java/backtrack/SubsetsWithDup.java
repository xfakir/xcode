package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class SubsetsWithDup {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0) return result;
        Arrays.sort(nums);
        backtrace(nums,new ArrayList<>(),0,result);
        return result;
    }
    public void backtrace(int[] nums,List<Integer> list,int begin,List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = begin; i < nums.length; i++) {
            if (i>begin && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            backtrace(nums, list, i+1, result);
            list.remove(list.size() - 1);
        }
    }
}
