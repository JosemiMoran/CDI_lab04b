import java.util.concurrent.TimeUnit;

/**
 * @author JosemiMoran
 * @version 1.0, 08/04/2021
 */
public class ClassA {

    protected int counter;

    /**
     * ClassA Constructor
     */
    public ClassA() {
        counter = 10;
    }

    /**
     * Print the thread id and make it wait n seconds.
     *
     * @param id Thread's id
     */
    public synchronized void EnterAndWait(int id) throws InterruptedException {
        System.out.println("Starting EnterAndWait in thread " + id);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Ending EnterAndWait in thread " + id);
    }

    /**
     * Decrements counter.
     *
     * @return false if counter is 0 else true
     */
    public synchronized boolean EnterAndDecrement() {
        boolean bool;
        if (counter > 0) counter--;
        else return false;
        return true;
    }
}
