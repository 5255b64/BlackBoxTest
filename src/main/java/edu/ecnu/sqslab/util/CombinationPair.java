package edu.ecnu.sqslab.util;

public class CombinationPair<K extends Comparable, V> extends MyPair {

    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public CombinationPair(Comparable key, Object value) {
        super(key, value);
    }

    public int compareTo(Object o) {
        if(o instanceof CombinationPair) {
            return getKey().compareTo(((CombinationPair) o).getKey());
        }else if(o instanceof Comparable){
            return getKey().compareTo((Comparable)o);
        }else{
            System.err.println("CombinationPair.compareTo(Object o) 输入参数类型错误:"+ o.getClass());
            return -1;
        }
    }
}
