// Michael Woo
// Lab 5: Towers of Hanoi
// CS 145
// Eclipse
// This program solves the towers of Hanoi. The rules of the program are that no move can be rewinded, disk moved back to where it came from, 
// and no moves from tower 1 to tower 3. 

public class Main {
	
	public static void main(String[]args) {

		Tower tower = new Tower();
		
		System.out.println(solve(tower, 1));
	}
	
	// Recursive Method
	private static boolean solve(Tower tower, int stack) {
		tower.print();
		
		if(tower.check()) {
		
			return true;
		}
		
		else {
			
			// Checks for available tower
			while(tower.available()) {
				
				// Checks if moving to the tower is legal
				if(tower.safe(stack)) {
					
					// places disk onto tower
					tower.place(stack);
					
					if(solve(tower, stack)) {
					
						return true;
					}
				}
				
				// switches through different towers.
				stack++;
				
				if(stack == 4) {
				
					stack = 1;
				}
			}
			
			return false;
		}
	}
}