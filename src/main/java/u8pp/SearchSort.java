package u8pp;

import java.util.ArrayList;

public class SearchSort {
    public SearchSort(){
    }
//least to greatest sort, searches unsorted part and swaps to find order
    public static void selectionSort(int[] numInput ) {
        int smallestIndex;
        for (int i = 0; i < numInput.length; i++){
            smallestIndex = i;
            for (int j = i; j < numInput.length; j++){
                if (numInput[j] < numInput[smallestIndex]){
                    smallestIndex = j;
                }
            }
            if (smallestIndex != i){
                swap(numInput, smallestIndex, i);
            }
        }
    }
    public static ArrayList<Student> selectionSort(ArrayList<Student> word) {
        int Index;
        ArrayList<Student> wordInput = new ArrayList<>();
        makeNew(wordInput, word);
        ArrayList<Student> words = new ArrayList<>();
        for (int i = 0; i < wordInput.size(); i++){
            Index = i;
            for (int j   = i; j < wordInput.size(); j++){
                if (Student.compare(wordInput.get(Index), wordInput.get(j))> 0){
                    Index = j;
                }
            }
            words.add(wordInput.get(Index));
            if (Index != i){
                swap(wordInput, Index, i);
            }
        }
        return words;
    }
//inserts given value in correct spot
    public static void insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j - 1] > input[j]) {
                    swap (input, j, j-1);
                }
            }
        }
    }
    public static ArrayList<Student> insertionSort(ArrayList<Student> word) {
        ArrayList<Student> wordInput = new ArrayList<>();
        makeNew(wordInput, word);
        for (int i = 1; i < wordInput.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (Student.compare(wordInput.get(j-1), wordInput.get(j))> 0) {
                    swap(wordInput, j, j-1);
                }
            }
        }
        return wordInput;
    }
//factorial splits until 2 can be compared
    public static void mergeSort(int[] input) {
        int end = input.length;
        if (end < 2) {
        return;
        }
        int mid = end / 2;
        int[] left = new int[mid];
        int[] right = new int[end - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = input[i];
        }
        for (int i = mid; i < end; i++) {
            right[i - mid] = input[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(input, left, right, mid, end - mid);
    }
    public static ArrayList<Student> mergeSort(ArrayList<Student>  wordInput) {
        ArrayList<Student> input = new ArrayList<>();
        makeNew(input, wordInput);
        ArrayList<Student> last = new ArrayList<>();
            return input;
    }
    //swaps items on list
    private static void swap (int[] list, int start, int end){
        int temp = list[start];
        list[start] = list[end];
        list[end] = temp;
    }
    private static void swap(ArrayList<Student> list, int start, int end){
        Student temp =  list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
    }
//reverses merging
    private static void merge(int[] input, int[] left, int[] right, int mid, int halfMid) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < mid && j < halfMid) {
            if (left[i] <= right[j]) {
                input[k++] = left[i++];
            }
            else {
                input[k++] = right[j++];
            }
        }
        while (i < mid) {
            input[k++] = left[i++];
        }
        while (j < halfMid) {
            input[k++] = right[j++];
        }
    }
    //helper method creates new list
    private static void makeNew(ArrayList<Student> neww, ArrayList<Student> og){
        for (int i = 0; i < og.size(); i++){
            neww.add(og.get(i));
        }
    }
}