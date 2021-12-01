package model;

public class Channel {

	private String name;

	private Follower[] followers;
	private int nof;

	private String[] videos;
	private int nov;

	private int maxFollowers;


	public Channel(String name, int MAX_FOLLOWERS, int MAX_VIDEOS) {

		this.name = name;

		this.followers = new Follower[MAX_FOLLOWERS];
		this.videos = new String[MAX_VIDEOS];

		this.maxFollowers = MAX_FOLLOWERS;
		this.nof = 0;
		this.nov = 0;

	}

	public String getName() {

		return this.name;

	}
	
	public int getnof() {
		
		return this.nof;
	}
	
	public int getnov() {
		
		return this.nov;
	}
	
	public String[] getVideosArray() {
		
		return this.videos;
	}
	
	public void follow(Follower f) {

		this.followers[this.nof] = f;
		this.nof ++;

		f.channels[f.noc] = this;
		f.noc ++;



	}


	public void unfollow( Follower f) {

		int count = 0;
		int count2 = 0; 

		Follower[] fs = new Follower[this.maxFollowers];
		Channel[]  cs = new Channel[f.getMaxFollow()];


		for (int i = 0; i<this.nof; i++) {

			if( this.followers[i] != f) {

				fs[count] = this.followers[i];
				count ++;
			} 
		}



		for (int i=0; i< f.noc; i++) {

			if (f.channels[i] != this) {

				cs[count2] = f.channels[i];
				count2 ++;
			}
		}

		for (int i=0; i<this.nof; i++) {
			if(this.followers[i] == f) {

				this.nof --;

			}

		}

		for (int i=0; i< f.noc; i++) {

			if (f.channels[i] == this) {
				f.noc --;

			}
		}
		this.followers = fs;
		f.channels = cs;

	}
	
	public void addWatchTime(int watchTime) {
		
		for ( int i = 0; i<this.nof; i++) {
			
			if (this.followers[i].type.equals("Monitor")) {
				
				this.followers[i].update(this.name,watchTime);
				
			}
			
		}
		
		
		
		
	}



	public void releaseANewVideo(String videoName) {

		this.videos[this.nov] = videoName;
		this.nov ++;


		if (this.nof > 0) {

			for (int i = 0; i<this.nof; i++) {

				if(this.followers[i].getType().equals("Subscriber")) {	
					this.followers[i].recommendedVideos[this.followers[i].nor] = videoName;
					this.followers[i].nor ++;
				}
			}
		}


	}

	public String getFollwers() {

		String s = "";


		s += "[";

		for(int i = 0; i < this.nof; i ++) {

			s += this.followers[i].getName();

			if( i < this.nof - 1) {

				s += ", ";

			}
		}

		s += "]";

		return s;


	}

	public String getVideos() {

		String s = "";

		s += "<";

		for (int i = 0; i < this.nov; i ++) {

			s += this.videos[i];

			if (i < this.nov -1) {

				s += ", ";
			}

		}

		s += ">";

		return s;

	}

	public String toString() {

		String s = "";

		if (this.nov == 0 && this.nof == 0) {

			s = String.format("%s released no videos and has no followers.", this.name);

		}

		else if (this.nof == 0) {

			s = String.format("%s released %s and has no followers.", this.name,this.getVideos());


		}

		else if (this.nov == 0) {

			s = String.format("%s released no videos and is followed by %s.", this.name, this.getFollwers());

		}

		else {

			s = String.format("%s released %s and is followed by %s.", this.name, this.getVideos(),this.getFollwers());

		}
		return s;

	}

}
