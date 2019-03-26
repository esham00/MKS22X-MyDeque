public class Calculator{
    public static double eval(String s){
        MyDeque<Integer> values = new MyDeque<Integer>();
	for(int i = 0; i < s.length(); i++) {
	    try {
	        if(i % 2 == 1) {
		    values.addLast(Integer.parseInt(s));
		} else {
		    values.addFirst(Integer.parseInt(s));
		}
	    }
	    catch(NumberFormatException e) {
		int a = values.getFirst();
		values.removeFirst();
		int b = values.getLast();
		values.removeLast();
		char operation = s.charAt(i);
		if (operation == '+') {
		    values.addLast(a+b);
		} else if(operation == '*') {
		    values.addLast(a*b);
		} else if(operation == '/') {
		    values.addLast(a/b);
		} else if (operation == '-') {
		    values.addLast(a-b);
		}
	    }
	}
    }
}
