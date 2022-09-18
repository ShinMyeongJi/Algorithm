/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  home
 * date : 22. 9. 17.
 * description :
 */
public class Main {
    public static void main(String[] args) {
        /*RunnableThread rt = new RunnableThread();
        Thread thread = new Thread(rt);

        thread.start();

        while (rt.count != 5) {
            try{
                Thread.sleep(250);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */
        ThreadExample te = new ThreadExample();
        te.start();

        while (te.count != 5) {
            try{
                Thread.sleep(250);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
