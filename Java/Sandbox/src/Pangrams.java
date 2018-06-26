import java.io.*;
import java.util.*;

public class Pangrams {

	public static void main(String[] args) {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		sc.close();
		boolean check = true;
		for (int i = 0; i < alphabet.length(); i++) {
			check &= input.toLowerCase().contains("" + alphabet.charAt(i));
		}

		if (check)
			System.out.println("pangram");
		else
			System.out.println("not pangram");

	}
}