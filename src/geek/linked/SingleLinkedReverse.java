package geek.linked;

/**
 * @author wangff
 * @date 2019/11/14 16:20
 */
public class SingleLinkedReverse {
    /**
     * 单链表反转 双指针右移
     * 1、定义一个前置节点pre=null
     * 2、定义一个当前节点cur=单链表
     * 3、while遍历当前节点cur，将当前结点的next域指向前一个结点，即cur.setNext(pre)
     * 4、之后pre,cur向后递推移动，直至遍历到最后一个结点为止（cur==null结束）。
     * 此时pre为最后一个节点 即是所求结果
     */

    public Node reverse (Node node){
        Node pre = null;
        Node cur = node;
        while (cur!=null){
            //暂存后节点，以便指针右移
            Node next = cur.getNext();
            //反转
            cur.setNext(pre);
            //指针右移
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        SingleLinkedReverse singleLinkedReverse = new SingleLinkedReverse();
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.setNext(node1);
        Node rlt=singleLinkedReverse.reverse(node);
            singleLinkedReverse.printAll(rlt);
        System.out.println(0000);
    }

    private void printAll(Node node) {
        while (node!=null){
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}
