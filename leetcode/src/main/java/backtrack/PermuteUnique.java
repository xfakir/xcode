package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class PermuteUnique {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,0,result,new ArrayList<>(),used);
        return result;
    }

    public void backtrack(int[] nums,int depth,List<List<Integer>> result,List<Integer> list,boolean[] used) {

        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]&&!used[i-1]){
                continue;
            }
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
        PermuteUnique p = new PermuteUnique();
        int[] a = {1,1,3};
        System.out.println(p.solution(a));
    }
}
