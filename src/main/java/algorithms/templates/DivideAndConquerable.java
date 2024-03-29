package algorithms.templates;

import java.util.List;
import java.util.ArrayList;

// TODO add mention
public interface DivideAndConquerable<T> {
    boolean isBasic();
    T baseFun();
    List<? extends DivideAndConquerable<T>> decompose();
    T recombine(List<T> intermediateResults);

    default List<? extends DivideAndConquerable<T>> stump() {
        return new ArrayList<DivideAndConquerable<T>>(0);
    }

    default T divideAndConquer() {
        if (this.isBasic()) return  this.baseFun();

        List<? extends DivideAndConquerable<T>> subcomponents = this.decompose();

        List<T> intermediateResults = new ArrayList<T>(subcomponents.size());

        subcomponents.forEach(
            subcomponent -> intermediateResults.add(
                subcomponent.divideAndConquer()
            )
        );

        return recombine(intermediateResults);
    }
}
