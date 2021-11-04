package aggregation;

public class Point {

	private int x;
	private int y;

	Point(int x, int y) {

		this.x = x;
		this.y = y;

	}

	Point(Point other ) {

		this (other.x, other.y);

	}
	
    public void setX(int x) {
    	
    	this.x = x;
    }
    
    public void setY(int y) {
    	
    	this.y = y;
    }


	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean equals (Object obj) {

		if (this == obj) {
			return true;
		}

		if ( obj == null || this.getClass() != obj.getClass() ) { 
			return false;
		}

		Point other = (Point) obj;

		return 
				this.x == other.x &&
				this.y == other.y;


	}


}
