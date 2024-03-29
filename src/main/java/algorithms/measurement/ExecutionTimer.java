package algorithms.measurement;

import java.util.function.Supplier;

// TODO add mention
public class ExecutionTimer<T> {
    public final T result;
    public final long time; // nanoseconds

    public ExecutionTimer(final Supplier<T> code) {
        System.gc(); // important!
        long start = System.nanoTime();
        this.result = code.get();
        long end = System.nanoTime();
        this.time = end - start;
    }
}
