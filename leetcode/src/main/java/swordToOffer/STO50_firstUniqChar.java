package swordToOffer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class STO50_firstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }
        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    public char better(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c]++;
        for(char c : chars){
            if(count[c] == 1)
                return c;
        }
        return ' ';
    }
}
