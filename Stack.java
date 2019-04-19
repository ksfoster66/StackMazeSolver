import java.util.Arrays;

public class Stack<E>{
	
	@SuppressWarnings("unchecked")
	private E[] stack = (E[]) new Object[100];//Creation of array, default size of 100
	
	
	private int index = -1;//Declare and initialize to -1, for empty
	
	public void push(E o){//Increment index and add to stack
		if (index == stack.length - 1) extendArray();//If array is full extend array
		index++;
		stack[index] = o;		
	}
	
	public E pop() throws RuntimeException{//Gets top item from stack and decrement index
		if( index >= 0 ){
			E o =stack[index];
			index--;
			return o;
		}
		else throw new RuntimeException();//If stack is empty, throw exception
	}
	
	public E peek() throws RuntimeException{//Returns top item without modifying the index
		if( index >= 0 ){
			return stack[index];
		}
		else throw new RuntimeException();//If empty, throw exception
	}
	
	public int search(E o){//Searches for item and returns distance from top
		for (int i =0; i < stack.length; i++){
			if (o.equals(stack[i])) return (stack.length - i);
		}
		return -1;//If empty return -1
	}
	
	public boolean is_empty(){//If empty return true
		if (index >= 0) return false;
		else return true; 
	}
	
	public int length(){
		return index +1;
	}
	
	private void extendArray(){//Extends the size of the array by 100
		
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Object[stack.length + 100];
		System.arraycopy(stack, 0, temp, 0, stack.length);
		stack = temp;
	}
	
	

}
