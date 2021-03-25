public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.addFirst(40);
        LinkedList.ListIterator iterator = linkedList.Iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());

    }
}
