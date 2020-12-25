package myleetjava.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintRunable{

    private static Object lock = new Object();

    private static int count = 0;

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(new PrintRunableRun()).start();
        }
    }

    static class PrintRunableRun  implements Runnable{

        @Override
        public void run(){
            System.out.println("hello");

            synchronized (lock){
                count++;
                //System.out.println(count);
                while (count<5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                lock.notifyAll();
            }

            System.out.println("world");
        }
    }
}
