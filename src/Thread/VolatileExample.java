package Thread;

class Counter {
    // 使用volatile关键字确保内存可见性
    private volatile int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterIncrementer extends Thread {
    private Counter counter;

    public CounterIncrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // 创建并启动10个线程来增加计数器
        for (int i = 0; i < 10; i++) {
            new CounterIncrementer(counter).start();
        }

        // 等待所有线程结束
        Thread.sleep(1000); // 注意：这里只是一个简单的等待，并不是一个健壮的线程等待方法

        System.out.println("Final count should be 10,000 but might be less due to visibility issues: " + counter.getCount());
    }
}
