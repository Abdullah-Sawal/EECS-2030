package model;

public class Monitor extends Follower{
	
	
	private boolean[] initialized;
	private int[] views;
	private int[] total;
	private int[] max;
	private double[] avg;
	
	private int counter = 0;
	

	public Monitor(String name, int MAX_FOLLOW) {

		super(name, MAX_FOLLOW);
		
		this.initialized = new boolean[MAX_FOLLOW];
		this.views = new int[MAX_FOLLOW];
		this.total = new int[MAX_FOLLOW];
		this.max = new int[MAX_FOLLOW];
		this.avg = new double[MAX_FOLLOW];
	}
	
	public void update (String channelName, int watchTime) {
		
		for ( int i = 0; i<this.noc; i++) {
			
			if (this.channels[i].getName().equals(channelName)) {
				
				initialized[i] = true;
				
				this.views[i] ++;
				
				this.total[i] += watchTime;
				
                if ( watchTime > this.max[i]) {
                	
                	this.max[i] = watchTime;
                	
                }
				
				this.avg[i] = (double) this.total[i] / this.views[i];
				
				
				
			}
			
		}
		
		
	}
	
	public String getChannels() {

		String s = "";

		s += "[";

		for (int i =0; i< this.noc; i++) {

			s += this.channels[i].getName();
			
			if(initialized[i] == true) {
				
				s += String.format(" {#views: %d, max watch time: %d, avg watch time: %.2f}",this.views[i],this.max[i],this.avg[i]);
				
				
			}

			if( i < this.noc -1) {

				s += ", ";

			}

		}

		s += "]";

		return s;


	}

	public String toString() {

		String s = "";

		if( this.noc == 0) {

			s = String.format("Monitor %s follows no channels.",this.onlyName);

		}

		else {


			s = String.format("Monitor %s follows %s.",this.onlyName ,this.getChannels());

		}
		return s;
	}

}
