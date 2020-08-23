import javafx.util.Pair;

import java.util.*;

/**
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        if(len != endWord.length() || wordList.size() == 0) {
            return 0;
        }
        Map<String, List<String>> table = new HashMap<>();
        wordList.forEach(word -> {
            for(int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> list = table.getOrDefault(newWord, new ArrayList<String>());
                list.add(word);
                table.put(newWord, list);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int level = pair.getValue();
            for(int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                for(String w : table.getOrDefault(newWord, new ArrayList<>())) {
                    if(w.equals(endWord)) {
                        return level + 1;
                    }
                    if(!visited.contains(w)) {
                        visited.add(w);
                        queue.add(new Pair<>(w, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
