import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(whoLikesIt("Max", "John"));
    }

    public static String whoLikesIt(String... names) {
        if(names.length == 0) return "no one likes this";
        else if(names.length == 1) return names[0] + " likes this";
        else if(names.length == 2) {
            return Arrays.stream(names)
                    .collect(Collectors.joining(" and ")) + " like this";
        }else if(names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        }else return names[0] + ", " + names[1] + " and " + (names.length-2) + " others like this";

    }
    //훨씬 깔끔해보인다..
    /**
     * switch (names.length) {
*           case 0: return "no one likes this";
*           case 1: return String.format("%s likes this", names[0]);
*           case 2: return String.format("%s and %s like this", names[0], names[1]);
*           case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
*           default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
*         }
     */
}
