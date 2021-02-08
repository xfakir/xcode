package heap;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            int occurence = frequentMap.getOrDefault(num, -1);
            frequentMap.put(num,occurence+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return frequentMap.get(o1)-frequentMap.get(o2);
            }
        });

        for (Integer key : frequentMap.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (frequentMap.get(key) > frequentMap.get(heap.peek())){
                heap.remove();
                heap.add(key);
            }
        }
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = heap.remove();
        }
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        int[] res1 = res.stream().mapToInt(Integer::valueOf).toArray();
        return res1;
    }

    /**
     * 7ms
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        int[] result = new int[k];
        Arrays.sort(nums);
        int n = nums[0];
        int count = 0;
        Queue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != n){
                queue.offer(new int[]{n, count});
                n = nums[i];
                count = 1;
            }else {
                count++;
            }
        }
        queue.offer(new int[]{n, count});
        while (k > 0) {
            k--;
            result[k] = queue.poll()[0];
        }

        return result;
    }

}
