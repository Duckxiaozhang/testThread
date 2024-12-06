package Thread;

class SharedObject {
    private int value;
    public synchronized void setValue(int value) {
        try {
            // 模拟写入操作的延迟
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }
}

class WriterThread extends Thread {
    private SharedObject sharedObject;
    private int newValue;

    public WriterThread(SharedObject sharedObject, int newValue) {
        this.sharedObject = sharedObject;
        this.newValue = newValue;
    }

    @Override
    public void run() {
        sharedObject.setValue(newValue);
    }
}

class ReaderThread extends Thread {
    private SharedObject sharedObject;

    public ReaderThread(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        System.out.println("ReaderThread reads value: " + sharedObject.getValue());
    }
}

public class DirtyReadExample {
    public static void main(String[] args) throws InterruptedException {
        SharedObject sharedObject = new SharedObject();

        // 启动writer线程
        Thread writerThread = new WriterThread(sharedObject, 42);
        writerThread.start();

        // 启动reader线程
        Thread readerThread = new ReaderThread(sharedObject);
        readerThread.start();

        // 等待线程结束
        writerThread.join();
        readerThread.join();
    }
}
