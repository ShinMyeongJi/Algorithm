/**
 * 210512
 * CodeWars - Double Cola
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(WhoIsNext(new String[]{ "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" }, 52));
    }

    public static String WhoIsNext(String[] names, int n)
    {
        int len = names.length;
        while(n > len) {
            n = (n - (len - 1)) / 2;
        }

        return names[n - 1];

        /*
        내가 짠 코드
        Queue<String> queue = new LinkedList<>(Arrays.asList(names));

        for(int i = 1; i < n; i++) {
            String name = queue.poll();
            queue.add(name);
            queue.add(name);
        }
        return queue.peek();*/
    }
}
