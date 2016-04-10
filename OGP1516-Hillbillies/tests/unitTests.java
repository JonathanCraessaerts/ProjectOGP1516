import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import hillbillies.model.Unit;
public class unitTests {
	
	private Unit unit1;
	private int[] initPos = {2,2,2};
	
	@Before
	public void setup() throws Exception{
		unit1 = new Unit("Abz", initPos, 150, 150, 150, 150, false);

	}
	public void setup2()throws Exception{
		unit1 = new Unit(200,200);

		}

	@Test
	public void nameTests(){
		assertFalse(unit1.isValidName("a"));
		assertFalse(unit1.isValidName("abc906"));
		assertFalse(unit1.isValidName("abc!"));
		assertTrue(unit1.isValidName("ab  c"));
		assertTrue(unit1.isValidName("AbZ' A"));
		assertTrue(unit1.isValidName("abzzzA'a"));
		assertTrue(unit1.isValidName("ab     ' c"));
		assertTrue(unit1.isValidName("ab"));
	}
	
	@Test
	public void testSetName(){
		unit1.setName("Az' op");
		assertEquals("Az' op",unit1.getName());
	}
	
	@Test
	public void testGetName(){
		assertEquals("Abz",unit1.getName());
	}
	
	@Test
	public void testGetPos(){
		System.out.println(Arrays.toString(unit1.getPoistion()));
	}
	
	@Test
	public void testGetOccupiedCube(){
		double [] a = {0.1, 2.1, 3.5};	
		System.out.println(Arrays.toString(unit1.getOccupiedGameCube(a)));
	}
		
	@Test
	public void testGetStrength(){
		assertEquals(150,unit1.getStength());
	}

	@Test
	public void testsetStrength(){
		unit1.setStength(100);
		assertEquals(100,unit1.getStength());
	}
	@Test
	public void testValidStrength(){
		assertFalse(unit1.isValidStength(-5));
		assertFalse(unit1.isValidStength(300));
		assertFalse(unit1.isValidStength(0));
		assertTrue(unit1.isValidStength(200));
	}
	
	@Test
	public void testGetAgility(){
		assertEquals(150,unit1.getAgility());
	}

	@Test
	public void testsetAgility(){
		unit1.setAgility(100);
		assertEquals(100,unit1.getAgility());
	}
	@Test
	public void testValidAgility(){
		assertFalse(unit1.isValidAgility(-5));
		assertFalse(unit1.isValidAgility(300));
		assertFalse(unit1.isValidAgility(0));
		assertTrue(unit1.isValidAgility(24));
	}
	@Test
	public void testGetThoughness(){
		assertEquals(150,unit1.getToughness());
	}

	@Test
	public void testsetThoughness(){
		unit1.setToughness(100);
		assertEquals(100,unit1.getToughness());
	}
	@Test
	public void testValidThoughness(){
		assertFalse(unit1.isValidToughness(-5));
		assertFalse(unit1.isValidToughness(300));
		assertFalse(unit1.isValidToughness(0));
		assertTrue(unit1.isValidToughness(200));
	}
	
	@Test
	public void testGetWeight(){
		assertEquals(150,unit1.getWeight());
	}

	@Test
	public void testsetWeight(){
		unit1.setWeight(200);
		assertEquals(200,unit1.getWeight());
	}
	@Test
	public void testValidWeight(){
		assertFalse(unit1.isValidWeight(-5));
		assertFalse(unit1.isValidWeight(300));
		assertFalse(unit1.isValidWeight(0));
		assertFalse(unit1.isValidWeight(201));
		assertTrue(unit1.isValidWeight(200));
	}
	
	
	@Test
	public void testsetStamina(){
		unit1.setStamina(200);
		assertEquals(200,unit1.getStamina());
	}
	@Test
	public void testValidStamina(){
		assertFalse(unit1.isValidStamina(-5));
		assertFalse(unit1.isValidStamina(300));
		assertTrue(unit1.isValidStamina(0));
		assertFalse(unit1.isValidStamina(450));
		assertTrue(unit1.isValidStamina(200));
	}
	
	
	@Test
	public void VbTest(){
		assertEquals(1.5, unit1.Vb(), 0.0);
	}
	
	@Test
	public void centerPosTest(){
		double[] x = {2.1,5.3,2.0};
		System.out.println(Arrays.toString(unit1.getCenterNewPosition(x)));
		System.out.println(unit1.Vw(x));
	}
	
	@Test
	public void VsTest(){
		double[] x = {2.1,5.3,2.0};
		unit1.setStamina(150);
		System.out.println(unit1.Vs(x));	
	}
	@Test
	public void VsTest2(){
		double[] x = {2.1,5.3,2.0};
		unit1.setStamina(0);
		System.out.println(unit1.Vs(x));	
	}
	
	
}
