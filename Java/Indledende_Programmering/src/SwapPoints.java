import java.awt.Point;


public class SwapPoints {
	public static void main(String[] args){
	Point p1 = new Point(5 , 2);
	Point p2 = new Point( -3 , 6);
	swapPoints ( p1 , p2 );
	System.out.println ("(" + p1 . x + ", " + p1 . y + ")");
	System.out.println ("(" + p2 . x + ", " + p2 . y + ")");
	}

	private static void swapPoints(Point p1, Point p2) {
		
		Point pTemp  = new Point();
		
		pTemp.x=p1.x;
		pTemp.y=p1.y;
		
		p1.x=p2.x;
		p1.y=p2.y;
		
		p2.x=pTemp.x;
		p2.y=pTemp.y;
	}
	
	
}
