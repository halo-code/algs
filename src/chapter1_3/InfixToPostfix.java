package chapter1_3;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> stack = new Stack<String>();
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			if(str.equals("+")) stack.push(str);
			else if(str.equals("*")) stack.push(str);
			else if(str.equals("("));
			
		}
		
		
		
	}

}
