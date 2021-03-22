//toan le
//occc spring 2021
//advance java
//sort and merge homework

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
public class SortAndMerge {

    public static int[] array1;
    public static int num;

    public static void mergeSort(int[] list) {

            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);

           merge(firstHalf, secondHalf, list);
            //System.out.println(firstHalf.length);
            //System.out.println(secondHalf.length);

    }
    public static void printHalf(int[] list){
        for(int i = 0; i <list.length; i++){
            System.out.print(" " + list[i]);
        }
        System.out.println(list.length);
    }
    public static int[] inputFile(String fileName) throws FileNotFoundException{
        Scanner f = new Scanner(new File(fileName));

        int arraySize = f.nextInt();

        int [] theArray = new int [arraySize];

        for(int i = 0; i < theArray.length; i++) {

            theArray[i] = f.nextInt();

        }
        mergeSort(theArray);
        return theArray;
    }
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static void main(String[] args) throws FileNotFoundException{
        int[] list = {2,3,2,5,6,1,2,3,2};
        //mergeSort(list);
        //for (int j : list) {
        //    System.out.print(j + " ");
        //}
        String fileName1 = "C:\\Users\\StaleEgg\\Documents\\split.txt";
        int [] sortedArray1 = inputFile(fileName1);
        int count = 0;

        for(int i =0; i < sortedArray1.length; i++) {
            System.out.print(" " + sortedArray1[i]);
            count++;
        }
        //System.out.println(count);

    }

    /**public static void main(String [] args) throws FileNotFoundException, IOException{
        String fileName1 = "";
        String fileName2 = "";
        String fileName3 = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Sort and Merge program!\n");


        if(args.length == 1) {
            fileName1 = args[0];
            System.out.print("Please enter the SECOND file name: ");
            fileName2 = scanner.next();
            System.out.print("Please enter the OUTPUT file name:");
            fileName3 = scanner.next();
        }
        else if (args.length == 2) {
            fileName1 = args[0];
            fileName2 = args[1];
            System.out.print("Please enter the OUTPUT file name:");
            fileName3 = scanner.next();
        }
        else if (args.length == 3) {
            fileName1 = args[0];
            fileName2 = args[1];
            fileName3 = args[2];
        }

        else {
            System.out.print("Please enter the FIRST file name: ");
            fileName1 = scanner.next();
            System.out.print("Please enter the SECOND file name: ");
            fileName2 = scanner.next();
            System.out.print("Please enter the OUTPUT file name: ");
            fileName3 = scanner.next();
        }


        int [] sortedArray1 = inputFile(fileName1);
        int [] sortedArray2 = inputFile(fileName2);
        int [] mergeUnsorted = new int[sortedArray1.length + sortedArray2.length];

        //System.arraycopy(sortedArray1, 0, mergeUnsorted, 0, sortedArray1.length);
        //System.arraycopy(sortedArray2, 0, mergeUnsorted, sortedArray1.length, sortedArray2.length);
        //sort(mergeUnsorted);

        mergeUnsorted = merge(sortedArray1, sortedArray2);
        //System.out.print("Please enter the OUTPUT file name: ");
        //fileName3 = scanner.next();
        PrintStream printToFile = new PrintStream(new File(fileName3));
        //System.setOut(printToFile);
        //displayArray(mergeUnsorted);
        //System.out.print(mergeUnsorted[99]);
    }

    public static int[] merge(int[] list1, int[] list2) {
        int mergeLength = list1.length + list2.length;
        int[] mergeSorted = new int[mergeLength];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < list1.length && j < list2.length) {
            if (list1[i] <= list2[j]) {
                mergeSorted[k] = list1[i];
                i++;
            } else {
                mergeSorted[k] = list2[j];
                j++;
            }
            k++;
        }

        while (i < list1.length) {
            mergeSorted[k] = list1[i];
            i++;
            k++;
        }

        while (j < list2.length) {
            mergeSorted[k] = list2[j];
            j++;
            k++;
        }

        return mergeSorted;
    }

    public static void sort(int[] values) {

        if (values ==null || values.length==0){
            return;
        }
        array1 = values;
        num = values.length;
        quicksort(0, num - 1);
    }


    public static void quicksort(int low, int high) {
        int i = low, j = high;

        int pivot = array1[low + (high-low)/2];

        while (i <= j) {

            while (array1[i] < pivot) {
                i++;
            }

            while (array1[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    public static void exchange(int i, int j) {
        int temp = array1[i];
        array1[i] = array1[j];
        array1[j] = temp;
    }


    //input the file and store it in the array
    public static int[] inputFile(String fileName) throws FileNotFoundException{
        Scanner f = new Scanner(new File(fileName));

        int arraySize = f.nextInt();

        int [] theArray = new int [arraySize];

        for(int i = 0; i < theArray.length; i++) {

            theArray[i] = f.nextInt();

        }
        sort(theArray);
        return theArray;
    }

    //display the array if needed
    public static void displayArray(int [] theArray) {

        for(int i =0; i < theArray.length; i++) {

            if (i%10 == 0) {

                System.out.println();

            }

            System.out.printf("%7d", theArray[i]);

        }

        System.out.println();

        System.out.println();

    }


*/
}
