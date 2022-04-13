public class Main {
    public static void main(String[] args) {

        String[] q = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] a = new Solution().solution(q);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
