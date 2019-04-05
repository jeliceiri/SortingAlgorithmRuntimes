package Spr2019.JE;

/**
 * Big Oh Exploration
 * February 7, 2019
 * 
 * InsertionSort Class: this class performs insertion sort sorting. Code for this class
 * is from: https://www.geeksforgeeks.org/insertion-sort/ and is contributed by
 * Rajat Mishra.
 *
 * @author Jill Eliceiri
 */

class InsertionSort implements Sort
{ 
    
    public String getName(){
        return "Insertion Sort";
    }
    
    /** 
     * This method sorts an array using Insertion Sort. 
     * 
     * @param arr the array to be sorted
     */
    
    public void sortArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=1; i<n; ++i) 
        { 
            int key = arr[i]; 
            int j = i-1; 

            /* Move elements of arr[0..i-1], that are 
            greater than key, to one position ahead 
            of their current position */
            while (j>=0 && arr[j] > key) 
            { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    }    
    
} 
