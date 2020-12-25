package myleetjava.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    public static void main(String[] args) {
        MyRunable first = new MyRunable("first");
        MyRunable second = new MyRunable("second");
        MyRunable third = new MyRunable("third");

        FooRun fooRun = new FooRun();

//        new Thread(()->{
//            fooRun.first(first);
//        }).start();
//
//        new Thread(()->{
//            fooRun.second(second);
//        }).start();
//
//        new Thread(()->{
//            fooRun.third(third);
//        }).start();

        new Thread(()->{
            try {
                fooRun.firstvol(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooRun.secondvol(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooRun.thirdvol(third);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static class MyRunable implements Runnable{

        private String content;

        public MyRunable(String content) {
            this.content = content;
        }

        @Override
        public void run() {
            System.out.println(content);
        }
    }

    static class FooRun {

        private final AtomicInteger atofirst = new AtomicInteger(0);

        private final Object object = new Object();

        private volatile int vol = 0;

        public FooRun(){}

        public void first(Runnable printFirst){
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            atofirst.incrementAndGet();
            System.out.println(atofirst);
        }

        public void second(Runnable printSecond){
            while(atofirst.get()!=1);
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                atofirst.incrementAndGet();

        }

        public void third(Runnable printThird){
            while(atofirst.get()!=2);
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();

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



//    public void firstvol(Runnable printFirst) throws InterruptedException {
//        synchronized (object){
//            while (vol != 0){
//                object.wait();
//            }
//            printFirst.run();
//            vol++;
//            object.notifyAll(); //执行完全部,释放锁
//        }
//    }
//
//    public void secondvol(Runnable printSecond) throws InterruptedException {
//        synchronized (object){
//            while(vol!=1){
//                object.wait();
//            }
//            printSecond.run();
//            vol++;
//            object.notifyAll(); //执行完全部,释放锁
//        }
//    }
//
//    public void thirdvol(Runnable printThird) throws InterruptedException {
//        synchronized (object){
//            while (vol!=2){
//                object.wait();
//            }
//            printThird.run();
//        }
//    }


}


