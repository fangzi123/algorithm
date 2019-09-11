package string;

/**
 * @author wangff
 * @date 2019/9/11 16:01
 */
public class StringReverse {
    /**
     * 实现字符串按 索引范围反转
     * @param string
     * @param start
     * @param end
     * @return
     */
    public static String reverse(String string,int start,int end) {
        char[] chars = string.toCharArray();
        while (start<end){
//            chars[start] = (char) (chars[start]^chars[end]);
//            chars[end] = (char) (chars[start]^chars[end]);
//            chars[start] = (char) (chars[start]^chars[end]);
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    /**
     * 反转单词
     * 例如 "how are you" 变 "you are how"
     * 思路：两次反转
     * 第一次对整个字符串反转 变为 "uoy era woh"
     * 第二次逐个对单词反转   变为 "you are how"
     * @param words
     * @return
     */
    public static String reverseWords(String words) {
        //第一次对整个字符串反转 变为 "uoy era woh"
        words=reverse(words, 0, words.length() - 1);

        //第二次逐个对单词反转 遇空格时反转单词 同时指针加1
        int start = 0;
        for (int i = 0; i <words.length() ; i++) {
            if (words.charAt(i) == ' ') {
                words= reverse(words,start,i-1);
                start = i +1;
            }
        }
        //最后一个单词的反转
        words= reverse(words,start,words.length()-1);
        return words;
    }


    public static void main(String[] args) {
        String str="how are you";
        String rlt=reverse(str,0,str.length()-1);
        String reverseWords=reverseWords(str);
        System.out.println("rlt="+rlt);
        System.out.println("reverseWords="+reverseWords);
    }
}
