package Thread;

public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        t1.start();
        Thread.sleep(1000);
        t1.stop();
    }
}
class tDemo extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("time=" + System.currentTimeMillis());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}