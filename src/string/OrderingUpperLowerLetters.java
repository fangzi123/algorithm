package string;

/**
 * 大小写字母组成的字符串排序
 * 思路：双指针法
 * 两个指针分别指向首位元素
 *      首指针正向遍历，找到第一个大写字母
 *      尾指针逆向遍历，找到第一个小写字母
 *      交换两个指针位置的字符。
 *  然后两个指针沿着相应的方向继续移动，
 *  重复以上步骤，直到首指针大于尾指针
 * @author wangff
 * @date 2019/9/16 9:45
 */
public class OrderingUpperLowerLetters {
    public static void orderingUpperLowerLetters(char[] chars) {
        int left = 0;
        int right = chars.length-1;
        //两个指针沿着相应的方向移动,直到首指针大于或等于尾指针
        while (left<right){
            //首指针正向遍历，遇见小写字母 指针右移 直到找到第一个大写字母停止
            while (chars[left]>='a'&&chars[left]<='z'&&left<right){
                left++;
            }
            //尾指针逆向遍历，遇见大写字母 指针左移 直到找到第一个小写字母停止
            while (chars[right]>='A' && chars[right]<='Z' && left<right){
                right--;
            }
            //交换两个指针位置的字符。
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
    }
    public static void main(String[] args) {
        String str = "abcABCjkl";
        char[] a = str.toCharArray();
        orderingUpperLowerLetters(a);
        System.out.println(new String(a));
    }
}
