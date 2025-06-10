package collections;

import java.util.Comparator;

public class DefaultComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<T>)o1).compareTo(o2);//vai fazer a comparação default do java de lexografia!
    }// 0 → iguais;
    // < 0 → o1 é menor que o2 (ou seja, o1 tem mais prioridade)
    // > 0 → o1 é maior que o2 (ou seja, o2 tem mais prioridade)

    
  
}
