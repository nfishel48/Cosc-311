/**
 * @author Nathaniel Fishel
 * @assignment hw0926
 * @class COSC 311
 * @Semester Fall 2019
 */

package singlylinkedlist;
import java.util.Stack;
import java.util.Scanner;
public class hw0926a {


	static boolean palindrome (String[] arr) {
		boolean answer = false;
		 Stack s = new Stack();
		 for(int i = 0; i<=arr.length - 1; i++) {
			 s.push(arr[i]);
		 }
		 for(int j=0; j<=arr.length - 1; j++) {
			 String temp = (String) s.pop();
			if(temp.equals(arr[j])) {
				answer = true;
				//System.out.println("True");
			}else {
				answer = false;
				//System.out.println("False");
			}
		 }
		return answer;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Scanner scr = new Scanner(System.in);
		System.out.println("How long would you like the array to be");
		int l = stdIn.nextInt();
		System.out.println();
		String arr[] = new String[l];
		for(int i = 0;i<=l-1;i++) {
		System.out.println("Enter the word for the "+i+" spot in the array.");
		arr[i]= scr.nextLine();
		}
		boolean answer = palindrome(arr);
		System.out.println(answer);
	}

}

/**
 * How long would you like the array to be
4

Enter the word for the 0 spot in the array.
a
Enter the word for the 1 spot in the array.
b
Enter the word for the 2 spot in the array.
c
Enter the word for the 3 spot in the array.
d
false

How long would you like the array to be
4

Enter the word for the 0 spot in the array.
a
Enter the word for the 1 spot in the array.
boy
Enter the word for the 2 spot in the array.
boy
Enter the word for the 3 spot in the array.
a
true

How long would you like the array to be
5

Enter the word for the 0 spot in the array.
a
Enter the word for the 1 spot in the array.
b
Enter the word for the 2 spot in the array.
caliph
Enter the word for the 3 spot in the array.
b
Enter the word for the 4 spot in the array.
a
true
**/
