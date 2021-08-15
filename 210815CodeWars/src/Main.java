import java.util.Arrays;

/**
 * 210815 CodeWars-Convert string to camel case
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior"));
    }

    public static String toCamelCase(String s){
        String[] words = s.contains("-") ? s.split("-") : s.split("_");

        for(int i = 1; i < words.length; i++) {
            if(Character.isLowerCase(words[i].charAt(0))) {
                char first = Character.toUpperCase(words[i].charAt(0));
                words[i] = first + words[i].substring(1);
            }
        }
        return String.join("" , words);
    }
}
