package geek.queue;

/**
 * @author wangff
 * @date 2019/11/18 16:22
 */
public class QueueBaseArray {
    /**
     * 思路一 数组搬移
     * 1个String数组array+容量cap 借助两个int指针head tail
     *
     * 入队操作
     * 队列已满：head==0&&tail==cap 抛出异常
     * 队列不满：
     *  当tail<cap时,给数组最大下标tail赋值 同时tail++,
     *  当tail=cap&&head>0时
     *      【需要顺移数据至左端 同时head=0,tail=tail-head】
     *      然后给数组最大下标tail赋值 同时tail++
     *
     * 出队操作  【判断为空条件 head==tail】
     *      如果队列为空 抛出异常
     *      不空则返回head处的值，然后head++
     */
    private String[] array;
    private int cap;
    private int head = 0;
    private int tail = 0;

    QueueBaseArray(int cap){
        array = new String[cap];
        this.cap = cap;
    }
    //入队方法

    /**
     * 入队操作
     * 队列已满：head==0&&tail==cap 抛出异常
     * 队列不满：
     *  当tail<cap时,给数组最大下标tail赋值 同时tail++,
     *  当tail==cap&&head>0时
     *      【需要顺移数据至左端 同时更新head=0,tail=tail-head】
     *      然后给数组最大下标tail赋值 同时tail++
     * @param data
     * @return
     */
    public boolean push(String data) throws Exception {
        if (head == 0&&tail==cap) {
            throw new Exception("队列已满");
        }else{
            if (tail<cap) {
                //直接插入
                array[tail] = data;
                tail++;
            } else if (tail==cap&&head>0) {
                //先搬移
                move();
                //后插入
                array[tail] = data;
                tail++;
            }
        }

        return true;
    }

    private void move() {
        for (int i = head; i <tail ; i++) {
            array[i-head]=array[i];
        }
        head = 0;
        tail = tail - head;
    }

    /**
     * 注意此时tail处无数据
     * 出队操作  【判断为空条件 head==tail】
     * 如果队列为空 抛出异常
     * 不空则返回head处的值，然后head++
     */
    public String deQueue() throws Exception {
        if (head == tail) {
            throw new Exception("队列已空！");
        }else{
            String ret = array[head];
            array[head] = null;
            head++;
            return ret;
        }
    }

    public static void main(String[] args) throws Exception {
        QueueBaseArray queueBaseArray = new QueueBaseArray(5);
        queueBaseArray.push("1");
        queueBaseArray.push("2");
        queueBaseArray.push("3");
        queueBaseArray.push("4");
        queueBaseArray.push("5");
        queueBaseArray.deQueue();
        queueBaseArray.printAll();
    }

    private void printAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i < tail; i++) {
            sb.append(array[i]).append(",");
        }
        System.out.println(sb.toString());
    }
}
