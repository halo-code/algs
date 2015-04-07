package chapter1_3;

import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.introcs.In;


public class Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flag = 0;
		Stack<Character> stack  = new Stack<Character>();//new point : Character
		In in = new In();
		String str = in.readAll().trim();
		for(int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{'){
				stack.push(ch);
				continue;
			}
			if(ch == ')'){
				if(! (stack.pop() == '(')){
					flag = 1;
					break;
				}
			}
			if(ch == ']'){
				if(!(stack.pop() == '[')){
					flag = 1;
					break;
				}
			}
			if(ch == '}'){
				if(!(stack.pop() == '{')){
					flag = 1;
					break;
				}
			}
			//System.out.print("now the state is " + stack.toString());
			
		}
		if(flag == 1){
			System.out.print("false");
		}
		else{
			System.out.print("true");
		}
	}

}
