import java.io.*; 
/**
 * CPSC 6109 Project 1 
 * Big Oh Exploration
 * February 7, 2019
 * 
 * Time Class: this class keeps record of a Time object
 * 
 * Information used for building it is from:
 * https://www.geeksforgeeks.org/measure-time-taken-function-java/
 * https://stackoverflow.com/questions/1770010/how-do-i-measure-time-elapsed-in-java
 * https://stackoverflow.com/questions/924208/how-to-convert-nanoseconds-to-seconds-using-the-timeunit-enum
 *
 * @author Jill Eliceiri
 */

public class Time { 
    
    //instance variables 
    long start;
    long end;

    /** 
     * This method sets the start time
     */
    public void start() 
    { 
        start = System.nanoTime();
    } 
    /** 
     * This method sets the end time
     */
    public void end() 
    { 
        end = System.nanoTime();
    } 
    /** 
     * This computes and returns the total time elapsed
     */
    public double compute() 
    { 
       long total = end - start;
       double seconds = (double)total/1000000000.0;
       return seconds;
    } 
} 