public class Main {
    public static void main(String[] args) {
        System.out.println(thirt(1234567));
    }

    public static long thirt(long n) {

        long[] reminders = {1, 10, 9, 12, 3, 4};


        String ns;

        long sum = 0;
        long lastVal = -1;
        while(sum != lastVal) {

            lastVal = sum;
            sum = 0;
            ns = String.valueOf(n);

            for (int i = ns.length() - 1; i >= 0; i--) {
                sum += Long.parseLong(String.valueOf(ns.charAt(i))) * reminders[(ns.length() - 1 - i) % 6];
            }
            n = sum;
        }

        return lastVal;
    }
}
