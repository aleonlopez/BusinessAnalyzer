import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * Initializes the correct list to be utilized based on the input.
 * Reads the file and returns the summaries for the three possible summary types:
 * zip code summary, NAICS code summary, and a total summary.
 * @author Alex Leon
 */

public class Summary {
	List<Data> list; // initializing a list with type Data
	Iterator<Data> iterator; // initializing iterator with type Data
	HashSet<String> barrio; // HashSet for neighborhood
	HashSet<String> type; // HashSet for type of business
	HashSet<String> zips; // HashSet for zip codes
	Data negocio; // initializing business data
	
	int count;
	
	Summary(String file, String listType) {
		// differentiating the listType based off of command line
		if (listType.equals("AL")) { // ArrayList
			list = new ArrayList<Data>();
		} else if (listType.equals("LL")) { // LinkedList
			list = new LinkedList<Data>();
		} else {
			System.out.println("Invalid list type entered.");
			return;
		}
		
		try {
			Scanner scan = new Scanner(new File(file));
			String line = scan.nextLine();
			// skip first line
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				Data data = new Data(line);
				if (!data.getCode().equals("") || !data.getZip().equals("")) {
					list.add(data);
				} else {
					count++; // count of the businesses increments to get total businesses
				}
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Data> getData() {
		return list;
	}
	
	public void getZipSum(String zip) {
		int zipCount = 0;
		iterator = list.iterator();
		type = new HashSet<String>();
		barrio = new HashSet<String>();
		
		while (iterator.hasNext()) {
            negocio = iterator.next();
            if (negocio.getZip().equals(zip)) {
                type.add(negocio.getCodeType());
                barrio.add(negocio.getNeighborhood());
                zipCount++;
            }
        }
		System.out.println();
		System.out.println(zip + " Business Summary");
        System.out.println("Total Businesses: " + zipCount);
        System.out.println("Business Types: " + type.size());
        System.out.println("Neighborhoods: " + barrio.size());
        System.out.println();
	}
	
	public void getCodeSum(String code) {
		int codeCount = 0;
		iterator = list.iterator(); // new iterator
		zips = new HashSet<String>();
		barrio = new HashSet<String>();
		int objetivo = Integer.parseInt(code); // the target
		
		while (iterator.hasNext()) {
            negocio = iterator.next(); 
            String codigo = negocio.getCode(); // getting a business code
            String[] todos = codigo.split(" "); // split codes at spaces
            // loop through the codes and split the NAICS codes at "-"
            for (int i = 0; i < todos.length; i++) {
            	String[] grupo = todos[i].split("-");
            	if (!grupo[0].equals("")) {
            		int principio;
            		int fin;
            		if (grupo.length == 2) {
            			principio = Integer.parseInt(grupo[0]);
                		fin = Integer.parseInt(grupo[1]);
            		} else {
            			principio = Integer.parseInt(grupo[0]);
                		fin = Integer.parseInt(grupo[0]);
            		}
            		if (objetivo >= principio && objetivo <= fin) {
            			zips.add(negocio.getZip()); // adding zipcodes
            			barrio.add(negocio.getNeighborhood()); // adding the neighborhood
            			codeCount++;
            		}
            	}
            }
        }
		System.out.println();
		System.out.println("NAICS " + code + " Summary");
        System.out.println("Total Businesses: " + codeCount);
        System.out.println("Zip Codes: " + zips.size());
        System.out.println("Neighborhoods: " + barrio.size());
        System.out.println();
	}
	
	public void getSum() {
		iterator = list.iterator(); // new iterator
		
		int cerrado = 0; // number closed
		int nuevo = 0; // number new

		while (iterator.hasNext()) {
			negocio = iterator.next();
			count++;
			// checking the status of the business, open/closed
			if (!negocio.getStatus()) { // if closed
				cerrado++; // increment count of closed
			}
			
			if (negocio.getAge()) { // if new
				nuevo++; // increment count if new
			}
		}
		System.out.println();
		System.out.println("Total Businesses: " + count);
        System.out.println("Closed Businesses: " + cerrado);
        System.out.println("New Businesses In Last Year: " + nuevo);
        System.out.println();
	}
}
