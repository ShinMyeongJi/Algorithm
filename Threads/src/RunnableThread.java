/**
 * packageName :  PACKAGE_NAME
 * fileName : Thread
 * author :  home
 * date : 22. 9. 17.
 * description :
 */
public class RunnableThread implements Runnable{

    public int count;

    @Override
    public void run() {
        System.out.println("starting");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = i;
            System.out.println(i);
        }
        System.out.println("closed");
    }
}
