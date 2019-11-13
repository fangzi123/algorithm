package geek.linked;

import java.util.Scanner;

/**
 * @author wangff
 * @date 2019/11/12 14:01
 */
public class LRUBaseArray {
    //思路
    /**
     * 用数组实现LRU缓存淘汰算法
     * [1,2,3,4,5]  cap 容量 ; length 当前数组的长度
     * 数组尾部代表最近数据 数组下标0代表最久数据
     * if 元素在数组里
     *      与数组下标最大的元素交换即可
     * else 不在数组里
     *      数组已满：数据循环往前移动1位。最大下标=此元素
     *      未满: 数组的最大下标=此元素
     */
    private int cap;
    private int length;
    private String[] array;

    public LRUBaseArray(int cap) {
        this.cap = cap;
        this.length = 0;
        array=new String[cap];
    }
    public void add(String data){
        //遍历数组 找出元素的索引
        int dataIndex = -1;
        for (int i = 0; i < length; i++) {
            //元素在数组里 与数组下标最大的元素交换即可
            if (data.equals(array[i])) {
                dataIndex = i;
                break;
            }
        }
        //存在此元素，交换
        if (dataIndex != -1) {
            swap(dataIndex, length - 1);
        }else{
            /**            不在数组里
             *      *      数组已满：数据循环往前移动1位。最大下标=此元素
             *      *      未满: length++ 同时 array[length-1]=此元素
             */
            if (array.length == length) {
                move();
                array[length - 1] = data;
            }else{
                array[length++] = data;
            }
        }

    }

    private void move() {
        for (int i = 0; i+1 < array.length; i++) {
            array[i] = array[i + 1];
        }
    }

    private void swap(int dataIndex, int maxIndex) {
        String temp = array[maxIndex];
        array[maxIndex] = array[dataIndex];
        array[dataIndex] = temp;
    }

    public static void main(String[] args) {
        LRUBaseArray lruBaseArray = new LRUBaseArray(5);
        Scanner scanner = new Scanner(System.in);
        while (true){
            lruBaseArray.add(scanner.next());
            lruBaseArray.printAll();
        }
    }

    private  void printAll() {
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }
}
