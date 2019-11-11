package geek;

/**
 * @author wangff
 * @date 2019/11/11 10:40
 *
 *      * 用单链表实现LRU缓存淘汰算法
 *      * 思路：单链表，链头代表最近访问，链尾代表最久访问
 *        0.链表为空时，直接创建链表，并添加此元素
 *        否则遍历链表
 *          1.key在链表里
 *              删除所在位置的元素，把key插入到链表头部
 *          2.key不在链表里
 *              2.1链表已满
 *                  删除链尾元素，插入元素到链表头部
 *              2.2链表未满
 *                  插入元素到链表头部
 */
public class LinkedLRU {
    private int cap;
    private Node head;
    public LinkedLRU(int cap) {
        this.cap = cap;
    }

    public void put(String key){
        Node node = new Node(key);
        Node temp = head;
        if (temp == null) {//空结点，直接插入
            head = node;
        }else {
            boolean flag = false;
            //遍历链表 检查key是否在链表里,并找到此节点
            while (temp!=null){
                if(!temp.getData().equals(key)){
                    temp = temp.getNext();
                }else{
                    flag = true;
                    break;
                }
            }
            //1.key在链表里
            if (flag) {
                // todo 删除所在位置的元素, 把key插入到链表头部
                node.setNext(head);
            }else{
                // 2.key不在链表里  2.2链表未满
                if (this.getLength()== cap) {
                    //2.1链表已满  todo 删除链尾元素，插入元素到链表头部
                    node.setNext(head);
                }else{
                    //  2.2链表未满 插入元素到链表头部
                    node.setNext(head);
                }
            }

        }
    }
    //获取链表长度
    public int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
    class Node{
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
