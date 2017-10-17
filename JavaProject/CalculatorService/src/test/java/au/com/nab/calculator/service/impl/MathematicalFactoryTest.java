package au.com.nab.calculator.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import au.com.nab.calculator.service.impl.MathematicalFactory;
import au.com.nab.calculator.service.impl.mathematical.Add;
import au.com.nab.calculator.service.impl.mathematical.Divide;
import au.com.nab.calculator.service.impl.mathematical.Multiply;
import au.com.nab.calculator.service.impl.mathematical.Subtract;
//import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class MathematicalFactoryTest {
	private MathematicalFactory factory ;
	
	@Before
	public void setup(){
		this.factory = new MathematicalFactory();
	}
	
	@Test
	public void testFactoryResult(){
		assertTrue(factory.getAdd() instanceof Add);
		assertTrue(factory.getSubtract() instanceof Subtract);
		assertTrue(factory.getMultiply() instanceof Multiply);
		assertTrue(factory.getDivide() instanceof Divide);
	}
	
	@After
	public void tearDown(){
		this.factory = null;
	}
}
