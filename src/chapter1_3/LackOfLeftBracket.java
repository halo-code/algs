package chapter1_3;

import java.util.Scanner;
import java.util.Stack;

//import edu.princeton.cs.introcs.In;

public class LackOfLeftBracket {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] str = s.split(" ");
		Stack<String> numStack = new Stack<String>();
		Stack<String> opStack = new Stack<String>();
		for(int i = 0 ; i < str.length; i++){
			if(str[i].equals("*") || str[i].equals("/") || str[i].equals("+") || str[i].equals("-")){
				opStack.push(str[i]);
				
			}
			else if(str[i].equals(")")){//Èç¹ûÊÇÓÒÀ¨ºÅ
				String temp = numStack.pop();
				String str1 = "(" + numStack.pop() + opStack.pop() + temp + ")";
				
				numStack.push(str1);
			}
			else{
				numStack.push(str[i]);
			}
		}
		
		System.out.println(numStack.pop());
	}

}
