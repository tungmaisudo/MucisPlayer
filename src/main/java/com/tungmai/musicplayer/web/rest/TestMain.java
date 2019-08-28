package com.tungmai.musicplayer.web.rest;

public class TestMain {


    public static void main(String[] args) {

//        System.out.println("Giai thua: " + giaiThua(6));
//        System.out.println("Fibonaci: " + fibonaci(6));
//        thapHN2(5, "A", "B", "C");
//        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 27, 31, 37, 39 ,41, 43, 47};
//        System.out.println("Found 13 at index: " + searchBinary(arr, 13));
        int [] sort =  {12, 21,43, 2, 6, 5 ,8, 2 , 5, 1};
        mergeSort(sort);
        System.out.println("\nMảng sau khi sắp xếp: ");
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + "\t");
        }
    }

    public static int giaiThua(int n){

        if(n == 0) {
            return 1;
        }
        return n*giaiThua(n-1);
    }

    public static int fibonaci(int n) {
        if (n < 3) {
            return 1;
        }
        return fibonaci(n-1) + fibonaci(n -2);
    }

    public static void thapHN(int n, String nguon, String dich, String trungGian) {
        if(n == 1) {
            System.out.println("Chuyen tu A sang C");
        }
        if(n > 1) {
            //chuyen n-1 sang trungGian
            thapHN(n-1, nguon, trungGian, dich);
            //chuyen sang C
            System.out.println("Chuyen tu " + nguon +" sang " +dich);
            //chuyen n-1 trungGian sang dich
            thapHN(n-1, trungGian, dich, nguon);
        }
    }

    public static int searchBinary(int[] array, int valueSearch) {
        int min = 0;
        int max = array.length - 1;
        int mid = 0;

        while (min <= max) {
           mid = (min + max) / 2;
           if(array[mid] == valueSearch) {
               return mid;
           } else if(array[mid] < valueSearch) {
               min = mid - 1;
           } else {
               max = mid + 1;
           }
        }
        return -1;
    }

    public static void thapHN2(int n, String nguon, String dich, String trungGian) {

        if(n == 1) {
            System.out.println("Chuyen tu " + nguon + " den " + dich);
        }else {

            //chuyen n - 1 sang trungGian
            thapHN2(n -1 , nguon, trungGian, dich);

            //chuyen 1 sang dich
            thapHN2(1, nguon, dich, trungGian);

            //chuyen n-1 sang dic
            thapHN2(n - 1, trungGian, dich, nguon);

        }

    }

    public static void swap(int a, int b){
        int c = a;
        a = b;
        b = c;
    }

    public static void bubbleSort(int[] arr) {
        int tempSort;
        for(int i = 0; i < arr.length - 1; i++){

            for(int j = arr.length - 1; j > 0; j--){

                if(arr[j] < arr[j-1]) {
                    tempSort = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tempSort;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i< arr.length; i ++) {
            int valueInsert = arr[i];
            int index = i;
            while (index > 0 && valueInsert < arr[index - 1]) {
                arr[index] = arr[index-1];
                index --;
            }
            arr[index ] = valueInsert;
        }
    }

    public static void selectionSort(int[] arr) {
        int temp;
        for(int i =0; i< arr.length; i++) {
            int min = i;
            for(int j = i; j< arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if(length > 1) {

            int mid = length / 2;
            int l[] = new int[mid];
            int r[] = new int[length - mid];

            for (int i = 0; i < mid; i++) {
                l[i] = arr[i];
            }
            for (int i = mid; i < length; i++) {
                r[i - mid] = arr[i];
            }

            mergeSort(l);
            mergeSort(r);

            merge(arr, l, r, mid, length - mid);
        }
    }

    public static void merge(int[] arr, int[] l, int[] r, int left, int right) {
       int i = 0,  j = 0 , k =0;
       while(i< left && j < right) {
           if(l[i] <= r[j]) {
               arr[k++] = l[i++];
           } else {
               arr[k++] = r[j++];
           }
       }
       while (i< left) {
           arr[k++] = l[i++];
       }
       while (j<right){
           arr[k++] = r[j++];
       }
    }

}
