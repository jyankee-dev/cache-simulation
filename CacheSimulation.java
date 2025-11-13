import java.util.*;

public class CacheSimulation
{
    private static int RAM[] = new int[1024];
    
    private static void RAM_INIT() {
        for(int i = 0; i < 1024; ++i)
            RAM[i] = (int)(Math.random() * 500);
    }
    
    // your class and other methods definition starts here
    private static int[][] cache = new int[4][8]
	private static int[] TAG = new int[4]
    
	public static void 

    public static void main(String[] args) {
		RAM_INIT();

		System.out.println("Welcome to CSCI313 Cache Project");
		System.out.print("Enter 0 for LRU, Enter 1 for LFU, Enter 2 to EXIT: ");

		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		if(userInput == 2)
			return;
		// cache is a 2D array (4 rows -> cache lines, 8 columns -> block contents)

		

		while(true) {
		    System.out.print("Input byte address (in decimal integer format) CPU tries to visit: ");
			userInput = input.nextInt();

		    
		} // while
	} // main
}