import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Integer> lsit = new ArrayList<>();
        System.out.println("최소 힙");

        queue.add(1);
        queue.add(8);
        queue.add(5);
        queue.add(2);
        queue.add(3);

        while(!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
