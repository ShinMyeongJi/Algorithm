import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * BOJ 11650
 */
public class Main {
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();

        Point[] locations = new Point[N];


        for(int i = 0; i < N; i++) {
            locations[i] = new Point(kb.nextInt(), kb.nextInt());
        }

        Arrays.sort(locations, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.getX() != o2.getX()) {
                    return o1.getX() - o2.getX();
                }else {
                    return o1.getY() - o2.getY();
                }
            }
        });

        for(int i = 0; i < N; i++) {
            System.out.println(locations[i].getX() + " " + locations[i].getY());
        }


    }
}


class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}