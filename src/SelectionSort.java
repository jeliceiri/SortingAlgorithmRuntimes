package Spr2019.JE;

/**
 * Big Oh Exploration
 * February 7, 2019
 * 
 * SelectionSort Class: this class performs selection sort sorting. Code for this class
 * is from: https://www.geeksforgeeks.org/heap-sort/ and is contributed by
 * Rajat Mishra.
 *
 * @author Jill Eliceiri
 */
public class SelectionSort implements Sort { 

    public String getName(){
        return "Selection Sort";
    }
    public void sortArray(int arr[]) {
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) { 
        
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    }  
}
