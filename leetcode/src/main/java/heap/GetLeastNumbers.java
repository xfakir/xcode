package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class GetLeastNumbers {

    private Random random = new Random();

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int[] result = new int[k];
        while (true) {
            int index = partition(arr,left,right);
            if (index == k) {
                return Arrays.copyOf(arr,k);
            } else if (index > k){
                right = index-1;
            } else {
                left = index + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        System.out.println("left: "+ left);
        System.out.println("right: "+ right);
        int index = left + random.nextInt(right - left + 1) ;
        System.out.println("random: " + index);
        swap(nums,left,index);

        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        System.out.println(left);
        return left;
    }

    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int[] getLeastNumbers_heap(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int num : arr) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        int[] result = new int[heap.size()];
        int i = 0;
        for (int num : heap) {
            result[i++] = num;
        }
        return result;

    }


    public static void main(String[] args) {
        GetLeastNumbers g = new GetLeastNumbers();
        int[] a = {0,0,2,3,2,1,1,2,0,4};
        System.out.println(Arrays.toString(g.getLeastNumbers(a, 10)));
    }
}
