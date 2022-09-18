package exam1;

/**
 * packageName :  exam1
 * fileName : Myclass
 * author :  home
 * date : 22. 9. 17.
 * description :
 */
public class Myclass extends Thread{

    private String name;
    private Foo mc;

    public Myclass(String  ame, Foo mc) {
        this.name = name;
        this.mc = mc;
    }

    @Override
    public void run() {
        mc.foo();
    }
}
