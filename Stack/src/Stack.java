import java.util.EmptyStackException;

public class Stack {
    private Node top;
    private int count = 0;

    public Stack() {
        this.top = null;
    }

    class Node{
        private Object data;
        private Node nextNode;

        public Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }

    public void push(Object data) {
        Node newNode = new Node(data);
        newNode.nextNode = top;
        top = newNode;
        count++;
    }

    public Object pop() {
        Object data = peek();
        if(top != null) {
            top = top.nextNode;
            count--;
            return data;
        }
        return "empty";
    }

    public Object peek() {
        if(top == null)
           return null;
        return top.data;
    }

    public boolean isEmpty() {
        if(top == null) return true;
        return false;
    }

    public int size() {
        return count;
    }
}