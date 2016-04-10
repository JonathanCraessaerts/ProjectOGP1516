import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;


import hillbillies.model.Log;


public class objectTests {

	//Tests for logs (and boulders which are the same as logs)
	
	private double[] p = {0,0,0};
	
	@Before
	public void setupLog() throws Exception{
		log = new Log(p, 20,null);
	}
	private Log log;


	private double[] p2 = {50.01,20.30,30.99};
	private double[] p3 = {5.01,20.30,30.99};
	
	
	@Test
	public void logTests(){
		assertEquals(20, log.getWeight());
		log.setWeight(30);
		assertEquals(30, log.getWeight());
		assertFalse(log.isValidWeight(51));
		assertFalse(log.isValidPosition(p2));
		log.setPosition(p3);
		assertEquals(p3, log.getPosition());
		log.unsetPosition();
		assertFalse(log.hasHolder());          
		
	}
	
}
