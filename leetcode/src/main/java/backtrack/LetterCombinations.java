package backtrack;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {
    private Map<String, List<String>> map = new HashMap<>();

    @PostConstruct
    private void construct() {
        map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }

    public List<String> solution(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, map, digits, 0, new StringBuffer());
        return combinations;

    }

    public void backtrack(List<String> combinations, Map<String, List<String>> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            List<String> letters = phoneMap.get(String.valueOf(digit));
            for (String letter : letters) {
                combination.append(letter);
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
