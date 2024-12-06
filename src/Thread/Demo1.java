package Thread;

public class Demo1 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();//启动线程
        System.out.println("运行了main方法");
    }
}

class testDemo2 implements Runnable {
    public void run() {
        Thread t2 = new Thread();
        t2.start();
        System.out.println();
    }
}