package string;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> solution(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = Arrays.toString(chars);
            List<String> list = map.getOrDefault(string, new ArrayList<>());
            list.add(str);
            map.put(string,list);
        }
        return new ArrayList<>(map.values());
    }
}
