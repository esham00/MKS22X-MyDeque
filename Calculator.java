public class Calculator{
    public static double eval(String s){
	MyDeque<Character> operators = new MyDeque<Character>();
        MyDeque<Integer> values = new MyDeque<Integer>();
	for(int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == ) {
		operators.addLast(charAt(i));
	    } else if (s.charAt(i) == ) {
		values.addLast(charAt(i));
	    }
	}
	int a = values.getFirst();
	values.removeFirst();
	int b = values.getFirst();
	values.removeFirst();
	char operation = operators.getFirst();
	
    }
}
