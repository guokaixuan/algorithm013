import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
public class IsAnagram {

    /**
     * 哈希表
     * 使用数组记录a-z出现的次数，s中的出现的字母+1，t中出现的字母-1，最后检查哈希表中是否有不等于0的情况
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for(int c : counter) {
            if(c != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将两个字符串的字符排序后比较是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
