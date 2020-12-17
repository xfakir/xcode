package bitManipulation;

public class SingleNumber2 {
    /**
     * 摩尔投票法
     * 投票法正确思路：不妨假设整个数组的众数记做a，则最初的数组中a的数量大于其余所有数。当采用count计数的时候有两种情况：
     *
     * 1）假设candidate等于a，则当count从1变为0的过程，此区间内a的数量等于其余数的数量，因此以count=0为分界线，数组右端部分的众数仍然为a
     *
     * 2）假设candidate不等于a，则当count从1变为0的过程， 此区间内a的数量小于等于其余数的数量，因此以count=0为分界线，数组右端部分的众数仍然为a
     *
     * 因此，以count=0可以将整个原始数组分为若干部分，count=0右端部分的数组中的众数永远是a，最终必然会筛选出a
     *
     *
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i : nums) {
            if (candidate == i) {
                count++;
            } else if (--count == 0) {
                candidate = i;
                count = 1;
            }
        }
        return candidate;
    }
}
