package model;

public class Vaccine {
	
	private String codeName;
	private String type;
	private String manufacturer;
	
	
	public Vaccine (String codeName, String type, String manufacturer) {
		
		this.codeName = codeName;
		this.type = type;
		this.manufacturer = manufacturer;
		
	}
	
	public String getCodeName() {
		
		return this.codeName;
	}
	
	public String getType() {
		
		return this.type;
	}
	
	public String getManufacturer() {
		
		return this.manufacturer;
	}
	
	public String toString() {
		
		String s ="";
		
		if (this.manufacturer.equals("Moderna") || this.manufacturer.equals("Pfizer/BioNTech") ||this.manufacturer.equals("Janssen") ||this.manufacturer.equals("Oxford/AstraZeneca")) {
		
		s = String.format("Recognized vaccine: %s (%s; %s)",
				this.codeName, this.type, this.manufacturer);
		}
		
		else {
			
			s = String.format("Unrecognized vaccine: %s (%s; %s)",
					
					this.codeName,this.type,this.manufacturer);
		}
		
		return s;

	}
	
}
