public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString(){
            return String.valueOf(this.data);
        }
    }

    //Head 앞에 추가
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next == null) tail = newNode;
    }

    //Tail 뒤에 추가
    public void addEnd(Object data) {
        Node newNode = new Node(data);
        if(size == 0) addFirst(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //중간에 추가
    public void add(Object data, int index) {
        if(size == 0) addFirst(data);

        Node tempPre = findNode(index-1);
        Node newNode = new Node(data);
        Node tempNext = findNode(index);

        newNode.next = tempNext;
        tempPre.next = newNode;
        size++;

        if(newNode.next == null) tail = newNode;
    }

    //node 찾기
    public Node findNode(int index) {
        Node x = head;
        for(int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public String toString() {
        if(head == null) return "[]";

        Node temp = head;
        StringBuilder sb = new StringBuilder("[");
        while(temp.next != null) {
            sb.append(temp.data + ", ");
            temp = temp.next;
        }
        sb.append(temp.data + "]");

        return sb.toString();
    }

    //head 삭제
    public void removeFirst() {
        Node temp = head;
        head = temp.next;
        temp = null;
        size--;
    }

    public void remove(int index) {
        if(index == 0) removeFirst();
        Node tempCur = findNode(index);
        Node tempPre = findNode(index-1);
        tempPre.next = tempCur.next;
        if(tempCur == tail) tail = tempPre;
        tempCur = null;
        size--;
    }

    public int size() {
        return size;
    }

    public Object get(int index){
        Node node = findNode(index);
        return node.data;
    }

    public int indexOf(Object data) {
        Node temp = head;
        int cnt = 0;
        while(true) {
            if(temp.data == data) return cnt;
            temp = temp.next;
            if(temp == null) return -1;
            cnt++;
        }
    }


    public ListIterator Iterator() {
        return new ListIterator();
    }

    public class ListIterator{
        private Node temp;
        private Node lastRetruned;
        private int returnCount;

        public ListIterator() {
            this.temp = head;
            this.returnCount = 0;
        }

        public Object next(){
            lastRetruned = temp;
            temp = temp.next;
            returnCount++;
            return lastRetruned.data;
        }
    }
}
