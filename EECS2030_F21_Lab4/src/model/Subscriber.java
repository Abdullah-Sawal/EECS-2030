package model;  

public class Subscriber extends Follower {

	public Subscriber(String name, int MAX_CHANNELS, int MAX_RECOMMENDED) {

		super(name, MAX_CHANNELS, MAX_RECOMMENDED);

	}


	public void watch(String name , int time) {
		
		for (int i = 0; i<this.noc; i++) {
			
			for (int j = 0; j < this.channels[i].getnov(); j++) {
				
				
				if (this.channels[i].getVideosArray()[j].equals(name)) {
					
					
					this.channels[i].addWatchTime(time);
					
				}
				
			}
			
			
		}

	
			}

	public String toString() {

		String s = "";

		if( this.noc == 0 && this.nor == 0) {

			s = String.format("Subscriber %s follows no channels and has no recommended videos.",this.onlyName);

		}

		else if (this.nor == 0) {

			s = String.format("Subscriber %s follows %s and has no recommended videos.",this.onlyName ,this.getChannels());

		}

		else  {

			s = String.format("Subscriber %s follows %s and is recommended %s.",this.onlyName ,this.getChannels(),this.getRecommendedVideos());

		}
		return s;

	}

}
