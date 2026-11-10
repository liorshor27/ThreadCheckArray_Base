import java.util.ArrayList;

/**
 * Holds the data shared between the {@link ThreadCheckArray} threads
 * solving the Subset Sum problem: the input numbers as a
 * {@code ArrayList<Integer>}, the target sum, the shared "solution found"
 * flag, and the solution vector.
 */
public class SharedData {
    /** The input numbers. */
    private ArrayList<Integer> array;
    /** Solution vector: {@code winArray[i]} is true if element i is in the subset. */
    private boolean[] winArray;
    /** Set to true by the first thread that finds a solution. */
    private boolean flag;
    /** The target sum. */
    private final int b;

    /**
     * Creates the shared data for a Subset Sum search.
     *
     * @param array the input numbers as a {@code ArrayList<Integer>}
     * @param b     the target sum
     */
    public SharedData(ArrayList<Integer> array, int b) {
        this.array = new ArrayList<>(array);
        this.winArray = new boolean[this.array.size()];
        this.b = b;
    }

    /**
     * Returns the input numbers.
     *
     * @return the {@code ArrayList<Integer>} of input numbers
     */
    public ArrayList<Integer> getArray() { return array; }

    /**
     * Returns the solution vector.
     *
     * @return a {@code boolean[]} where element i is true if number i is in the subset
     */
    public boolean[] getWinArray() { return winArray; }

    /**
     * Stores a copy of the solution vector found by a thread.
     *
     * @param winArray the solution vector to store
     */
    public void setWinArray(boolean[] winArray) {
        this.winArray = new boolean[winArray.length];
        System.arraycopy(winArray, 0, this.winArray, 0, winArray.length);
    }

    /**
     * Returns whether a solution has been found.
     *
     * @return true if some thread has found a solution
     */
    public boolean getFlag() { return flag; }

    /**
     * Sets the "solution found" flag.
     *
     * @param flag the new value of the flag
     */
    public void setFlag(boolean flag) { this.flag = flag; }

    /**
     * Returns the target sum.
     *
     * @return the target sum {@code b}
     */
    public int getB() { return b; }
}