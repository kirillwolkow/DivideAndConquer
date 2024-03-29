package algorithms.templates;

public interface DynamicProgrammingDivideAndConquerable<T> extends DivideAndConquerable<T> {
    T divideAndConquerWithMemory(Object... memory);
}
