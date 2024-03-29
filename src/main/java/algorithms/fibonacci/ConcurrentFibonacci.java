package algorithms.fibonacci;

import algorithms.templates.ConcurrentDivideAndConquerable;
import algorithms.templates.DivideAndConquerable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentFibonacci extends RecursiveTask<Long> implements ConcurrentDivideAndConquerable<Long> {
    private final int n;

    public ConcurrentFibonacci(final int n) {
        this.n = n;
    }

    @Override
    public Long concurrentDivideAndConquer() throws ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(this);
    }

    @Override
    public boolean isBasic() {
        return n <= 1;
    }

    @Override
    public Long baseFun() {
        return (long) n;
    }

    @Override
    public List<? extends DivideAndConquerable<Long>> decompose() {
        List<DivideAndConquerable<Long>> subcomponents = new ArrayList<>();
        subcomponents.add(new ConcurrentFibonacci(n - 1));
        subcomponents.add(new ConcurrentFibonacci(n - 2));
        return subcomponents;
    }

    @Override
    public Long recombine(List<Long> intermediateResults) {
        return intermediateResults.get(0) + intermediateResults.get(1);
    }

    @Override
    protected Long compute() {
        if (this.isBasic()) {
            return this.baseFun();
        }

        List<ConcurrentFibonacci> subtasks = new ArrayList<>();
        subtasks.add(new ConcurrentFibonacci(n - 1));
        subtasks.add(new ConcurrentFibonacci(n - 2));

        invokeAll(subtasks);

        long result = 0;
        for (ConcurrentFibonacci subtask : subtasks) {
            result += subtask.join();
        }

        return result;
    }
}
