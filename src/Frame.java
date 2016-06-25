import java.util.Scanner;

/*
 *
 */
public class Frame {
	private int horPocketCount;
	private int vertPocketCount;
	/*
	private int jambCount;
	private int headCount;
	private int intermediateCount;
	private int sillCount;
	*/
	private double width;
	private double height;
	private Pocket[][] pockets;


	public Frame(double width, double height) {
		this.width = width;
		this.height = height;
		horPocketCount = 1;
		vertPocketCount = 1;

		Scanner console = new Scanner(System.in);

		// Ask user if frame contains multiple pockets
		System.out.print("Does this frame have multiple pockets? \nEnter y or n: ");
		String multiPocket = console.next();

		// Get frame pocket counts for uniform frames
		// TODO Logic to deal with frames of irregular pocket arrangements
		if(multiPocket.equalsIgnoreCase("y")) {
			horPocketCount = getPocketCounts("horizontal", console);
			vertPocketCount = getPocketCounts("vertical", console);
		}

		// Construct array to hold pockets
		pockets = new Pocket[horPocketCount][vertPocketCount];

		// TODO: Logic for pocket size generator with multipockets
		double pocketWidth;
		double pocketHeight;
		for(int i = 0; i < horPocketCount; i++) {
			for(int i = vertPocketCount - 1; i >= 0; i++) {
				pockets[i][j] = new Pocket(pocketWidth, pocketHeight);
			}
		}

	}

	private int getPocketCounts(String orientation, Scanner console) {
		return checkInt("How many " + orientation + " pockets in the frame? ", console);
	}

	private int checkInt(String message, Scanner console)

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public String toString() {

	}
}

// Yo this is a test of github!
// Yo this is also a test of github!
