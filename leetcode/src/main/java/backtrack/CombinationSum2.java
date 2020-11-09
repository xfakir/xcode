package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * candidates 中的每个数字在每个组合中只能使用一次
 */
public class CombinationSum2 {
    public List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,result,new ArrayList<>(),0);
        return result;
    }

    public void backtrack(int[] candidates,int target,List<List<Integer>> result,List<Integer> list,int begin) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i>begin && candidates[i] == candidates[i-1]){
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            System.out.println("递归之前 => " + list + "，剩余 = " + (target - candidates[i]));

            backtrack(candidates,target-candidates[i],result,list,i+1);

            list.remove(list.size()-1);
            System.out.println("递归之后 => " + list);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 c= new CombinationSum2();
        int[] a = {10,1,2,7,6,1,5};
        System.out.println(c.solution(a,8));
    }
}
