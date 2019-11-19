package leetcode;

/**
 * @author wangff
 * @date 2019/11/19 16:34
 */
public class FindByErFen {
    /**
     * 思路：有序数组二分查找
     * 双指针法 head tail
     * 求出中间坐标 midIndex=(head+tail)/2
     * 然后比较目标值与中间坐标的值
     * 如果目标值大 则 head=midIndex+1
     * 如果目标值小 则  tail=midIndex-1
     * 相等则返回midIndex
     */
    public int find(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            if (target == a[midIndex]) {
                return midIndex;
            } else if (target > a[midIndex]) {
                left = midIndex + 1;
            } else if (target < a[midIndex]) {
                right = midIndex - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        FindByErFen findByErFen = new FindByErFen();
        int ret=findByErFen.find(a, 2);
        System.out.println(ret);
    }
}
