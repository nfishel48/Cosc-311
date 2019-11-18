import java.util.Random;
import java.io.*;

public class hash2 {
    /*
Name: Nathaniel Fishel
Class: COSC 311 with Dr. Haynes
Date: 11/10/19
Description: This program will take 8 Randomaly generated int values and hash them in a table size 11
This hash table will be in a random access file
URL : https://github.com/nfishel48/Cosc-311/blob/master/hash2.java
 */
        //Initialize random generator
        static Random rgen = new Random(97);
        static int size = 11;
        static RandomAccessFile raf;
         static {
             try {
                 raf = new RandomAccessFile("table.dat", "rw");
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
         }

        // Hash key one
        static int h1(int key, int size){
            key =  key % size;
            return key;
        }

        //Build empty hash table in the file
        static void buildTable() throws IOException {
            raf.seek(0);
            for(int i = 0; i<size; i++){
                raf.writeInt(-1);
            }
            System.out.println("Table has been successfully initialized");
        }

        static void spaces(){
             System.out.println();
             System.out.println("===================================================");
             System.out.println();
        }

        static void hashFile () throws IOException {
             int temp, key, cuIndex;
             for(int i = 0; i<8; i++){
                temp = rgen.nextInt(100);
                System.out.println("The random number is "+temp);
                key = h1(temp, size);
                //4 bytes per int then go back 4 so your reading and writing to the correct place
                raf.seek(key*4-4);
                cuIndex = raf.readInt();
                if(cuIndex == -1) {
                    raf.seek(key*4-4);
                    raf.writeInt(temp);
                    System.out.println("Placing the number at index " + key + " in the hash table");
                }
                else
                    System.out.println("The index "+key+" is full this number will not go in the table");
             }
        }

        static void printFile() throws IOException{
             raf.seek(0);
             int temp, length;
             length = (int) (raf.length()/4);
            for(int i = 0; i<length; i++){
              temp = raf.readInt();
              System.out.println("The Byte offset "+(i*4) +" The index "+i+" The value "+temp);
             }
        }


        public static void main (String[] args) throws IOException {
             buildTable();
             spaces();
             hashFile();
             spaces();
             printFile();
             spaces();

        }

    }
/*
Table has been successfully initialized

===================================================

The random number is 38
Placing the number at index 5 in the hash table
The random number is 34
Placing the number at index 1 in the hash table
The random number is 67
The index 1 is full this number will not go in the table
The random number is 43
Placing the number at index 10 in the hash table
The random number is 26
Placing the number at index 4 in the hash table
The random number is 12
The index 1 is full this number will not go in the table
The random number is 59
The index 4 is full this number will not go in the table
The random number is 49
The index 5 is full this number will not go in the table

===================================================

The Byte offset 0 The index 0 The value 34
The Byte offset 4 The index 1 The value -1
The Byte offset 8 The index 2 The value -1
The Byte offset 12 The index 3 The value 26
The Byte offset 16 The index 4 The value 38
The Byte offset 20 The index 5 The value -1
The Byte offset 24 The index 6 The value -1
The Byte offset 28 The index 7 The value -1
The Byte offset 32 The index 8 The value -1
The Byte offset 36 The index 9 The value 43
The Byte offset 40 The index 10 The value -1
The Byte offset 44 The index 11 The value -1

===================================================



 */


