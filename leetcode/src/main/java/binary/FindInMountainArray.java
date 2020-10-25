package binary;

public class FindInMountainArray {
    public int solution(int target, MountainArray mountainArr) {
        int left,right,mid;
        int peek = getPeek(mountainArr);
        left=0;
        right=peek;
        while(left<right){
            mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target) return mid;
            if(mountainArr.get(mid)<target) left=mid+1;
            if(mountainArr.get(mid)>target) right=mid;
        }
        if(mountainArr.get(left)==target) return left;
        left=peek+1;
        right=mountainArr.length()-1;
        while(left<right){
            mid=left+(right-left)/2;
            if(mountainArr.get(mid)==target) return mid;
            if(mountainArr.get(mid)<target) right=mid;
            if(mountainArr.get(mid)>target) left=mid+1;
        }
        return mountainArr.get(left)==target?left:-1;
    }

    public int getPeek(MountainArray mountainArr){
        int left=0,right=mountainArr.length()-1;
        int mid;
        while (left < right) {
            mid=left+(right-left)/2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
}
interface MountainArray {
    public int get(int index);
    public int length();
}
