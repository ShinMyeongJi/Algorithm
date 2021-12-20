public class Main {
    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));
    }

    public static String pigIt(String str) {
        String ay = "ay";
        StringBuilder sb;
        String[] arr = str.split(" ");

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].matches("^[a-zA-Z]*$")){
                char s = arr[i].charAt(0);
                sb = new StringBuilder(arr[i].substring(1));
                arr[i] = sb.append(s).append(ay).toString();
            }
        }

        return String.join(" ", arr);
    }
}
