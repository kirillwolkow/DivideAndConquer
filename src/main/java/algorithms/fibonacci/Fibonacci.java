package algorithms.fibonacci;

import algorithms.templates.DivideAndConquerable;
import algorithms.templates.DynamicProgrammingDivideAndConquerable;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci implements DynamicProgrammingDivideAndConquerable<Long> {
    private final int n;

    public Fibonacci(final int n) {
        this.n = n;
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
        subcomponents.add(new Fibonacci(n - 1));
        subcomponents.add(new Fibonacci(n - 2));
        return subcomponents;
    }

    @Override
    public Long recombine(List<Long> intermediateResults) {
        return intermediateResults.get(0) + intermediateResults.get(1);
    }

    @Override
    public Long divideAndConquerWithMemory(Object... memory) {
        if (checkPreconditions(memory)) return (Long) memory[n];

        List<? extends DivideAndConquerable<Long>> subcomponents = this.decompose();
        List<Long> intermediateResults = new ArrayList<>(subcomponents.size());

        subcomponents.forEach(
            subcomponent -> intermediateResults.add(
                ((DynamicProgrammingDivideAndConquerable<Long>) subcomponent).divideAndConquerWithMemory(memory)
            )
        );

        memory[n] = recombine(intermediateResults);
        return (Long) memory[n];
    }

    private boolean checkPreconditions(Object[] memory) {
        if (memory[n] != null)
            return true;

        if (this.isBasic()) {
            memory[n] = this.baseFun();
            return true;
        }
        return false;
    }
}
