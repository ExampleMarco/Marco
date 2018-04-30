package it.uniba.main;

import java.util.Scanner;

import it.uniba.main.Sprint1;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 * 
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

	/**
	 * Private constructor. Change if needed.
	 */
	private AppMain() {

	}

	static Scanner input;
	static Sprint1 s;
	private final static int MINLENGHT = 0;
	private final static int MAXLENGHT = 2;
	
	/**
	 * This is the main entry of the application.
	 *
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(final String[] args) {
		
			if((args.length>MINLENGHT)&&(args.length<=MAXLENGHT)){
					if(args[0].equals("issue1")&&(args.length<MAXLENGHT)) {
						createPathZip();
						s.issue1();
					}
					else if(args[0].equals("issue2")&&(args.length<MAXLENGHT)) {
						createPathZip();
						s.issue2();
					}	
					else if(args[0].equals("issue3")&&(args.length<MAXLENGHT)) {
						createPathZip();
						s.issue3();
					}
					else if(args[0].equals("issue4")&&(args.length==MAXLENGHT)) {
						createPathZip();
						s.issue4(args[1]);
					}else {
						s = new Sprint1();
						s.issue5();
					}
			}
			else{
				s = new Sprint1();
				s.issue5();
				}
		}	
			
		
	
	static String createPathZip () {
		String path;
		System.out.println("Inserire il percorso assoluto in cui e' presente lo zip:");
		input = new Scanner(System.in);
		path = input.nextLine();
		System.out.println("Il percorso selezionato e': "+path);
		s = new Sprint1(path);
		input.close();
		return path;
	}

}
