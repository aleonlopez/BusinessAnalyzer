/**
 * Gets and stores the data of every business.
 * @author Alex Leon
 *
 */

public class Data {
	String data[];
	private boolean edad; // age of the business
	private boolean status; // status: open/closed
	private String zipcode;
	private String naicsCode;
	private String nCodeType;
	private String barrio;
	
	
	Data(String line) {
		data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		String[] fecha = data[8].split("/"); // getting the date that the business opened
		if (fecha.length == 3 && ((fecha[2].trim().equals("2022")) || (fecha[2].trim().equals("2023")))) { // getting the year the business opened to check if it opened within a year
			edad = true; // true if the business was opened in the past year
		} else {
			edad = false; // false if older than a year
		}
		status = data[9].equals(""); // will be empty if still open, else will not
		zipcode = data[14];
	    naicsCode = data[16];
	    nCodeType = data[17];
	    barrio = data[23];
	}
	
	public boolean getAge() {
		return edad;
	}
	public boolean getStatus() {
		return status;	
	}
	
	public String getZip() {
		return zipcode;	
	}
	
	public String getCode() {
		return naicsCode;	
	}
	
	public String getCodeType() {
		return nCodeType;		
	}
	
	public String getNeighborhood() {
		return barrio;
	}
}
