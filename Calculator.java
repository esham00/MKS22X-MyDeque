import java.util.*;
public class Calculator{
    public static double eval(String s){
        MyDeque<Double> values = new MyDeque<Double>();
	String[] st = s.split(" ");
	for(int i = 0; i < st.length; i++) {
	    try {
		values.addLast(Double.parseDouble(st[i]));
	    }
	    catch(NumberFormatException e) {
		Double a = values.removeLast();
		Double b = values.removeLast();
		char operation = st[i].charAt(0);
		//System.out.println(b + " " + operation +" "  + a);
		if (operation == '+') {
		    values.addLast(b+a);
		} else if(operation == '*') {
		    values.addLast(b*a);
		} else if(operation == '/') {
		    values.addLast(b/a);
		} else if (operation == '-') {
		    values.addLast(b-a);
		} else if (operation == '%') {
		    values.addLast(b%a);
		}
		//System.out.println(values.getLast());
	    }
	}
	return values.getFirst();
    }
    public static void main(String[] args){
	//TIP: PRINT OUT YOUR TOKENS IN EVAL!!!
	//Test strings
	String[] tests = new String[]{
	    "3 2 + ", //addition
	    "6 8 - ", //subtraction
	    "9 12 * ", //multiplication
	    "7 3 / ", //division
	    "10 6 % ", //mod
	    "4 3 - 9 * ", //two operations
	    "5 9 * 10 - 8 + 2 * ", //four operations
	    // 45 10 - 8 + 2 *
	    // 35 8 + 2 *
	    // 43 2 *
	    // 86
	    "8 9 60 10 1 * / 5 - % + " //all operations
	    // 8 9 60 10 / 5 - % +
	    // 8 9 6 5 - % +
	    // 8 9 1 % +
	    // 8 0 +
	    // 8
	};
	String[] errorMessages = new String[]{
	    //addition
	    "Check your token making! This is the most basic test for addition. ",
	    //subtraction
	    "Check your token making! This is the most basic test for subtraction. Your values may also be out of order in eval! (Subtraction is not commutative)",
	    //multiplication
	    "Check your token making! This is the most basic test for multiplication.",
	    //division
	    "Check your token making! This is the most basic test for division. Your values may also be out of order in eval! Since this is division, make sure your program treats all numbers as floating point! (Division is not commutative)",
	    //mod
	    "Check your token making! This is the most basic test for mod. Your values may also be out of order in eval! (Mod is not commutative)",
	    //two operations
	    "Check the order in which you did your operations. There are two operations in this test:\n1) 4 3 - : 1\n2) 1 9 * : 9",
	    //four operations
	    "Check the order in which you did your operations. Four operations are in this test:\n1) 5 9 * : 45 \n2) 45 10 - : 35 \n3) 35 8 + : 43 \n4) 43 2 * : 86",
	    //all operations
	    "Check the order in which you did your operations. All five operations are in this test: \n1) 10 1 * \n2) 60 10 / \n3) 6 5 - \n4) 9 1 % \n5) 8 0 +"
	};
	double[] answers = new double[]{
	    5.0, //add
	    -2.0, //subtract
	    108.0, //multiply
	    7.0 / 3 , //divide
	    4.0, //mod
	    9.0, //two operations: s, m
	    86.0, //four operations
	    8.0 //all operations
	};
	for (int i = 0; i < tests.length; i++){
	    if (eval(tests[i])==answers[i]){
		System.out.println("Test PASSED :D");
	    }
	    else{
		System.out.println("Test FAILED :(");
		System.out.println(errorMessages[i]);
	    }
		  System.out.println("\nCorrect answer: "+answers[i]+"\n   Your answer: " + eval(tests[i]) + "\n   Test case "+ i + ": " + tests[i] + "\n------------------------------------\n");
	}
    }
}
