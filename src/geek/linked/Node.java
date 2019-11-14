package geek.linked;

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