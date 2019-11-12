package geek;

import java.util.Scanner;

/**
 * @author wangff
 * @date 2019/11/11 10:40
 *
 *      * 用单链表实现LRU缓存淘汰算法
 *      * 思路：单链表，链头代表最近访问，链尾代表最久访问
 *      借助哨兵 头结点，无data
 *      node  : head node1 node2 node3 node4 ...
 *      length:  0     1     2     3     4   ...
 *          1.key在链表里(元素有前置节点)
 *              删除所在位置的元素，把key插入到链表头部
 *          2.key不在链表里
 *              2.1链表已满
 *                  删除链尾元素，插入元素到链表头部
 *              2.2链表未满
 *                  插入元素到链表头部
 */
public class LRUBaseLinkedList<T> {
    private int cap;
    private int length;
    private Node head;//借助哨兵 头结点，无data，仅有next指针

    public LRUBaseLinkedList(int cap) {
        this.cap = cap;
        this.length = 0;
        head = new Node();
    }

    /**
     *      * 思路：单链表，链头代表最近访问，链尾代表最久访问
     *      借助哨兵 头结点，无data
     *      node  : head        node1 node2 node3 node4 ...
     *      length:  0           1     2     3     4   ...
     *          if  1.key在链表里 (等价于元素有前置节点)
     *              删除当前元素(即前置节点的下一节点)，插入元素到链表头部
     *          else 2.key不在链表里
     *              2.1链表已满
     *                  删除链尾元素，插入元素到链表头部
     *              2.2链表未满
     *                  插入元素到链表头部
     */
    public void add(T key){
        //查找元素前置节点,如果不存在返回null
        Node preNode = findPreNode(key);
        //元素在链表里
        if (preNode != null) {
            //删除前置节点的下一个节点
            removeCurrentNode(preNode);
            //插入元素到链表头部
            insertNodeAtBegin(key);
        }else{ //元素不在链表里
            if (length >=cap) {
                //删除链尾元素
                removeTailNode();
                //插入元素到链表头部
                insertNodeAtBegin(key);
            }else{
                //插入元素到链表头部
                insertNodeAtBegin(key);
            }
        }
    }

    private void removeTailNode() {
        Node temp = head;
        // 空链表直接返回
        if (temp.getNext() == null) {
            return;
        }
        //找出倒数第二个节点temp
        while (temp.getNext().getNext()!=null){
            temp = temp.getNext();
        }
        //删除末尾节点
        temp.setNext(null);
        length--;
    }

    private void insertNodeAtBegin(T key) {
        Node newNode = new Node(key);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        length++;
    }

    private void removeCurrentNode(Node preNode) {
        Node currentNode = preNode.getNext();
        preNode.setNext(currentNode.getNext());
        currentNode = null;
        length--;
    }

    private Node findPreNode(T key) {
        Node temp = head;
        while (temp.getNext()!=null){
            if (key.equals(temp.getNext().getData())) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }


    //获取链表长度
    public int getLength() {
        return this.length;
    }

    class Node<T>{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
        public Node() {
        }
        public Object getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.next());
            list.printAll();
        }
    }

    private void printAll() {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getData() + ",");
            node = node.getNext();
        }
        System.out.println();
    }
}
