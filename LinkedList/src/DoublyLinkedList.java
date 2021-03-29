public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    class Node{
        private Object data;
        private Node next;
        private Node previous;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public void addFirst(Object data) {
            Node newNode = new Node(data);

            newNode.next = head;

            if(head != null)
               head.previous = newNode;

            head = newNode;
            size++;

            if(head.next == null)
                tail = head;
        }

        public void addEnd(Object data){
            Node newNode = new Node(data);

            if(size == 0) {
                addFirst(data);
            }else {

                newNode.previous = tail;

                tail.next = newNode;

                tail = newNode;

                size++;

            }
        }

        public void add(Object data, int index) {
            Node newNode = new Node(data);
            Node newNodeNext = findNode(index);
            Node newNodePrev = newNodeNext.previous;
            newNode.next = newNodeNext;
            newNode.previous = newNodePrev;

            newNodePrev.next = newNode;
            newNodeNext.previous = newNode;

            // 하다 말았음


        }

        public Node findNode(int index) {
            if(size / 2 > index) {
                Node x = head;
                for(int i = 0; i < index; i++) {
                    x = x.next;
                }
                return x;
            }else{
                Node x = tail;
                for(int i = size-1; i > index; i--) {
                    x = x.previous;
                }
                return x;
            }
        }

    }
}
