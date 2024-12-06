package Thread;

public class Demo2 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        System.out.println("运行了main方法");
    }

    class tDemo implements Runnable {
        @Override
        public void run() {
            System.out.println("运行了润run方法");
        }
    }
}

