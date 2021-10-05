package model;

import model.Log;

public class App {

	private String name;

	private Log[] updates;
	private int nou;
	private final int MAX_UPDATES = 20;

	private int[] ratings;
	private int nor;

	public App(String name, int MAX_RATINGS) {

		this.name = name;
		this.updates = new Log[MAX_UPDATES];
		this.nou = 0;

		this.ratings = new int[MAX_RATINGS];
		this.nor = 0;

	}


	public void releaseUpdate(String version) {

		Log nu = new Log(version);
		this.updates[this.nou] = nu;
		this.nou++;

	}

	public void submitRating(int score) {

		this.ratings[nor] = score;
		this.nor ++;
	}


	public String getName() {

		return this.name;
	}

	public String getWhatIsNew() {

		String s = "";

		if(this.nou == 0) {

			s= "n/a";
		}
		else {
			s = this.updates[nou -1].toString();

		}
		return s;
	}

	public Log[] getUpdateHistory() {

		Log[] uh = new Log[this.nou];

		for ( int i = 0; i< this.nou; i++) {

			uh[i] = this.updates[i];
		}
		return uh;
	}

	public Log getVersionInfo(String version) {

		Log result = null;
		Boolean foundResult = false;

		for ( int i = 0; i < this.nou && !foundResult ; i++) {


			if ( this.updates[i].getVersion().equals(version)) {

				result = this.updates[i];
				foundResult = true;

			}
		}

		return result;
	}


	public String getRatingReport() {

		String report = "";

		if (this.nor == 0 ) {

			report = "No ratings submitted so far!";
		}

		else {
			
			int numberOf5 = 0;
			int numberOf4 = 0;
			int numberOf3 = 0;
			int numberOf2 = 0;
			int numberOf1 = 0;

			for( int i =0; i<nor; i++) {

				int score = this.ratings[i];
				

				if(score == 5) {
					numberOf5 ++;
				}
				else	if(score == 4) {
					numberOf4 ++;
				}
				if(score == 3) {
					numberOf3 ++;

				}
				if(score == 2) {
					numberOf2 ++;

				}
				else if (score == 1) {

					numberOf1 ++;
				}
			}
			
			
			String avgS = this.getFormatedAvg();
			
			report = String.format("Average of %d ratings: %s (Score 5: %d, Score 4: %d, Score 3: %d, Score 2: %d, Score 1: %d)",
					 this.nor, avgS, numberOf5, numberOf4, numberOf3, numberOf2, numberOf1);
		}
		
		return report;

	}
	
	private String getFormatedAvg() {
		
		int total = 0;
		
		for( int i =0; i<nor; i++) {

			int score = this.ratings[i];
			total += score;
		}
			
			double avg = ((double) total) / this.nor;
			String avgS = String.format("%.1f", avg);
			
			return avgS;

			
		}
		
		

	public String toString() {
		
		String avgS = "";
		if ( this.nor == 0){
			avgS = "n/a";
		}
					
			else {
				avgS = this.getFormatedAvg();
			}
	
		return String.format("%s (Current Version: %s; Average Rating: n/a)"
				, this.name, this.getWhatIsNew().toString(), avgS);

	}

}




