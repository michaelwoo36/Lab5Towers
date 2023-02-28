import java.util.Stack;

public class Tower {
	
	private Stack <Integer> tower1= new Stack <>();
	private Stack <Integer> tower2= new Stack <>();
	private Stack <Integer> tower3= new Stack <>();
	
	// Where disk is moved to.
	private int to;
	// Where disk is moved from.
	private int from;
	
	public Tower() {
		
		// Places disks onto tower.
		for(int i = 4; i >= 1; i--) {
			
			tower1.push(i);
		}
	}
	
	// If tower 3 is filled.
	public boolean check() {
		
		if(tower3.size() == 4 ) {
			
			return true;
		}
		else {
			
			return false;
		}
		
	}
	
	// Checks whether or not it is ok to move the top disk from the tower.
	public boolean safe(int stack) {
		
		if(stack == 1 && !(tower1.isEmpty()) && to != 1 && (tower2.isEmpty() || tower1.peek() < tower2.peek())) {
			
			return true;
			
		}
		
		else if(stack == 2 && !(tower2.isEmpty())) {
		
			if(from == 1 && (tower3.isEmpty() || tower2.peek() < tower3.peek())) {
			
				return true;
			}
			
			else if(from == 3 && (tower1.isEmpty() || tower2.peek() < tower1.peek())) {
			
				return true;
			}
			
			else if(from == 2 && (tower3.isEmpty() || tower1.isEmpty() || tower2.peek() < tower3.peek() || tower2.peek() < tower1.peek())) {
			
				return true;
			}
			
			else {
			
				return false;
			}
		}
		
		else if(stack == 3 && !(tower3.isEmpty()) && to != 3 && (tower2.isEmpty() || tower3.peek() < tower2.peek())) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
	
	
	// Moves disk from one tower to another.
	public void place(int stack) {
		
		if(stack == 1) {
	
			tower2.push(tower1.pop());
			
			// updating moves.
			to = 2;
			from = 1;
		}
		
		if (stack == 2) {
			
			if(from == 1) {
			
				tower3.push(tower2.pop());
				
				to = 3;
				from = 2;
			}
			
			else if(from == 3) {
			
				tower1.push(tower2.pop());
				
				to = 1;
				from = 2;
			}
			
			else if(from == 2) {
			
				if(tower1.isEmpty() || tower2.peek() < tower1.peek()) {
				
					tower1.push(tower2.pop());
					
					to = 1;
					from = 2;
				}
				
				if(tower3.isEmpty() || tower2.peek() < tower3.peek()) {
				
					tower3.push(tower2.pop());
					
					to = 3;
					from = 2;
				}
			}
		}
		
		if(stack == 3) {
		
			tower2.push(tower3.pop());
			
			to = 2;
			from = 3;
		}
	}
	
	// Prints out towers and their disks
	public void print() {
		
		System.out.println(tower1);
		System.out.println(tower2);
		System.out.println(tower3);
		System.out.println();
	}
	
	// Checks if any of the towers are able to be moved to and from.
	public boolean available() {
		
		if((!(tower3.isEmpty()) && to != 3) && (tower2.isEmpty() || tower3.peek() < tower2.peek())) {
			
			return true;
		}
	
		if((!(tower1.isEmpty()) && to != 1) && (tower2.isEmpty() || tower1.peek() < tower2.peek())) {
			
			return true;
		}
		
			
		if(!(tower2.isEmpty())) {
			
			if((from == 1) && (tower3.isEmpty() || tower2.peek() < tower3.peek())) {
			
				return true;
			}
			
			
			else if((from == 3) && (tower1.isEmpty() || tower2.peek() < tower1.peek())) {
			
				return true;
			}
			
			else if(from == 2 && (tower3.isEmpty() || tower1.isEmpty() || tower2.peek() < tower3.peek() || tower2.peek() < tower1.peek())) {
			
				return true;
			}
			
			else {
				
				return false;
			}
		}
		
		else {
			
			return false;
		}
	}
}




