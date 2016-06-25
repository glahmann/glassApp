
public class Glass {
	//Secret Message

	private double length;
	private double width;
	
	public Glass(double length, double width){
		this.length = length + .75;
		this.width = width + .75;
	}
	
	public static void main(String args) {
		System.out.println(Frame.getWidth());
	}
}
