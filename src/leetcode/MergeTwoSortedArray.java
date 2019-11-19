package leetcode;

/**
 * 合并两个已排序的数组
 *
 * @author wangff
 * @date 2019/11/19 15:17
 */
public class MergeTwoSortedArray {
    /**
     * 合并连个有序数组
     * 算法：
     * 1. 设置两个指针i,j，分别指向a数组和b数组，一个执行合并后数组的指针index;
     * 2. 比较指针i,j指向的值，小的值存入指针index指向的结果数组中，当有一个指针（i或j）先到达数组末尾时，比较结束；
     * 3. 将指针（i或j）没有到达数组末尾的数组复制到指针index指向的结果数组中
     *
     * @param a
     * @param b
     * @return
     */
    public int[] merge(int[] a, int[] b) {
        int[] ret = new int[a.length + b.length];
        int i = 0, j = 0;
        int index = 0;
        while (i < a.length && j < b.length) {
            ret[index++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        //如果a剩余，拷贝剩余的值结果数组
        if (i < a.length) {
            for (int k = i; k < a.length; k++) {
                ret[index++] = a[k];
            }
        }
        //如果b剩余，拷贝剩余的值结果数组
        if (j < b.length) {
            for (int k = j; k < b.length; k++) {
                ret[index++] = b[k];
            }
        }
        return ret;
    }
}
