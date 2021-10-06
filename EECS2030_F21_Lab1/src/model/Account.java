package model;

public class Account {

	private String status;
	private String name;
	private AppStore store;

	private String[] namesOfDownloadedApps;
	private int noa;

	public Account(String name, AppStore appStore) {

		this.name = name;
		this.store = appStore;

		this.namesOfDownloadedApps = new String[50];
		this.noa = 0;

		this.status = String.format("An account linked to the %s store is created for %s.",
				appStore.getBranch(), name);


	}

	public void download(String nameOfApp) {

		boolean nameExists = false;

		for ( int i = 0; i< this.noa && !nameExists; i++) {

			if ( this.namesOfDownloadedApps[i].equals(nameOfApp)) {
				nameExists = true;

			}
		}
		if (nameExists) {
			this.status = String.format("Error: %s has already been downloaded for %s.",
					nameOfApp, this.name);

		}

		else {

			this.namesOfDownloadedApps[this.noa] = nameOfApp;
			this.noa ++;
			this.status = String.format("%s is successfully downloaded for %s."
					, nameOfApp , this.name);
		}

	}

	public void submitRating( String nameOfApp,int score) {

		boolean nameExists = false;

		for ( int i = 0; i< this.noa && !nameExists; i++) {

			if ( this.namesOfDownloadedApps[i].equals(nameOfApp)) {
				nameExists = true;

			}
		}

		if (nameExists) { 





			this.getApp(nameOfApp).submitRating(score);

			this.status = String.format("Rating score %d of %s is successfully submitted for GoodNotes 5.",
					score, this.name);
		}



		else {

			this.status = String.format("Error: %s is not a downloaded app for %s." ,
					nameOfApp, this.name);

		}
	}

	public void switchStore(AppStore store) {

		this.store = store;
		this.status = String.format("Account for %s is now linked to the %s store.",
				this.name, this.store.getBranch());

	}

	public void uninstall(String nameOfApp) {

		boolean nameExists = false;

		for ( int i = 0; i< this.noa && !nameExists; i++) {

			if ( this.namesOfDownloadedApps[i].equals(nameOfApp)) {
				nameExists = true;


				if( nameExists ) {


					namesOfDownloadedApps[i] = null;

					namesOfDownloadedApps[i] = namesOfDownloadedApps[i+1];
					namesOfDownloadedApps[this.noa] = null;
					this.noa --;

				}
			} 
		}
		if(nameExists) {
			this.status = String.format("%s is successfully uninstalled for %s.",
					nameOfApp, this.name);

		}

		else {

			this.status = String.format("Error: %s has not been downloaded for %s.",
					nameOfApp, this.name);
		}
	}


public String[] getNamesOfDownloadedApps() {

	String[] names = new String[this.noa];

	for ( int i = 0; i< this.noa; i++) {

		names[i] = namesOfDownloadedApps[i];
	}
	return names;
}

public App[] getObjectsOfDownloadedApps() {

	App[] apps = new App[this.noa];

	for (int i = 0; i < this.noa; i++) {

		String nameOfApp = this.namesOfDownloadedApps[i];
		App app = this.getApp(nameOfApp);
		apps[i] = app;

	}

	return apps;


}

private App getApp(String nameOfApp) {

	return this.store.getApp(nameOfApp);
}



public String toString() {
	return this.status;

}

}
