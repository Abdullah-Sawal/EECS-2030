package composition;



public class LineCollector {
	
	private Line[] lines;
	private int nol;
	
	
	LineCollector() {
		
		this.lines = new Line[5];
		
	}
	
	LineCollector(LineCollector other) {
		
		this.lines = new Line[5];
		
		for (int i= 0; i < other.nol; i ++) {

			this.lines[i] = other.lines[i];
		}
		
		this.nol = other.nol;

		
		
	}
	
	
	public void addLine(Line l) {
		
		
        
		this.lines[this.nol] = l;
		this.nol ++;

	}
	
	public Line getLineAt(int num) {
		
		
        Line l = new Line(this.lines[num]);
        return l;
		


	}
	
	public Line[] getLines() {


		Line[] l = new Line[this.nol];

		for ( int i = 0; i < this.nol; i ++) {


			l[i] = new Line(this.lines[i]);

		}


		return l;

	}
	
	public int numberOfEqualLines (Line l) {

		int result = 0;
		for ( int i =0; i<this.nol; i ++) {

			if (this.lines[i].equals(l)) {
				result ++;
			}

		}

		return result;


	}


	public boolean equals(Object obj) {

		if ( this == obj) {	
			return true;
		}
		if ( obj == null || this.getClass() != obj.getClass() ) { 
			return false;
		}

		LineCollector other = (LineCollector) obj;


		boolean equal = this.getLines().length == other.getLines().length;
		
		if (equal) {

		for (int i = 0; i< this.nol ; i++) {
			
			
            Line l = this.lines[i];
			equal = this.numberOfEqualLines(l) == other.numberOfEqualLines(l);
		}


		}

		return equal;



	}
	

}
