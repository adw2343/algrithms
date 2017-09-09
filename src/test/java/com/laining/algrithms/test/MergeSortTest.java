package com.laining.algrithms.test;

import static com.laining.alogrithms.sort.SortUtils.getRandomIntegerArray;
import static com.laining.alogrithms.sort.SortUtils.isSorted;
import static com.laining.alogrithms.sort.SortUtils.print;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.laining.alogrithms.sort.MergeSort1;

public class MergeSortTest {

    @Test
    public void test() {
        Map<String, String> map = new TreeMap<String, String>();
        Integer[] array = getRandomIntegerArray(1000);
        print(array);
        long start = System.currentTimeMillis();
        MergeSort1.sort(array);
        long end = System.currentTimeMillis();
        print(array);
        System.out.println("used:" + (end - start));
        assertTrue(isSorted(array));
    }

}
