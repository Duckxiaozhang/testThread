package Thread;

public class Demo7 {
    public static void main(String[] args) {
        Demo7Service service = new Demo7Service();
        Thread t1 = new TDemo7(service);
        t1.start();
        Thread t2 = new TDemo8(service);
        t2.start();
    }
}
class Demo7Service{
    public void add(String usename) {
        int num = 0;
        if ("a".equals(usename)) {
            num = 100;
            System.out.println("a set over");
            //等待另外一个线程修改num的值
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            num = 200;
            System.out.println();
        }
        System.out.println("usename=" + usename + " num=" + num);
    }
}
class TDemo7 extends Thread{
    private Demo7Service service;
    public TDemo7(Demo7Service service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.add("a");
    }
}
class TDemo8 extends Thread{
    private Demo7Service service;
    public TDemo8(Demo7Service service) {
        this.service = service;

    }
    @Override
    public void run() {
        service.add("b");
    }
}
