package slidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinWindow {

    Map<Character,Integer> tMap = new HashMap<>();
    Map<Character,Integer> tempMap = new HashMap<>();

    public String solution(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(tChar[i],tMap.getOrDefault(tChar[i],0)+1);
        }
        int start = 0;
        int end = 0;
        int subLeft = -1;
        int subRight = -1;
        int subLength = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (tMap.containsKey(sChar[end])) {
                tempMap.put(sChar[end],tempMap.getOrDefault(sChar[end],0)+1);
            }
            while (check(tMap,tempMap) && start <= end) {
                if (end - start + 1 < subLength) {
                    subLength = end - start + 1;
                    subLeft = start;
                    subRight = subLeft +subLength;
                }
                if (tMap.containsKey(sChar[start])) {
                    tempMap.put(sChar[start],tempMap.get(sChar[start])-1);
                }
                start++;
            }
            end++;
        }
        return subLeft == -1?"":s.substring(subLeft,subRight);
    }

    private boolean check(Map<Character, Integer> tMap, Map<Character, Integer> tempMap) {
        for (Map.Entry<Character, Integer> next : tMap.entrySet()) {
            if (next.getValue() > tempMap.getOrDefault(next.getKey(),0)) {
                return false;
            }
        }
        return true;
    }

    public String solution2(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int sLen = s.length();
        int tLen = t.length();

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        //s中出现对应字符的次数
        int[] sFreq = new int[128];
        //t中出现对应字符的次数
        int[] tFreq = new int[128];
        //初始化t中出现对应字符的次数
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        int left = 0;
        int right = 0;
        int subLeft = -1;
        int subRight = -1;
        int subLength = s.length() + 1;

        int match = 0;

        while (right < s.length()) {
            if (tFreq[charArrayS[right]] == 0) {
                right++;
                continue;
            }
            if(sFreq[charArrayS[right]] < tFreq[charArrayS[right]]){
                match++;
            }
            sFreq[charArrayS[right]]++;
            right++;

            while (match == t.length()) {
                if (right - left < subLength) {
                    subLength = right - left;
                    subLeft = left;
                    subRight = subLeft +subLength;
                }
                if(tFreq[charArrayS[left]] == 0){
                    left++;
                    continue;
                }
                if(sFreq[charArrayS[left]] == tFreq[charArrayS[left]]){
                    match--;
                }
                sFreq[charArrayS[left]]--;
                left++;
            }
        }
        return subLength == s.length()+1?"":s.substring(subLeft,subRight);
    }

    public static void main(String[] args) {
        MinWindow m = new MinWindow();
        System.out.println(m.solution2("cwaefgcf", "cae"));
    }
}
