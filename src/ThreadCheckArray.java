import java.util.ArrayList;

/**
 * A {@link Runnable} task that recursively solves the Subset Sum problem
 * on a {@code ArrayList<Integer>} shared between two threads.
 * <p>
 * Thread "thread1" checks the subsets that include the last element, and
 * "thread2" checks the subsets that exclude it. The first thread to find a
 * solution raises the shared flag and publishes its solution vector.
 */
public class ThreadCheckArray implements Runnable {
    /** Whether this thread has found a solution. */
    private boolean flag;
    /** Solution vector: {@code winArray[i]} is true if element i is in the subset. */
    private boolean[] winArray;
    /** Data shared between the threads. */
    SharedData sd;
    /** The input numbers. */
    ArrayList<Integer> array;
    /** The target sum. */
    int b;

    /**
     * Creates a task that reads the input numbers and the target from the shared data.
     *
     * @param sd the shared data object holding the {@code ArrayList<Integer>} and the target
     */
    public ThreadCheckArray(SharedData sd) {
        this.sd = sd;
        synchronized (sd) {
            array = sd.getArray();
            b = sd.getB();
        }
        winArray = new boolean[array.size()];
    }

    /**
     * Recursively checks whether a subset of the first {@code n} elements sums to {@code b}.
     *
     * @param n the number of elements (from the start of the list) to consider
     * @param b the remaining target sum
     */
    void rec(int n, int b) {
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        if (n == 1) {
            if (b == 0 || b == array.get(n - 1)) {
                flag = true;
                synchronized (sd) { sd.setFlag(true); }
            }
            if (b == array.get(n - 1)) winArray[n - 1] = true;
            return;
        }

        rec(n - 1, b - array.get(n - 1));
        if (flag) winArray[n - 1] = true;
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        rec(n - 1, b);
    }

    /**
     * Runs the search for this thread and, if a solution is found,
     * stores the solution vector in the shared  data.
     */
    public void run() {
        if (array.size() != 1)
            if (Thread.currentThread().getName().equals("thread1"))
                rec(array.size() - 1, b - array.get(array.size() - 1));
            else
                rec(array.size() - 1, b);
        if (array.size() == 1)
            if (b == array.get(0) && !flag) {
                winArray[0] = true;
                flag = true;
                synchronized (sd) { sd.setFlag(true); }
            }
        if (flag) {
            if (Thread.currentThread().getName().equals("thread1"))
                winArray[array.size() - 1] = true;
            synchronized (sd) { sd.setWinArray(winArray); }
        }
    }
}