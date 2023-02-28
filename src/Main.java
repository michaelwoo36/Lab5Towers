
public class Main {
	// no a - c or c -a
	// No repeating previous move
	
	public static void main(String[]args) {
		Tower tower = new Tower();
		System.out.println(solve(tower, 1));
	}
	
	private static boolean solve(Tower tower, int stack) {
		tower.print();
		if(tower.check()) {
			return true;
		}
		else {
			while(tower.available()) {
				if(tower.safe(stack)) {
					tower.place(stack);
					if(solve(tower, stack)) {
						return true;
					}
					
				}
				stack++;
				if(stack == 4) {
					stack = 1;
				}
			
			
			}
			
			return false;
		}
	}
}