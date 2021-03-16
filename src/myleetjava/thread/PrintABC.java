package myleetjava.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    public static void main(String[] args) {
        Print print = new Print();

        new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    print.printA();
                }
            },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                print.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                print.printC();
            }
        },"C").start();
    }
}

class Print{
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private int flag = 1;

    public void printA(){
        lock.lock();
        try {
            while(flag != 1){
                //await
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName()+"===> A ");
            flag =2;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            while(flag != 2 ){
                //await
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName()+"===> B ");
            flag = 3;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            while(flag !=3 ){
                //await
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName()+"===> C ");
            flag = 1;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}