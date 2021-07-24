import java.util.HashMap;
import java.util.Map;

/**
 * 210721 CodeWars - Address Book by State
 */
public class Main {
    public static void main(String[] args) {

        String ad0="John Daggett, 341 King Road, Plymouth MA\n" +
                "Alice Ford, 22 East Broadway, Richmond VA\n" +
                "Orville Thomas, 11345 Oak Bridge Road, Tulsa OK\n" +
                "Terry Kalkas, 402 Lans Road, Beaver Falls PA\n" +
                "Eric Adams, 20 Post Road, Sudbury MA\n" +
                "Hubert Sims, 328A Brook Road, Roanoke VA\n" +
                "Amy Wilde, 334 Bayshore Pkwy, Mountain View CA\n" +
                "Sal Carpenter, 73 6th Street, Boston MA";

        System.out.println(byState(ad0));
    }

    public static String byState(String str) {
        // your code

        Map<String, String> loc = new HashMap(){{
           put("AZ", "Arizona");
           put("CA", "California");
           put("ID", "Idaho");
           put("IN", "Indiana");
           put("MA", "Massachusetts");
           put("OK", "Oklahoma");
           put("PA", "Pennsylvania");
           put("VA", "Virginia");
        }};



        String[] items = str.split("\n");




        return "";
    }
}

/**
 'AZ': 'Arizona',
 'CA': 'California',
 'ID': 'Idaho',
 'IN': 'Indiana',
 'MA': 'Massachusetts',
 'OK': 'Oklahoma',
 'PA': 'Pennsylvania',
 'VA': 'Virginia'
 */