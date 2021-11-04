package composition;



public class Line {

	private Point p1;
	private Point p2;

	Line(Point p1, Point p2) {

		this.p1 = p1;
		this.p2 = p2;


	}
	
	
	Line ( Line other) {
		
		this (other.p1, other.p2);
		
	}
	

	public Point getStart() {

		Point p = new Point (p1.getX(), p1.getY());

		return p;

	}
	
	
	public Point getEnd() {

		Point p = new Point (p2.getX(), p2.getY());

		return p;

	}
	
	
	public boolean equals (Object obj) {

		if (this == obj) {
			return true;
		}

		if ( obj == null || this.getClass() != obj.getClass() ) { 
			return false;
		}

		Line other = (Line) obj;

		return 
				this.p1 == other.p1 &&
				this.p2 == other.p2;


	}
	

}
