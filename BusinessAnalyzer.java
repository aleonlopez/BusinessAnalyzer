import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Reads the input and outputs the correct information for the given command.
 * @author Alex Leon
 */

public class BusinessAnalyzer {
	
	public static void main(String[] args) {
		String file = args[0];
		String listType = args[1];
		
		Scanner scan = new Scanner(System.in);
		Summary summary = new Summary(file, listType);
		ArrayDeque<String> ordenes = new ArrayDeque<String>();
		
		while (true) {
			System.out.print("Command: ");
			String orden = scan.nextLine().toLowerCase();
			String[] historia = orden.split(" ");
			
			if (historia.length == 3 && orden.contains("zip")) {
				// get the zip code summary and add the command to the ArrayDeque
				summary.getZipSum(historia[1]); // getting the zip code from index 1
				ordenes.add(orden);
			} else if (historia.length == 3 && orden.contains("naics")) {
				// get the NAICS code and add the command to the ArrayDeque
				summary.getCodeSum(historia[1]); // getting the code from index 1
				ordenes.add(orden);
			} else if (orden.equals("summary")) {
				// get the summary and add the command to the ArrayDeque
				summary.getSum();
				ordenes.add(orden);
			} else if (orden.equals("history")) {
				//ArrayDeque for the commands the user has entered
				System.out.println();
				Iterator<String> iterator = ordenes.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				System.out.println();
			} else if (orden.equals("quit")) {
				break;
			}
			else {
				System.err.println("Invalid command given");
			}
		}
		scan.close();
	}
}
