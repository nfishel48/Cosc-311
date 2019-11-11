/*
Name: Nathaniel Fishel
Class: COSC 311 with Dr. Haynes
Date: 11/10/19
Description: This program will take 8 Randomaly generated int values and hash them in a table size 11
The program will use Double hashing to resolve collisions

 */

import java.util.*;

public class hash {
    //Initialize random generator
    static Random rgen = new Random(97);
    static int size = 11;

    // find the largest prime number less than the size of the hash table using wilson's Theorem
    static int findPrime(int size){
        int prime = 2;
        for(int p = 2; p<size; p++){
            if (factorial(p-1)%p == p-1){
                prime = p;
            }
        }
        return prime;
    }

    //factorial method
    static int factorial ( int number){
        if(number <= 1) return 1;
        else return number * factorial(number -1);
    }

    // Hash key one
    static int h1(int key, int size){
     key =  key % size;
     return key;
    }

    // Hash key two
    static int h2(int key){
        int n = findPrime(size);
        key = n - (key % n);
        return key;
    }

    static int[] fillArray(){
        int[] numbers = new int[8];
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = rgen.nextInt(100);
        }
        return numbers;
    }

    static int[] hashArray(int[] numbers){
        int index = 0;
        int index2 = 0;
        int [] table = new int[size];
        for(int i = 0; i<numbers.length; i++){
            index = h1(numbers[i], size);
            if(table[index] == 0) {
                table[index] = numbers[i];
                System.out.println("Placing "+numbers[i]+" at index "+index);
            }
            else{
                index2 = h2(numbers[i]);
                boolean full = false;
                int j = 1;
                while(full != true) {
                    int index3 = index + (j * index2);
                    if (index3 > size){
                        index3 = 0;
                    }
                    if(table[index3] == 0) {
                        table[index3] = numbers[i];
                        System.out.println("Placing " + numbers[i] + " at index " + index3);
                        full = true;
                    }
                    else
                        j++;
                }
            }
        }

        return table;
    }

    static void printArray(int[] array){
        for(int i = 0; i<array.length; i++){
            System.out.print("Index "+i+": "+array[i]+" ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        int[] numbers = fillArray();
        System.out.println("The original Array is: ");
        printArray(numbers);
        int[] table = hashArray(numbers);
        System.out.println("The hashed Array is: ");
        printArray(table);
    }

}
