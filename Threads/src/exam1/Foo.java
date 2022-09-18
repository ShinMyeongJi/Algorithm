package exam1;

/**
 * packageName :  exam1
 * fileName : Foo
 * author :  home
 * date : 22. 9. 17.
 * description :
 */
public class Foo {
    public synchronized void foo() {
        try{
            System.out.println("starting");
            Thread.sleep(3000);
            System.out.println("closed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
