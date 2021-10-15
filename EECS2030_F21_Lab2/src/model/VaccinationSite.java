package model;



public class VaccinationSite {

	private String siteName;
	private int noDoses;

	private int counter;
	private String results;
	private String s;

	private int noPfizer;
	private int noAstra;
	private int noModerna;
	private int noJansen;

	private int limitOfDoses;

	private String[] data;
	private int nor;


	public VaccinationSite(String siteName, int limitOfDoses) {

		this.siteName = siteName;
		this.limitOfDoses = limitOfDoses;
		this.counter =0;
		this.nor =0;
		data = new String[limitOfDoses];
	}


	public void addDistribution(Vaccine v, int doses) 	throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException{

		this.noDoses += doses;
		results = "";

		if(!v.getManufacturer().equals("Moderna") && !v.getManufacturer().equals("Pfizer/BioNTech") && !v.getManufacturer().equals("Janssen") && !v.getManufacturer().equals("Oxford/AstraZeneca")) {

			throw new UnrecognizedVaccineCodeNameException("Expected exception not thrown");
		}
		
		else if ( this.noDoses > this.limitOfDoses) {
			
			throw new TooMuchDistributionException("Expected exception not thrown"); 
		}
		
		if(counter == 0) {
			
			results = String.format("%s has 0 available doses: <>", this.siteName);
			counter++;
		}
		
		if (counter == 1) {
			
			results = String.format("%s has %d available doses: <%s>", this.siteName, this.noDoses, getDoses(v,doses));
		}
	}
		public String getDoses(Vaccine v, int doses) throws UnrecognizedVaccineCodeNameException {
			
			s = "";
			
			if(v.getManufacturer().equals("Moderna")) {
				
				if(this.noModerna == 0) {
					this.nor ++;
					data[this.nor-1] = v.getManufacturer();
					
				}
				this.noModerna += doses;
			}
			
			else if(v.getManufacturer().equals("Pfizer/BioNTech")) {
				if(this.noPfizer == 0) {
					
					this.nor ++;
					data[this.nor-1] = v.getManufacturer();
				}
				
				this.noPfizer += doses;
				
			}
			
			else if (v.getManufacturer().equals("Oxford/AstraZeneca")) {
				
				if(this.noAstra == 0) {
					this.nor++;
					data[this.nor-1] = v.getManufacturer();
				}
				
				this.noAstra += doses;
			}
			else {
				throw new UnrecognizedVaccineCodeNameException(v.getCodeName());
			}
			
			for( int i=0; i<this.nor; i++) {
				String a = data[i];
				
				if(a.equals("Moderna")) {
					s += String.format("%d doses of Moderna", this.noModerna);
				}
				
				else if (a.equals("Pfizer/BioNTech")) {
					s += String.format("%d doses of Pfizer/BioNTech", this.noPfizer);
					
				}
				
				else if (a.equals("Oxford/AstraZeneca")) {
					s += String.format("%d doses of Oxford/AstraZeneca", this.noAstra);
					
				}
				if(i != this.nor-1 ) {
					s += ", ";
				}
				
			}
			 return s;
			
		}


	public int getNumberOfAvailableDoses() {
		return this.noDoses;
	}

	public int getNumberOfAvailableDoses(String codeName) {
		int total = 0;

		if(codeName.equals("mRNA-1273")) {

			total = this.noModerna;
		}

		if(codeName.equals("BNT162b2")) {

			total = this.noPfizer;
		}
		if(codeName.equals("AZD1222")) {

			total = this.noAstra;
		}
		if(codeName.equals("Ad26.COV2.S")) {

			total = this.noJansen;
		}
		return total;
	}
	
	public String toString() {
		
		if(noDoses == 0) {
			results = String.format("%s has 0 available doses: <>", this.siteName);
		}
		return results;
	}


}




















































