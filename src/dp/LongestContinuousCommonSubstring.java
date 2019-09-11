package dp;

/**
 * 最长连续公共子串
 * 2维动态规划表
 * @author wangff
 * @date 2019/9/11 11:17
 */
public class LongestContinuousCommonSubstring {

    /**
     * 动归表
     *       a b c d
     *     0 0 0 0 0
     *   b 0 0 1 0 0
     *   c 0 0 0 2 0
     *   d 0 0 0 0 3
     *
     * dp[i][j]代表 s1索引i前字符串与s2索引j前字符串最长连续公共子串的长度
     *  dp[0][j]=dp[i][0]=0
     * 如果s1[i]=s2[j]  那么dp[i][j]=dp[i-1][j-1]+1
     * 如果s1[i]!=s2[j] 那么dp[i][j]=0
     * @return
     */
    public static String lccs(String s1,String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //1.构造dp初始值

        int max = 0;
        int maxI = 0;
        //2.构造dp[i][j]
        for (int i = 0; i <s1.length() ; i++) {
            for (int j = 0; j <s2.length() ; j++) {
                if (s1.charAt(i)==s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = 0;
                }
                //更新dp最大值
                if (max < dp[i + 1][j + 1]) {
                    max = dp[i + 1][j + 1];
                    maxI = i + 1;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
