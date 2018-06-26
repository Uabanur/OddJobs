/*
 * Concurrent Programming Lab 1
 */

import java.awt.*;

class Task extends Thread {

	TextField tf;  // Textfield to be used by this task

	public Task(TextField t) {
		tf = t;
	}

	void setMyText(String s) {
		// Write directly into textfield -- OK for AWT-components only!
		tf.setText(s);
	}
	
	public void run () {
		int  cols      = tf.getColumns();

		boolean useCPU = true;   // Set true to consume CPU-cycles

		int  basespeed =                10000;  // millisecs to do task
		int  variation =   (useCPU ? 0 : 60);  // Speed variation in percent

		long delay = Math.round(((Math.random() - 0.5)*variation/50 + 1.0) * basespeed/cols);

		String s = "";

		setMyText(s);
		W: while (s.length() < cols) {

			if (useCPU){
				for (int j = 0; j < 1000000*delay; j++) {
					if(interrupted())
					{
						s += "|";
						setMyText(s);
						break W;
					}
				}
			} else {
				try{
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					s += "|";
					setMyText(s);
					break;
				}
			}

			s = s + "#";
			setMyText(s);
		}
	}
}

public class TaskControl {

	static final int N = 10;   // Number of Textfields

	static int h = 0;         // Number of 'hello'-s

	static Task[] tasks = new Task[N];

	public static void main(String[] argv) {
		try {

			// Create window with N TextFields: (d.tf[0], ... , d.tf[N-1])
			TaskDisplay d = new TaskDisplay("Task Control", N);
			Task t = null;
			d.println("Type command (x to exit):");

			W: while (true) {                // Main command interpretation loop

				char c = d.getKey();

				switch (c) {

				case 'x': 
					break W;

				case 'h': 
					d.println("Hello " + (h++));
					break;

				case 't': 
					boolean newTask = false;
					for(int i = 0; i < N; i++)
					{
						if(tasks[i] == null || !tasks[i].isAlive())
						{
							tasks[i] = new Task(d.tf[i]);
							tasks[i].start();
							d.println("Started thread " + i);
							newTask = true;
							break;
						}

					}
					if(!newTask)
					{
						d.println("No task available");
					}
					
					break;

				default:
					if(Character.isDigit(c) && Character.getNumericValue(c)<N)
					{
						int index = Character.getNumericValue(c);
						if(tasks[index] != null && tasks[index].isAlive())
						{
							tasks[index].interrupt();
							d.println("Interrupting thread " + index + ": " + tasks[index].isInterrupted());

						} 
						else 
						{
							d.println("Thread " + index + " isn't running");
						}
					}
					else 
					{
						d.println("Don't know '" + c + "'");
					}
				}	

			}

			d.println("Program terminates");

			System.exit(0);

		} catch (Exception e) {System.out.println("Exception in Task Control: " + e); }
	}
}





