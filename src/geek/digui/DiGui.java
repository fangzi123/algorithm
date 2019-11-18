package geek.digui;

/**
 * **********递归都可以转化为for循环高效算法***********
 * 缺点：堆栈溢出，重复计算，时间空间复杂度高
 * 优点：代码简洁
 * 1.终止条件
 * 2.写出递推公式  逆向
 * 3.转化为递归代码
 * @author wangff
 * @date 2019/11/18 11:38
 */
public class DiGui {
    /**
     * 走台阶问题就是斐波那契额数列问题
     * 电影第几排问题
     * 阶乘问题等等
     */

    /**
     * 走台阶问题 递归
     * f(1)=1
     * f(2)=2
     * f(n)=+
     * @param n
     */
    public int taijie(int n){
        if (n == 1) {
            return 1;
        }
        if (n ==2) {
            return 2;
        }
        return taijie(n - 1) + taijie(n - 2);
    }


    public int taijie1(int n){
        if (n == 1) {
            return 1;
        }
        if (n ==2) {
            return 2;
        }
        int prepre = 1;
        int pre = 2;
        int ret=0;
        for (int i = 3; i <=n ; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }


    public static void main(String[] args) {
        DiGui diGui = new DiGui();
        //int ret= diGui.taijie(100);
        int ret1= diGui.taijie1(30);
        //System.out.println(ret);
        System.out.println(ret1);
    }
}
