package geek.sort;

/**
 * O(nlogn) 分治 递归思想
 * 归并排序 稳定
 * 快速排序 不稳定
 * @author wangff
 * @date 2019/11/19 14:29
 */
public class SortMergeAndQuick {
    /**
     * 分治递归调用
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 分区操作：首尾双指针，从右遍历找到小值，然后从左遍历找到大值 交换数据。
     * 最后把基准值与i坐标的值互换 即把基准值放到中间
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 终止条件start>=end
     */
    public void quickSort(int[] a, int start, int end) {
        if (start>=end) {
            return;
        }
        int midIndex = partition(a,start,end);
        quickSort(a, start, midIndex - 1);
        quickSort(a,midIndex+1,end);
    }

    private int partition(int[] a, int start, int end) {
        int tmp = a[start];
        int i = start;
        int j = end;
        while (i<j){
            while (a[j]>tmp&&i<j) {
                j--;
            }
            while (a[i]<tmp&&i<j){
                i++;
            }
            swap(a[j],a[i]);
        }
        swap(a[i], a[start]);
        return i;
    }

    private void swap(int i, int j) {
        int temp = i;
         i = j;
        j = temp;
    }
}
