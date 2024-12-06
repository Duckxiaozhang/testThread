package Thread;

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        t1.start();
        Thread.sleep(2000);
        t1.stop();
    }
}
class tDemo5 extends Thread {
    private boolean flag = true;

    @Override
    public void run() {
        try {
            while (flag) {
                System.out.println("time=" + System.currentTimeMillis());
                Thread.sleep(2000);
            }
            System.out.println("线程执行结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
    public void stopThread() {
        flag = false;
    }
}