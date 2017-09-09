package com.laining.alogrithms.sort;

import static com.laining.alogrithms.sort.SortUtils.less;

public class MergeSort1 {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null)
            return;
        int length = array.length;
        if (length <= 1)
            return;
        T[] aux = (T[]) new Comparable[length];
        sort(array, aux, 0, length - 1);

    }

    static <T extends Comparable<? super T>> void sort(T[] array, T[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, hi, mid);
    }

    static <T extends Comparable<? super T>> void merge(T[] array, T[] aux, int lo, int hi, int mid) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = array[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                array[k] = aux[j++];
            else if (j > hi)
                array[k] = aux[i++];
            else if (less(aux[i], aux[j]))
                array[k] = aux[i++];
            else
                array[k] = aux[j++];
        }

    }

}
