import java.util.Dictionary;

/**
 * @author JosemiMoran
 * @version 1.0, 08/04/21
 */
public class ClassB implements Runnable {

    protected ClassA classA;
    protected ClassA_Lock classA_lock;
    protected int id;
    protected int counter;

    /**
     * ClassB constructor
     *
     * @param id     Thread's id
     * @param classA ClassA Object
     */
    public ClassB(ClassA classA, int id) {
        this.classA = classA;
        this.id = id;
        counter = 0;
    }

    /**
     * ClassB constructor
     *
     * @param id          Thread's id
     * @param classA_lock ClassA Object using lock
     */
    public ClassB(ClassA_Lock classA_lock, int id) {
        this.classA_lock = classA_lock;
        this.id = id;
    }


    //Default ClassB constructor
    public ClassB() {
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        System.out.println("Starting run " + id);
        try {
            while (classA.EnterAndDecrement()) {
                counter++;
            }
        } catch (Exception e) {
            System.out.println("Error on run!");
        } finally {
            System.out.println("Thread: " + id + " Counter Value: " + counter);
            MyProblem.statistic.put(id, counter);
            System.out.println("Ending run " + id);
        }
    }
}
