package string;

import java.util.Arrays;

/**
 * 换位字符串 是指组成字符相同，但位置不同 例如：aaaabc 与 abcaaa
 *
 * @author wangff
 * @date 2019/9/12 9:59
 */
public class TranspositionString {
    /**
     * 分析
     * 假设字符组成只使用ASCII字符 由于只有256个（编码0~255）
     * 实现时 可以申请大小为256的数组来记录各个字符出现的次数。初始化为0.
     * 遍历s1,将字符对应的ASCII码值作为下标，并且把值+1
     * 然后遍历s2 将字符对应的ASCII码值作为下标，并且把值-1
     * 如果最后数组的元素全部为0，则为换位字符串
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isTranspositionString(String s1,String s2) {
        int[] a = new int[256];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }

        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            a[s2.charAt(i)]--;
        }
        for (int i : a) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("换位字符串:"+isTranspositionString("abcaa", "aaabc"));
    }
}
