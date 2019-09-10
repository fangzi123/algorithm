/**
 * @author wangff
 * @date 2019/9/10 10:08
 */
public class DP {
    /**
     * f(0)=0
     * f(1)=1
     * f(n)=f(n-1)+f(n-2）
     * @param n
     */
    public static long  feibonaqie1(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return feibonaqie1(n - 1) + feibonaqie1(n - 2);
    }
    public static long  feibonaqie(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //一维数组动态规划表
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(feibonaqie(100));
//        System.out.println(feibonaqie1(45));
        System.out.println((System.currentTimeMillis()-start)+"ms");
    }
}
