public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.addFirst(40);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.indexOf(20));

    }
}
