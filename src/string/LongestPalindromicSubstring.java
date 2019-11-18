package string;

/**
 * 最长回文子串 动态规划法
 * @author wangff
 * @date 2019/9/12 14:55
 */
public class LongestPalindromicSubstring {

    /**
     * 分析 延伸
     * 如果一个字符串是回文串，那么在它左右分别加上一个相同的字符，那么它一定还是一个回文串
     * 如果一个字符串不是回文串，或者在回文串左右分别加不同的字符，得到的一定不是回文串
     * dp[i][j] 表示 s 中从 i 到 j（包括 i 和 j）是否可以形成回文，
     * 状态转移方程只是将上面的描述转化为代码即可：
     *     if(s[i]==s[j]&&dp[i+1][j-1]){
     *         dp[i][j]=true
     *     }
     * @param str
     * @return
     */
    public static String lps(String str){
        //1.初始化dp
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (j -i==0) {
                    dp[i][j] = true;
                }else if (j -i== 1&&str.charAt(i)==str.charAt(j)) {
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        //2.递推获取dp[i][j]
        //倒着遍历简化操作， 这么做的原因是dp[i][..]依赖于dp[i + 1][..]
        String res = str.substring(0,1);
        for (int i = str.length()-1; i >=0 ; i--) {
            for (int j = i; j <str.length() ; j++) {
                if(str.charAt(i)==str.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j] = true;
                }
                // update res
                if (dp[i][j]&&j-i+1>res.length()) {
                    res = str.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lps("abcde"));
    }
}
