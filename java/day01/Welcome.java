package day01;

import utils.Mu;

public class Welcome {
	/**
	 * 주석을 담
	 * @param args
	 */

	public static void main(String[] args) {
		System.out.println("Welcome to my house");
		System.out.println("\033[91m" + "Welcome to my house" + "\033[0m");
		System.out.println("\033[1m" + "Welcome to my house" + "\033[0m");
		System.out.println("Welcome to \n\n my house");
		System.out.println("Welcome to my palace");
		Mu.p("Welcome");
		Mu.p("My name is" + Mu.RED + "NONAME" + Mu.END);
		
		
	}
}
