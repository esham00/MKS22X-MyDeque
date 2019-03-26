import java.util.*;
public class Calculator{
    public static double eval(String s){
        MyDeque<Double> values = new MyDeque<Double>();
	String[] st = s.split(" ");
	int j = 0;
	for(int i = 0; i < st.length; i++) {
	    try {
	        if(j % 2 == 1) {
		    System.out.println(Double.parseDouble(st[i]));	    
		    values.addLast(Double.parseDouble(st[i]));
		} else {	
		    System.out.println(Double.parseDouble(st[i]));	    
		    values.addFirst(Double.parseDouble(st[i]));
		}
		j++;
	    }
	    catch(NumberFormatException e) {
		Double a = values.getFirst();
		values.removeFirst();
		Double b = values.getLast();
		values.removeLast();
		char operation = st[i].charAt(0);
		System.out.println(a + " " + operation +" "  + b);
		if (operation == '+') {
		    values.addLast(a+b);
		} else if(operation == '*') {
		    values.addLast(a*b);
		} else if(operation == '/') {
		    values.addLast(a/b);
		} else if (operation == '-') {
		    values.addLast(a-b);
		}
		System.out.println(values.getLast());
		j = 0;
	    }
	}
	return values.getFirst();
    }
    public static void main(String[] args) {
	String a = "10 2.0 +";
	String b = "11 3 - 4 + 2.5 *";
	String c = "8 2 + 99 9 - * 2 + 9 -";
	System.out.println(Calculator.eval(c));
    }
}
