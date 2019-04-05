package Spr2019.JE;

import java.lang.Math;
import java.util.*;
/**
 * Big Oh Exploration
 * February7, 2019
 * 
 * The main controlling class for the project. This project calculates the mean
 * execution time of four different sorting algorithms using random data implemented
 * on multiple runs. Structure and sections of code for this class is from: 
 * http://www.newthinktank.com/2013/03/big-o-notations/, which is contributed by 
 * Derek Banas.
 * 
 * @author Jill Eliceiri
 */
public class BigOhExploration
{
    //constant for the number of trials to be executed
    private static final int numOfRuns = 10;
    
    //instance variables  
    static int[] theArray;
    private int arraySize;
    private int itemsInArray = 0;
    

     /** 
     * This main method runs the program and performs the following: create 
     * and instantiate BigOhExploration objects and adds them to an ArrayList, 
     * creates and instantiates instances of each Sort class and adds them to 
     * an ArrayList, and iterates over each BigO and Sort object to execute and 
     * extract running times on each type of sort. Alter the parameters of the 
     * BigO object to change the array size or comment out Sort objects to 
     * isolate Sort types. See class note for code credit.
     * 
     * @param arguments the command line arguments
     */

    public static void main(String args[]) 
    {   
        /* Multiple BigO objects and a BigOList object are created and instantiated.  
        To match the results table in figure 4 of the report, add the 5 additional 
        BigO objects with parameters of larger input sizes and adjust the Sort 
        types accordingly */
       
        List<BigOhExploration> myBigOList = new ArrayList();
        BigOhExploration myBigO1 =    new BigOhExploration(1000);
        BigOhExploration myBigO2 =    new BigOhExploration(10000);
        BigOhExploration myBigO3 =    new BigOhExploration(100000);
        BigOhExploration myBigO4 =    new BigOhExploration(200000);
        BigOhExploration myBigO5 =    new BigOhExploration(500000);
     
        //add the BigO objects to the BigOList to iterate over later
        myBigOList.add(myBigO1);
        myBigOList.add(myBigO2);
        myBigOList.add(myBigO3);
        myBigOList.add(myBigO4);
        myBigOList.add(myBigO5);
        
        //create and instantiate Sort objects and a SortList object  
        List<Sort> mySortList = new ArrayList();
        MergeSort myMerge = new MergeSort();
        HeapSort myHeapSort = new HeapSort();
        InsertionSort myInsert = new InsertionSort();
        SelectionSort mySelect = new SelectionSort();
        
        //add the objects to the SortList to iterate over later
        mySortList.add(myMerge);
        mySortList.add(myHeapSort);
        mySortList.add(myInsert);
        mySortList.add(mySelect);
        
        /** 
         *  This method will perform the following: 
         *  1) iterate over each BigOhExploration object and print the size of N
         *  2) iterate over each Sort object, keep track of a sum variable to 
         *     establish a mean of the number of trials, and print out the Sort name
         *  3) iterate over the number of trials and calculate the time each Sort's sortArray()
         *     method took, and print out the results.
         */  
        //iterate over objects in the BigO list
        for (BigOhExploration myBigO : myBigOList)
        {
            System.out.println();
            System.out.println("Size of N = " + myBigO.arraySize);
            //iterate ver objects in the Sort list
            for(Sort mySort : mySortList)
            {
                //keep track of a sum variable to calculate average mean time
                double sum = 0.0;
                String name = mySort.getName();
                System.out.println();
                System.out.println("\t---" + name + "---");              
                //iterate over the number of runs
                for (int index = 1; index <= numOfRuns; ++index)
                {
                    myBigO.generateRandomArray();
                    
                    //initial testing to print array before sort
                    //mySort.printArray(theArray);
                    
                    //create and instantiate a time object to calculate executed time
                    Time time = new Time();
                    time.start();
                    //call the method appropriate to each type of Sort
                    mySort.sortArray(theArray);
                    time.end();
                    
                    //for testing, print array after sort
                    //mySort.printArray(theArray);

                    System.out.println("\tTrial #" + index + " took " + time.compute() + " seconds");
                    sum += time.compute();
                    
                }
                double average = sum / numOfRuns;
                System.out.println("\t" + name + " Average: " + average + " seconds");
            }
        }
    }

    /**
     *  Constructor with parameter
     *  @param size the size of the array
     */  
    BigOhExploration(int size) {
        arraySize = size;
        theArray = new int[size];
    }
    /**
     *  This method generates a random size array is is from:
     *  http://www.newthinktank.com/2013/03/big-o-notations/
     *  @author Derek Banas
     */
    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 1000) + 10;
        }
        itemsInArray = arraySize - 1;
    }
}
