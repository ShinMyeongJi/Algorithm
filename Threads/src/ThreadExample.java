/**
 * packageName :  PACKAGE_NAME
 * fileName : ThreadExample
 * author :  home
 * date : 22. 9. 17.
 * description :
 */
public class ThreadExample extends Thread{
    int count = 0;

    public void run() {
        System.out.println("starting");

        try{
            while (count < 5) {
                Thread.sleep(500);
                System.out.println(count);
                count++;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
