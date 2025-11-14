// Jared Yankee
// Final Project
// 11/13/2025
import java.util.*;

public class CacheSimulation
{
    private static int RAM[] = new int[1024];
	
	private static final int CACHE_LINES = 4;
	private static final int BLOCK_SIZE = 8;
	private static final int TAG_LENGTH = 7;
	private static final int ADDR_LENGTH = 10;
    private static void RAM_INIT() {
        for(int i = 0; i < 1024; ++i)
            RAM[i] = (int)(Math.random() * 500);
    }
    
    // your class and other methods definition starts here
    
	// cache is a 2D array (4 rows -> cache lines, 8 columns -> tag at index == 0, then block contents)
	private static int[][] cache = new int[4][9];
    
	private static int[] LRU_TRACKER = new int[4]; // iterates each endex for every operation (0, 1, 2, 3)
	private static int[] LFU_TRACKER = new int[4]; // iterates index associated with a cache hit

	// Computation for tag and block elements

	/**
	 * @function calculateTAG
	 * 
	 * @param input - integer representatio nof the number being accessed
	 * 
	 * java does math floor automatically so we just have to calculate input / BLOCK_SIZE
	 * i.e. (0 indexed)
	 * 
	 * 7 is in the first block, 7 / 8 = 0, 
	 * 8 is in the second block: 8 / 8 = 1
	 */
	public static String calculateTAG (int input) {
		 // java does math.floor on integer automatically WOHOO
		int block = input / BLOCK_SIZE;
		return decimalToBinary(block);
		

	}
	public static String[] calculateBlock (TAG) {
		String[] block = new String[8];
		for (int i = 0; i < 8; i++) {
			block[i] = TAG+=decimalToBinary(i);
		}
		return block;
	}
	// decimal to binary helper
	public static String decimalToBinary (int decimal) {
		if (decimal == 0) return 0;
		String str = "";
		while (decimal > 0) {
			str = ((decimal % 2 == 1) ? "1" : "0") + str;
			decimal = decimal / 2;
		}
		
		return str
	}
	// adds spacing where necessary
	public static String formatSpacing (String type, String str) {
		int max = (type.toLowerCase() == "tag") ? TAG_LENGTH : ADDR_LENGTH;
		// add leading zeroes
		while (str.length < TAG_LENGTH) {
			str = "0"+str;
		}

		// return formatted string with spaces added
		if (type.toLowerCase() == "tag") {
			return String.format("%s $s", str.substring(0, 1), str.substring(1));
		} else if (type.toLowerCase() == "address") {
			return String.format("%s %s %s", str.substring(0, 2), str.substring(2, 6), str.substring(6));
		}
	}
	/**
	 * cache tries 
	 */
	public static void cache (TAG, block, method) {

	}

	public static void LRU () {


	}
	public static void LFU () {

	}
	/**
	 * @function toString
	 * 
	 * prints a stringified representation of the cache
	 * 
	 */
	public static void toString () {
	    String str = "|";
		for (int i = -1; i < cache.length; i++) {
			for (int j = 0; j < cache[0].length; j++) {
				if (i == -1) {
					if (j == 0) {
						str+=padString("TAG");
					} else {
						str+=String.format("| Cache block [%s] ", j);
					}
				}
				else {
				    String block = String.format("%s", cache[i][j] == 0 ? "---" : cache[i][j]);
					str+=String.format("| %s  ", padString(block));
				}
			}
			str+=" |\n";
		}
		System.out.println(str);
	}
	public static String padString (String value) {
		final int target = 14;
        String str = "";
		int missing = target - value.length();
		for (int i = 0; i <= missing; i++) {
			str+=" ";
			if (i == missing / 2) {
				str+=value;
			}
		}
		return str;
	}
    public static void main(String[] args) {
		RAM_INIT();

		System.out.println("Welcome to CSCI313 Cache Project");
		System.out.print("Enter 0 for LRU, Enter 1 for LFU, Enter 2 to EXIT: ");
		
		String method = '';

		Scanner input = new Scanner(System.in);
		int userInput = input.nextInt();
		if(userInput == 2)
			return;
		
		if (userInput == 1) {
			method = 'lfu';
		}

		if (userInput == 0) {
			method = 'lru';
		}

		if (method == '') {
			System.out.prinln("Invalid input. Terminating program");
		}

		
		// Im not really going to extrapolate just so this douesn't turn into funcitons all over the place.
		// most of the main procedure will be done here
		while(true) {
		    System.out.print("Input byte address (in decimal integer format) CPU tries to visit: ");
			userInput = input.nextInt();
			
			// used to break out of the availability loop early
			boolean lineAvailable = false;

			// get TAG and block
			int TAG = calculateTAG(value);
			int[] block = calculateBlock(TAG);

			int targetLine = -1;
			// tries to find availability in cache
			while (i < CACHE_LINES && targetLine == -1) {
				if (cache[i][0] == 0) {
					targetLine = i;
				}
			}

			if (targetLine == -1) {
				if (method == "lru") {
					targetLine = LRU();
				}
				if (method == "lfu") {
					targetLine = LFU();
				}
			}
			
		    
		} // while
	} // main
}