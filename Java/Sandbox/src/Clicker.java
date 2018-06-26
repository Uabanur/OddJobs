import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Clicker {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		Robot bot = new Robot();
		int clicks = Integer.parseInt(args[0]);
		System.out.println("Hello");
		int sleep = Integer.parseInt(args[1]);
		for(int i = 0; i < clicks; i++){
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
	    Thread.sleep(sleep);
		}
		
	}

}
