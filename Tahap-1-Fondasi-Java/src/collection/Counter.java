package collection;
public class Counter {
    private static int count = 0;

    public Counter() {
        increment();
    }

    public static void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void reset() {
        count = 0;
    }


}
