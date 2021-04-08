import java.util.*;

/**
 * @author JosemiMoran
 * @version 1.0, 08/04/21
 */
public class MyProblem {
    public static Map<Integer, Integer> statistic;
    public static void main(String[] args) {
        System.out.println("Starting main...");
        int numThreads = Integer.parseInt(args[0]); //Number of threads of the program
        ArrayList<Thread> threadArrayList = new ArrayList<>(numThreads);
        ClassA classA = new ClassA(); //ClassA object
        ClassA_Lock classA_lock = new ClassA_Lock();//ClassA object using lock
        statistic = new HashMap<>();
        //Creating threads
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new ClassB(classA, i), "Thread " + i);
            System.out.println("Creating: " + thread.getName());
            threadArrayList.add(thread); // Adding the thread into the arraylist
        }

        //Starting threads run routine
        for (Thread thread : threadArrayList) {
            thread.start();
        }

        for (Thread thread : threadArrayList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Join error in: " + thread.getName());
            }
        }
        System.out.println("Max Value: " + Collections.max(statistic.values()));
        System.out.println("Min Value: " + Collections.min(statistic.values()));
        System.out.println("Avg Value: " + statistic.values().stream().mapToDouble(Integer::doubleValue).average());
        System.out.println("Ending main...");
    }
}
