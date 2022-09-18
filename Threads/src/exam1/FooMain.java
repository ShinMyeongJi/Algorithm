package exam1;

/**
 * packageName :  exam1
 * fileName : FooMain
 * author :  home
 * date : 22. 9. 17.
 * description :
 */
public class FooMain {
    public static void main(String[] args) {
        Foo obj1 = new Foo();
        Foo obj2 = new Foo();

        Myclass thread1 = new Myclass("1", obj1);
        Myclass thread2 = new Myclass("2", obj1);

        thread1.start();
        thread2.start();
    }
}
