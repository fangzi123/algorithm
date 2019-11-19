package geek.sort;

/**          稳定   最好    最坏     平均
 * 冒泡排序，  Y     n      n^2         n^2
 * 插入排序，  Y     n      n^2         n^2
 * 选择排序    N     n^2     n^2         n^2
 * @author wangff
 * @date 2019/11/19 11:23
 */
public class Sort {
    /**
     * 原理：N趟  每一趟 两两比较交换，直到最大值换到最后位置
     *  第一趟  两两比较交换，直到最大值换到最后位置  比较n-1次
     *  第二趟  两两比较交换，直到最大值换到最后位置   比较n-2次
     *  第N趟  两两比较交换，直到最大值换到最后位置
     * @param a 数组 升序排序
     * @param n 数组长度
     */
    public void bubbleSort(int[] a,int n){
        if (n<=1) {
            return;
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j< n-1-i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序思路：
     *它的工作原理是通过构建有序序列，
     * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，
     * 在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param a
     * @param n
     */
    public void insertSort(int[] a,int n) {
        if (n <=1) {
            return;
        }
        for (int i = 1; i <n ; i++) {
            int temp = a[i];
            int j = i - 1;
            for (; j>=0; j--) {
                if (a[j]>temp) {
                    a[j + 1] = a[j];
                }else{
                    break;
                }
            }
            a[j + 1] = temp;
        }

    }
}
