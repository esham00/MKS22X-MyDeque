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
}
