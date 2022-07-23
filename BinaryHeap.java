import java.util.Arrays;
import java.util.Scanner;
public class BinaryHeap {
    private static final int DEFAULT_SIZE = 256;
    private int[] baseArray;
    private int currentSize;
    private int size;
    public BinaryHeap(int initialCapacity) {
        if (initialCapacity <= 0) throw new IllegalArgumentException("initial capacity cannot be zero or negative");
        baseArray = new int[initialCapacity];
        size = initialCapacity;
        currentSize = 0;
    }
    public BinaryHeap() {
        this(DEFAULT_SIZE);
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public void insert(int e) {
        if (currentSize == size)
            throw new RuntimeException("maximum size reached");
        int hole = currentSize;
        for (; hole > 0 && e < baseArray[hole / 2]; hole /= 2) {
            baseArray[hole] = baseArray[hole / 2];
        }
        baseArray[hole] = e;
        currentSize++;
    }
    public int deleteMin() {
        if (isEmpty()) throw new RuntimeException("deleteMin called on an empty heap");
        int retVal = baseArray[0];
        baseArray[0] = baseArray[--currentSize];
        percolateDown(0);
        return retVal;
    }
    private void percolateDown(int hole) {
        int child;
        int temp = baseArray[hole];
        for (; 2 * hole <= currentSize; hole = child) {
            child = (hole << 1);
            if (child != currentSize && baseArray[child + 1] < baseArray[child]) {
                child++;
            }
            if (baseArray[child] < temp) {
                baseArray[hole] = baseArray[child];
            } else break;
        }
        baseArray[hole] = temp;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(baseArray, 0, currentSize));
    }
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        Scanner cin = new Scanner(System.in);
        while (true) {
            int i = cin.nextInt();
            heap.insert(i);
            System.out.println("Heap status: " + heap);
            int cmin = heap.deleteMin();
            System.out.println("Current min: " + cmin);
            heap.insert(cmin);
        }
    }
}
