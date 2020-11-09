package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Combine {
    public List<List<Integer>> solution(int n,int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n<1 || k==0) return result;
        backtrace(n,k,new ArrayList<>(),1,result);
        return result;
    }
    public void backtrace(int n,int k,List<Integer> list,int begin,List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= n; i++) {
            list.add(i);
            backtrace(n,k,list,i+1,result);
            list.remove(list.size()-1);
        }

    }

    public void backtrace_better(int n,int k,List<Integer> list,int begin,List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrace(n,k,list,i+1,result);
            list.remove(list.size()-1);
        }

    }

}
