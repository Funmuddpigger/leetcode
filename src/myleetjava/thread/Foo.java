package myleetjava.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {

    private final AtomicInteger atofirst = new AtomicInteger(0);

    private final Object object = new Object();

    private volatile int vol = 0;


    public static void main(String[] args) {

    }
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atofirst.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(atofirst.get()!=1){
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            atofirst.incrementAndGet();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(atofirst.get()!=2){
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    public void firstvol(Runnable printFirst) throws InterruptedException {
        synchronized (object){
            while (vol != 0){
                object.wait();
            }
            printFirst.run();
            vol++;
            object.notifyAll(); //执行完全部,释放锁
        }
    }

    public void secondvol(Runnable printSecond) throws InterruptedException {
        synchronized (object){
            while(vol!=1){
                object.wait();
            }
            printSecond.run();
            vol++;
            object.notifyAll(); //执行完全部,释放锁
        }
    }

    public void thirdvol(Runnable printThird) throws InterruptedException {
        synchronized (object){
            while (vol!=2){
                object.wait();
            }
            printThird.run();
        }
    }


}


