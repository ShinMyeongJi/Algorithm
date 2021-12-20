import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(arrange("after be arrived two My so"));
    }

    public static String arrange(String strng) {
        StringBuffer sb = new StringBuffer();
        List<String> strs = Arrays.asList(strng.split(" "));

        for(int i = 0; i < strs.size()-1; i++) {
            if(i % 2 == 0) {
                if(strs.get(i).length() > strs.get(i+1).length()) {
                    Collections.swap(strs, i, i + 1);
                }
            }else{
                if(strs.get(i).length() < strs.get(i + 1).length()) {
                    Collections.swap(strs, i, i + 1);
                }
            }
        }

        for (int i = 0; i < strs.size(); i++) {
            if(i % 2 == 0)
                strs.set(i, strs.get(i).toLowerCase());
            else
                strs.set(i, strs.get(i).toUpperCase());
        }


        return strs.stream().collect(Collectors.joining(" "));
    }
}
