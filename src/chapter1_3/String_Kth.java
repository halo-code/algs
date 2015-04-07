package chapter1_3;

import java.util.Scanner;
import java.util.Stack;

public class String_Kth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> stack  = new Stack<String>();
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			stack.push(in.next());
		}
		for(int i = 0; i < Integer.parseInt(args[0])-1; i++){
			stack.pop();
		}
		System.out.println(stack.peek());
	}

}
