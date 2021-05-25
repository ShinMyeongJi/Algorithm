import java.util.*;

public class Main {
    public static void main(String[] args) {
        dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});
    }

    public static String[] dirReduc(String[] arr) {
        Map<String, String> dir = new HashMap<>();
        dir.put("NORTH", "SOUTH");
        dir.put("SOUTH", "NORTH");
        dir.put("WEST", "EAST");
        dir.put("EAST", "WEST");

        List list = new ArrayList<>(Arrays.asList(arr));
        while(true) {
            int len = list.size();
            for (int i = 0; i < list.size() - 1; i++) {
                if (dir.get(list.get(i)) == list.get(i + 1)) {
                    list.remove(i);
                    list.remove(i + 1);
                    break;
                }
            }

            if(len == list.size()) break;
        }
        System.out.println(list);
        // Your code here.
        return (String[]) list.toArray();
    }
}
