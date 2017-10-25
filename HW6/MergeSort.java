/*
Name: Tyler Cooper
HW#: 6
Title: Merge Sort
Description: This program preforms a merge sort on an input string of int, float, and string. 

Outside Resource(s): https://stackoverflow.com/questions/13727030/mergesort-in-java
                     
*/

import java.io.*;
import java.util.Arrays;


public class MergeSort {

    static void mergeSort(int[] A) //breaks the array in half until length is 1
    {
        if (A.length > 1) {
            int q = A.length/2;

            //changed range of leftArray from 0-to-q to 0-to-(q-1)
            int[] leftArray = Arrays.copyOfRange(A, 0, q-1);
            //changed range of rightArray from q-to-A.length to q-to-(A.length-1)
            int[] rightArray = Arrays.copyOfRange(A,q,A.length-1);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }
    
    static void mergeSort(float[] A) //breaks the array in half until length is 1
    {
        if (A.length > 1) {
            int q = A.length/2;

            //changed range of leftArray from 0-to-q to 0-to-(q-1)
            float[] leftArray = Arrays.copyOfRange(A, 0, q-1);
            //changed range of rightArray from q-to-A.length to q-to-(A.length-1)
            float[] rightArray = Arrays.copyOfRange(A,q,A.length-1);

            mergeSort(leftArray);
            mergeSort(rightArray);

            //merge(A,leftArray,rightArray);
        }
    }
    
    static void mergeSort(String[] A) //breaks the array in half until length is 1
    {
        if (A.length > 1) {
            int q = A.length/2;

            //changed range of leftArray from 0-to-q to 0-to-(q-1)
            String[] leftArray = Arrays.copyOfRange(A, 0, q-1);
            //changed range of rightArray from q-to-A.length to q-to-(A.length-1)
            String[] rightArray = Arrays.copyOfRange(A,q,A.length-1);

            mergeSort(leftArray);
            mergeSort(rightArray);

            //merge(A,leftArray,rightArray);
        }
    }

    static void merge(int[] a, int[] l, int[] r) //comparison and sorting of elements
    {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    }
    
    static void merge(float[] a, float[] l, float[] r) //comparison and sorting of elements
    {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    }
    
    static void merge(String[] a, String[] l, String[] r) //comparison and sorting of elements
    {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li].compareTo(r[ri]) < 0) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        //return a;

    }

}