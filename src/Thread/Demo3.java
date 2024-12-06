package Thread;

public class Demo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        t1.start();
        t2.start();
        t3.start();

    }
}
class Thread1 extends Thread {
    private int count=5;
    @Override
    public void run() {
        while (count>0) {
            count--;
            System.out.println(Thread.currentThread().getName()+":count"+count);
        }
    }
}