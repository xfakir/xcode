package bitManipulation;

public class SingleNumber {
    public int solution(int[] nums) {
        int a = 0;
        for(int i : nums) {
            a ^= i;
        }
        return a;
    }
}
