package model;

// Template of a collection f entries.

public class RefurbishedStore {

	private Entry[] entries;
	private int noe;  // 1).Records how many entries have been stored in the entries array. 2). indicates the index of the entries array that will store the next entry.
	private final int MAX_CAPACITY = 5;

	public RefurbishedStore () {

		this.entries = new Entry[MAX_CAPACITY];
		this.noe = 0;

	}

	public int getNumberOfEntries() {
		
		return this.noe;
	}

	public Entry[] getPrivateEntriesArray() {

		return this.entries;

	}

	public Entry[] getEntries( ) {

		Entry[] es = new Entry[this.noe];
		for(int i = 0; i<this.noe; i++) {

			es[i] = this.entries[i];

		}

		return es;
	}

	public void addEntry(Entry e) {

		this.entries[this.noe] = e;
		this.noe ++;

	}

	public void addEntry(String sn, Product p) {

		//	Entry ne = new Entry(sn, p); 
		//	this.entries[this.noe] = ne;
		//	this.noe ++;
		this.addEntry(new Entry(sn, p));
	}

	public void addEntry(String sn, String model, double originalPrice) {

		//	Product p = new Product(model, originalPrice);
		// 	Entry ne = new Entry(sn, p);
		// 	this.entries[this.noe] = ne;
		//	this.noe ++;
		this.addEntry(new Entry(sn, new Product(model, originalPrice)));
	}

}
