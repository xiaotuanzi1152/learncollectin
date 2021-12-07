package cn.xjt.demo.sort;

/**
 *使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好
 * @param <T>sdsdsdsdf
 */

public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}