package Spr2019.JE;

/**
 * Big Oh Exploration
 * February 7, 2019
 * 
 * Sort Interface: this interface has methods to sort an array, 
 * get the name,and print the array. The printArray() method code is from:
 * https://www.geeksforgeeks.org/insertion-sort/
 *
 * @author Jill Eliceiri
 */
public interface Sort
{
   //method to sort an array
   public void sortArray(int[] arr);
   
   //method to return the String name
   public String getName();
   
   //default method to print an array
   default void printArray(int arr[]){
       int n = arr.length; 
       for (int i=0; i<n; ++i){ 
           System.out.print(arr[i] + " "); 
       }     
       System.out.println();     
   }
}
