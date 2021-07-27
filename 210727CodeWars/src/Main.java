import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static int solution(int number) {
        List<Integer> multiples = new ArrayList<>();

        for (int i = 1; 3*i < number; i++) {
            multiples.add(3*i);
        }

        for (int i = 1; 5*i < number; i++) {
            multiples.add(5*i);
        }

        return multiples.stream()
                .distinct()
                .mapToInt(i -> i).sum();


        /**
         * return IntStream.range(0, number)
     *                     .filter(n -> (n % 3 == 0) || (n % 5 == 0))
     *                     .sum();
         */
    }
}
