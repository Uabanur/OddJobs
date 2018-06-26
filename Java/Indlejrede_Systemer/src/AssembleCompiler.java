import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AssembleCompiler {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("/Users/Roar/Dropbox/Indlejrede Systemer/r/A3/Gezel/uPandCoProgram.txt"));
		PrintStream print = new PrintStream(new FileOutputStream("/Users/Roar/Dropbox/Indlejrede Systemer/r/A3/Gezel/uPandCoMachineCode.txt"));
		int counter = 0;

		Loop: while (s.hasNextLine()) {

			String[] tokens = s.nextLine().split("\\s+");
			System.out.println(tokens[0]);

			if (tokens[0].equals("//"))
				break Loop; // Stop reading when you reach the comments.

			if (tokens[0].isEmpty())
				continue Loop; // Skip black space between commands.
			String hexCounter = Integer.toString(++counter,16);
			System.out.print(hexCounter + "\t");
			print.append(hexCounter + "\t");

			String UpCode = tokens[0];
			String instruction = "";
			if (UpCode.equals("NOP")){
			
			}else if (UpCode.equals("MOV")) {
				instruction += "0001";
				instruction += getAddress(tokens[1]);
				instruction += "000";
				instruction += getAddress(tokens[2]);

			} else if (UpCode.equals("ADD")) {
				instruction += "0010";
				instruction += getAddress(tokens[1]);
				instruction += getAddress(tokens[2]);
				instruction += getAddress(tokens[3]);

			} else if (UpCode.equals("ADD1")) {
				instruction += "0011";
				instruction += getAddress(tokens[1]);
				instruction += "000";
				instruction += getAddress(tokens[1]);

			} else if (UpCode.equals("SUB")) {
				instruction += "0100";
				instruction += getAddress(tokens[1]);
				instruction += getAddress(tokens[2]);
				instruction += getAddress(tokens[3]);

			} else if (UpCode.equals("BTS5")) {
				instruction += "0101";
				instruction += getAddress(tokens[1]);
				instruction += "000";
				instruction += getAddress(tokens[2]);

			} else if (UpCode.equals("INLP")) {
				instruction += "0110";
				instruction += getAddress(tokens[1]);
				instruction += "000";
				instruction += getAddress(tokens[1]);

			} else if (UpCode.equals("LOAD")) {
				instruction += "0111";
				instruction += getAddress(tokens[1]);
				instruction += "000";
				instruction += getAddress(tokens[2]);
				
			} else if (UpCode.equals("LOADC")) {
				instruction += "1111";
				instruction += getAddress(tokens[1]);
				instruction += "000";
				instruction += getAddress(tokens[2]);

			} else if (UpCode.equals("SAVEC")) {
				instruction += "1000";
				instruction += getAddress(tokens[1]);
				instruction += getAddress(tokens[2]);

			} else if (UpCode.equals("SAVEX")) {
				instruction += "1001";
				instruction += getAddress(tokens[1]);
				instruction += getAddress(tokens[2]);
				
			} else if (UpCode.equals("FLTR")) {
				instruction += "1101";
				instruction += "000";
				instruction += getAddress(tokens[1]);
				instruction += getAddress(tokens[2]);
			
			} else if (UpCode.equals("COPR")) {
				instruction += "1011";
				instruction += "000";
				instruction += getAddress(tokens[1]);
				instruction += getAddress(tokens[2]);

			} else if (UpCode.equals("JMP")) {
				instruction += "1010";
			}

			// Insert zeroes to make 20 bit.
			for (int i = instruction.length(); i < 16; i++) {
				instruction += "0";
			}
			
			int decimal = Integer.parseInt(instruction,2);
			String hexStr = Integer.toString(decimal,16);
			
			print.append(hexStr + "\n");
			System.out.println(hexStr);
			System.out.println(instruction);
			System.out.println();

		}
	}

	private static String getAddress(String reg) {
		if (reg.equals("R0"))
			return "000";
		else if (reg.equals("R1"))
			return "001";
		else if (reg.equals("R2"))
			return "010";
		else if (reg.equals("R3"))
			return "011";
		else if (reg.equals("R4"))
			return "100";
		else if (reg.equals("R5"))
			return "101";
		else if (reg.equals("R6"))
			return "110";
		else if (reg.equals("R7"))
			return "111";
		else
			return "NOP";
	}
}
