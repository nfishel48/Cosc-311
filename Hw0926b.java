/**
 * @author Nathaniel Fishel
 * @assignment hw0926
 * @class COSC 311
 * @Semester Fall 2019
 */


import java.util.Stack;
import java.util.Scanner;
public class Hw0926b {

	public static void main(String args[]) {
		boolean answer = false;
		 Stack s = new Stack();
		 for(int i = 0; i<=args.length - 1; i++) {
			 s.push(args[i]);
		 }
		 for(int j=0; j<=args.length - 1; j++) {
			 String temp = (String) s.pop();
			if(temp.equals(args[j])) {
				answer = true;
				//System.out.println("True");
			}else {
				answer = false;
				//System.out.println("False");
			}
		 }
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
