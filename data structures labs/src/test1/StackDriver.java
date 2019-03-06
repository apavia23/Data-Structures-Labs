package test1;

/* I have no idea how I would go about creating a stack using linked lists
 * I don't understand where or why I would use an interface for this
 * So I made what is essentially a linked list class disguised as a stack (thinking it over and maybe this is even what you meant for us to do? even then, still why interface anything?)
 * what I made works as a stack implement so I'm just hoping for a little credit even though I don't think it's at all how you wanted it done
 */

public class StackDriver {

	public static void main(String[] args) {
		Stack<Integer> data = new Stack<Integer>();
		
		//System.out.println(data.peek());//Empty Stack Exception
		//System.out.println(data.pop()); //Empty Stack Exception
		System.out.println(data.empty()); //should be true
		data.push(3);
		System.out.println(data.peek()); //should be 3
		System.out.println(data.pop());  //should be 3
		System.out.println(data.empty());//should be true
		data.push(4);
		data.push(5);
		data.push(6);
		System.out.println(data.peek()); //should be 6
		System.out.println(data.empty());//should be false
		System.out.println(data.pop());  //should be 6
		System.out.println(data.peek()); //should be 5
		System.out.println(data.pop());  //should be 5
		System.out.println(data.peek()); //should be 4
		System.out.println(data.pop());  //should be 4
		//System.out.println(data.peek()); //Empty Stack Exception
		System.out.println(data.empty());// should be true
	}

}
