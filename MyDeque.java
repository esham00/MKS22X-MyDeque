public class MyDeque<E>{
    private E[] data;
    private int size, start, end;
    public MyDeque() {
	data = new E[20];
	size = 0;
    }
    public MyDeque(int initialCapacity) {
	data = new E[initialCapacity];
	size = 0;
    }
    public int size() {
	return size;
    }
    public String toString() {
	String output = "[";
	if (start < end) {
	    for(int i = start; i < end; i++) {
		if (i == end-1) {
		    output += data[i];
		} else {
		    output += data[i] + ", ";
		}
	    }
	} else {
	    for(int i = start; i < data.length; i++) {
		output += data[i];
	    }
	    for(int i = 0; i < end; i++) {
		if(i == end-1) {
		    output += data[i];
		} else {
		    output += data[i] + ", ";
		}
	    }
	}
	return output + "]";
    }
    public E getFirst() {
	return data[start];
    }
    public E getLast() {
	return data[end];
    }
    public E removeFirst() {
	if (start == data.length-1) {
	    start = 0;
	}
	else {
	    start++;
	}
	return data[start-1];
    }
    public E removeLast() {
	end--;
	return data[end+1];
    }
    public E addLast(E element) {
	if (end < data.length-1) {
	    data[end+1] = element;
	} else {
	    if (end 
    public
