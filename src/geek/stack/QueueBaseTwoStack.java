package geek.stack;

import java.util.Stack;

/**
 * 基于两个栈 实现一个队列
 * @author wangff
 * @date 2019/11/15 17:17
 */
public class QueueBaseTwoStack {
    private Stack<Integer> A;//入队
    private Stack<Integer> B;//出队，当B栈空时，先从A栈全部转移过来，然后对B出栈。B不空时，直接出栈即可

    public QueueBaseTwoStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(Integer data){
        A.push(data);
    }

    public Integer move() {
        if (B.isEmpty()) {
            if (A.isEmpty()) {
                return null;
            }else{
                moveDateFromStackAToStackB();
            }
        }
        return B.pop();
    }

    private void moveDateFromStackAToStackB() {
        while (!A.isEmpty()){
            B.push(A.pop());
        }
    }

    public static void main(String[] args) {
        QueueBaseTwoStack queueBaseTwoStack = new QueueBaseTwoStack();
        queueBaseTwoStack.push(1);
        queueBaseTwoStack.push(2);
        queueBaseTwoStack.move();
        queueBaseTwoStack.move();
        queueBaseTwoStack.move();

    }
}
