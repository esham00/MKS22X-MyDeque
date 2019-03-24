import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int size, start, end;
    @SuppressWarnings("unchecked")
    public MyDeque() {
	E[] DATA =(E[])new Object[20];
	data = DATA;
	size = 0;
	start = 0;
	end = 0;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
	E[] DATA = (E[])new Object[initialCapacity];
	data = DATA;
	size = 0;
	start = 0;
	end = 0;
    }
    public int size() {
	return size;
    }
    public String toString() {
	String output = "[";
	if (start == end && data[start] != null) {
	    output += data[start];
	}
	else if (start < end && data[end] != null && data[start] != null) {
	    for(int i = start; i <= end; i++) {
		if (i == end) {
		    output += data[i];
		} else {
		    output += data[i] + ", ";
		}
	    }
	} else if (data[start] != null && data[end] != null) {
	    for(int i = start; i < data.length; i++) {
		output += data[i] + ", ";
	    }
	    for(int i = 0; i <= end; i++) {
		if(i == end) {
		    output += data[i];
		} else {
		    output += data[i] + ", ";
		}
	    }
	}
	return output + "]";
    }
    public E getFirst() {
	if (data[start] == null) {
	    throw new NoSuchElementException();
	}
	return data[start];
    }
    public E getLast() {
	if (data[end] == null) {
	    throw new NoSuchElementException();
	}
	return data[end];
    }
    public E removeFirst() {
	if (data[start] == null) {
	    throw new NoSuchElementException();
	}
	E old = data[start];
	data[start ] = null;
	if (start == data.length-1) {
	    start = 0;
	}
	else {
	    start++;
	}
	size--;
	return old;
    }
    public E removeLast() {
	if (data[end] == null) {
	    throw new NoSuchElementException();
	}
	E old = data[end];
	data[end] = null;
	if(end == 0) {
	    end = data.length-1;
	} else {
	    end--;
	}
	size--;
	return old;
    }
    //adding to the first
    @SuppressWarnings("unchecked")
    public E addFirst(E element) {
	if (element == null) {
	    throw new NullPointerException();
	}
	E old = data[start];
	//beginning of adding, when the whole array is empty
	if (data[start] == null) {
	    data[start] = element;
	}
	//if the start is 0 and the end of the array is empty
	else if (start == 0 && data[data.length-1] == null) {
	    //otherwise add it to the end of the array
	    data[data.length-1] = element;
	    start = data.length-1;
	}
	//if the place where the start will be added is more than the end and empty
	else if (start-1 > end && data[start-1] == null) {
	    //add element there
	    data[start-1] = element;
	    start--;
	}
	else {
	    //this is if the start is more than the end and the unit behind it is not empty
	    //this inidicates the array is full and you must resize
	    resize();
	    data[data.length-1] = element;
	    start = data.length-1;
	}
	size++;
	return old;
    }
    @SuppressWarnings("unchecked")
    public E addLast(E element) {
	if (element == null) {
	    throw new NullPointerException();
	}
	E old = data[end];
	if (data[end] == null) {
	    data[end] = element;
	}
	//if it is less than the array length
	else if (end < data.length-1 && data[end+1] == null) {
	    if(data[end+1] == null) {
		data[end+1] = element;
		end++;
	    }
	}
	//if the beginning of the array is empty while end is at the last index of the array
	else if (data[0] == null)  {
	    data[0] = element;
	    end = 0;
	}
	//if not the array is full and you must resize
	else {
	    resize();
	    data[end+1] = element;
	    end++;
	}
	size++;
	return old;
    }
    @SuppressWarnings("unchecked")
    private void resize() {
	    E[] temp = (E[]) new Object[data.length * data.length];
	if (start < end) {
	    for(int i = 0; i < end-start; i++) {
		temp[i] = data[i+start];
	    }
	} else {
	    for(int i = 0; i < data.length-start; i++) {
	        System.out.println(data[i+start]);
	        System.out.println(temp[i]);
		System.out.println("Index: " + i);
		temp[i] = data[i+start];
	    }
	    for(int i = 0; i <= end; i++) {
		System.out.println(data[i]);
		System.out.println(temp[i+start]);
		System.out.println("Index: " + (i+start+1));
		temp[i+start+1] = data[i];
	    }
	}
	start = 0;
	end = size-1;
	data = temp;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
    	MyDeque a = new MyDeque(5);
	a.addLast(0);
	System.out.println(a.getFirst());
	System.out.println(a);
    	a.addFirst(1);
    	System.out.println(a.toString());
    	a.addFirst(0);
    	System.out.println(a.toString());
    	a.addFirst(3);
    	System.out.println(a.toString());
    	a.addLast(4);
    	System.out.println(a.toString());
    	a.addLast(5);
    	System.out.println(a.toString());
    	a.addLast(6);
    	System.out.println(a);
    	System.out.println(a.getFirst());
    	System.out.println(a.getLast());
    	a.removeFirst();
    	System.out.println(a.getFirst());
    	System.out.println(a.getLast());
    	System.out.println(a);
    	a.removeFirst();
    	System.out.println(a.getFirst());
    	System.out.println(a.getLast());
    	System.out.println(a);
    	a.removeFirst();
    	System.out.println(a.getFirst());
    	System.out.println(a.getLast());
    	System.out.println(a);
    	a.removeLast();
    	System.out.println(a.getFirst());
    	System.out.println(a.getLast());
    	System.out.println(a);
    	a.removeLast();
    	System.out.println(a.getFirst());
    	System.out.println(a.getLast());
    	System.out.println(a);
    	a.removeLast();
    	System.out.println(a.getFirst());
    	System.out.println(a.getLast());
    	System.out.println(a);
    }
}
