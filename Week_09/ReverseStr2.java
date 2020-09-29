/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * 提示：
 *
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 */
public class ReverseStr2 {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() < 1) {
            return s;
        }
        int begin = 0, end = k - 1;
        char[] chars = s.toCharArray();
        while(begin < chars.length) {
            reverse(chars, begin, end);
            begin += k * 2;
            end = begin + k - 1;
        }
        return new String(chars);
    }
    public void reverse(char[] chars, int begin, int end) {
        if(end > chars.length - 1) {
            end = chars.length - 1;
        }
        while(begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }
}
