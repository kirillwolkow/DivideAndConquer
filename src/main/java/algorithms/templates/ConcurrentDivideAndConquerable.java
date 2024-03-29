package algorithms.templates;

import java.util.concurrent.ExecutionException;

public interface ConcurrentDivideAndConquerable<T> extends DivideAndConquerable<T> {
    T concurrentDivideAndConquer() throws ExecutionException, InterruptedException;
}
