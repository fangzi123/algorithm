package dp;

/**
 * 爬楼梯问题 生兔子问题
 * @author wangff
 * @date 2019/9/10 10:08
 */
public class Feibonaqie {
    /**
     * 解法1 递归 低效
     */
    public static long  feibonaqie(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return feibonaqie(n - 1) + feibonaqie(n - 2);
    }

    /**
     * 解法2 动态规划 高效 空间复杂度o(n)
     * f(0)=0
     * f(1)=1
     * f(n)=f(n-1)+f(n-2）
     * @param n
     * @param n
     * @return
     */
    public static long  feibonaqie1(int n){
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

    /**
     * 解法2 动态规划 高效 空间复杂度o(1)
     * @param n
     * @return
     */
    public static long  feibonaqie2(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        for (int i = 2; i <= n; i++) {
            f2 = f1 + f0;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(feibonaqie(100));
//        System.out.println(feibonaqie1(45));
        System.out.println((System.currentTimeMillis()-start)+"ms");
    }
}
