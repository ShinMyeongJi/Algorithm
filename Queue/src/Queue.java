public class Queue implements QueueIF{

    private Node head;
   // private Node front;
    private Node rear;
    private int size = 0;

    class Node{
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        this.head = null;
       // this.front = null;
        this.rear = null;
    }

    @Override
    public void enqueue(Object data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            this.head = newNode;
            this.rear = newNode;
        }else{
            Node temp = rear;
            this.rear = newNode;
            temp.next = rear;
        }
        size++;
    }

    @Override
    public void dequeue() {

        Node next = this.head.next;
        Node temp = this.head;

        this.head = next;
        temp = null;

    }

    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }


    @Override
    public Object peek() {
        return null;
    }

    //TO-DO. poll method 구

    @Override
    public void clear() {

    }

    public void print() {
        Node x = this.head;
        for(int i = 0; i < size; i++) {
            System.out.println(x.data);
            x = x.next;
        }
    }
}
