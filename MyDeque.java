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
	E old = data[start];
	data[start ] = null;
	if (start == data.length-1) {
	    start = 0;
	    size--;
	}
	else {
	    start++;
	    size--;
	}
	return old;
    }
    public E removeLast() {
	E old = data[end];
	data[end] = null;
	if(end == 0) {
	    end = data.length-1;
	    size--;
	} else {
	    end--;
	    size--;
	}
	return old;
    }
    public E addFirst(E element) {
	int old = data[start];
	if(start < end) {
	    data[start-1] = element;
	    start--;
	} else if (start == 0 && data[data.length-1] == null) {
	    data[data.length-1] = element;
	    start = data.length-1;
	} else if (start > end) {
		data[start-1] = element;
		start--;
	    }
	}
	else {
	    resize();
	    data[data.length-1] = element;
	    start = data.length-1;
	}
	size++;
	return old;
    }
    public E addLast(E element) {
	E old = data[end];
	if (end < data.length-1) {
	    if(data[end+1] == null) {
		data[end+1] = element;
		end++;
	    }
	} else if (data[0] == null)  {
	    data[0] = element;
	    end = 0;
	} else {
	    resize();
	    data[end+1] = element;
	    end++;
	}
	return old;
    }
    private void resize() {
	E[] temp = new E[data.length * data.length];
	if (start < end) {
	    for(int i = 0; i < end-start; i++) {
		temp[i] = data[i+start];
	    }
	} else {
	    for(int i = 0; i < data.length-start; i++) {
		if(data[i] != null) {
		    temp[i] = data[i+start];
		}
	    }
	    for(int i = 0; i < end; i++) {
		temp[i] = data[i];
	    }
	}
	start = 0;
	end = size-1;
	data = temp;
    }
