import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String sentence = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sentence = br.readLine();

        int[] alphabet = new int[26];

        for(int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
                System.out.println((int)sentence.charAt(i)-97);
            }else if(sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') {
                System.out.println((int)sentence.charAt(i)-65);
            }
        }
    }
}
