import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JosemiMoran
 * @version 1.0, 08/04/2021
 */
public class ClassA_Lock {

    protected Lock lock;
    /**
     * ClassA Constructor
     */
    public ClassA_Lock() {
        lock = new ReentrantLock();
    }

    /**
     * Print the thread id and make it wait n seconds.
     *
     * @param id Thread's id
     * @throws InterruptedException
     */
    public void EnterAndWait(int id) throws InterruptedException {
        lock.lock();
        try{
            System.out.println("Starting EnterAndWait in thread " + id);
            TimeUnit.SECONDS.sleep(2);
        }finally {
            System.out.println("Ending EnterAndWait in thread " + id);
            lock.unlock();
        }

    }
}
