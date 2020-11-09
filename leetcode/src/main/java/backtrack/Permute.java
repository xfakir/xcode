package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permute {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        boolean[] used = new boolean[nums.length];
        backtrack(nums,0,result,new ArrayList<>(),used);
        return result;
    }

    public void backtrack(int[] nums,int depth,List<List<Integer>> result,List<Integer> list,boolean[] used) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                list.add(nums[i]);
                used[i]=true;
                System.out.println("递归之后 => " + list);
                backtrack(nums,depth+1,result,list,used);
                used[i]=false;
                list.remove(list.size()-1);
                System.out.println("递归之后 => " + list);
            }
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] a = {1,2,3};
        System.out.println(p.solution(a));
    }
}
