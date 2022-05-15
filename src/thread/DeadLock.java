package thread;

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String A,String B){
        this.lockA = A;
        this.lockB = B;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println("锁定"+ Thread.currentThread().getName());
            synchronized (lockB){
                System.out.println("锁定"+ Thread.currentThread().getName());
            }
        }
    }
}
public class DeadLock{
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"ThreadA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadB").start();
    }
}