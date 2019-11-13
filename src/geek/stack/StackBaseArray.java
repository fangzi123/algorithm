package geek.stack;

import java.util.Scanner;

/**
 * @author wangff
 * @date 2019/11/13 13:58
 * 只操作栈顶元素
 */
public class StackBaseArray {
    private String[] array;//数组
    private int cap;//栈最大容量
    private int count;//栈当前大小

    public StackBaseArray(int cap) {
        this.cap = cap;
        this.count = 0;
        array = new String[cap];
    }

    /**
     * 入栈，
     * 未满则赋给最大下标，count++ 返回true，
     * 栈满返回false
     * @param data
     * @return
     */
    public boolean push(String data) {
        if (count == cap) {
            return false;
        }
        array[count] = data;
        count++;
        return true;
    }

    /**
     * 出栈
     * 栈空，返回null
     * 不空，返回最大下标值，同时count--
     * @return
     */
    public String pop(){
        if (count == 0) {
            return null;
        }
        String data= array[count-1];
        count--;
        return data;
    }

    public static void main(String[] args) {
        StackBaseArray stack = new StackBaseArray(5);
        Scanner scanner = new Scanner(System.in);
        while (true){
            stack.push(scanner.next());
            stack.printAll();
        }
    }

    private  void printAll() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
