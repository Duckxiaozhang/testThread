package Thread;

public class Demo4 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        System.out.println(Thread.currentThread().getName());
    }
}
class tDemo4 extends Thread {
    public tDemo4() {
        System.out.println("构造方法："+Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("run方法"+Thread.currentThread().getName());
    }
}
