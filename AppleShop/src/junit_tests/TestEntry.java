package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Entry;
import model.Product;
import model.Product.*;

public class TestEntry {

       @Test
       
       public void test_entry_1() {
    	   
    	   Product p = new Product("iPad Pro 12.9", 1709.00);
    	   p.setFinish("Space Grey");
    	   p.setStorage(1000);
    	   p.setHasCellularConnectivity(true);
    	   p.setDiscountValue(220.00);
    	   
    	   Entry e = new Entry("F9DN4NKQ1GC", p);
    	   
    	   assertEquals("F9DN4NKQ1GC", e.getSerialNumber());
    	   assertTrue(e.getProduct() == p);
    	   assertSame(e.getProduct(), p);
    	   
	}

}
