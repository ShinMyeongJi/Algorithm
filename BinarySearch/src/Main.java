import java.io.*;
/**
 * JONGOL 3517
 */

public class Main
{
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    private int[] arr;
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void run() throws IOException {
        Reader in = new Reader();
        int n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            bw.write(binarySearch(in.nextInt()) + " ");
        }
        bw.flush();
        bw.close();
    }

    private int binarySearch(int iKey) {
        int mid;
        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            mid = (right + left) / 2;

            if (iKey == arr[mid]) {
                return mid;
            }

            if (iKey < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }
}



    /*public static void main(String[] args) throws IOException {
        int N = 0;
        int QN = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] sortedArr = new int[N];
        String[] temp1 = br.readLine().split(" ");
        QN = Integer.parseInt(br.readLine());
        int[] qVals = new int[QN];
        String[] temp2 = br.readLine().split(" ");


        for(int i = 0; i < N; i++) {
            sortedArr[i] = Integer.parseInt(temp1[i]);
        }

        for(int i = 0; i < QN; i++) {
            qVals[i] = Integer.parseInt(temp2[i]);
            sb.append(binarySearch(sortedArr, 0, N - 1, qVals[i])).append(" ");
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        if(low > high) return -1;

        int mid = (low + high) / 2;

        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) return binarySearch(arr, low, mid-1 ,target);
        else return binarySearch(arr, mid + 1, high, target);
    }*/









