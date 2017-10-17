package au.com.nab.calculator.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CalculatorServiceTest {
	@Before
	public void setup(){
		
	}
	
	@Test(expected=NumberFormatException.class)
	public void testAdd(){
		CalculatorService service = new CalculatorService();
		
		BigDecimal addIntergers = service.add(new BigDecimal("5"),new BigDecimal("6"));
		assertEquals(new BigDecimal(11),addIntergers);
		
		BigDecimal addDecimals = service.add(new BigDecimal("5.2"),new BigDecimal("6.3"));
		assertEquals(new BigDecimal(11.5),addDecimals);
		
		BigDecimal addNegative = service.add(new BigDecimal("-3"),new BigDecimal("2"));
		assertEquals(new BigDecimal(-1),addNegative);
		
		service.add(new BigDecimal("a"),new BigDecimal("2"));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testSubtract(){
		CalculatorService service = new CalculatorService();
		
		BigDecimal subIntergers = service.subtract(new BigDecimal("9"),new BigDecimal("6"));
		assertEquals(new BigDecimal(3),subIntergers);
		
		BigDecimal subDecimals = service.subtract(new BigDecimal("8.2"),new BigDecimal("6.3"));
		assertEquals(new BigDecimal("1.9"),subDecimals);
		
		BigDecimal subNegative = service.subtract(new BigDecimal("-3"),new BigDecimal("2"));
		assertEquals(new BigDecimal(-5),subNegative);
		
		service.subtract(new BigDecimal("a"),new BigDecimal("2"));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testMultiply(){
		CalculatorService service = new CalculatorService();
		
		BigDecimal multiplyIntergers = service.multiply(new BigDecimal("5"),new BigDecimal("6"));
		assertEquals(new BigDecimal(30),multiplyIntergers);
		
		BigDecimal multiplyDecimals = service.multiply(new BigDecimal("8.2"),new BigDecimal("6.3"));
		assertEquals(new BigDecimal("51.66"),multiplyDecimals);
		
		BigDecimal subNegative = service.multiply(new BigDecimal("-3"),new BigDecimal("2"));
		assertEquals(new BigDecimal(-6),subNegative);
		
		service.multiply(new BigDecimal("a"),new BigDecimal("2"));
	}
	
	@Test
	public void testDivide(){
		CalculatorService service = new CalculatorService();
		
		BigDecimal multiplyIntergers = service.divide(new BigDecimal("30"),new BigDecimal("6"));
		assertEquals(new BigDecimal(5),multiplyIntergers);
		
		BigDecimal multiplyDecimals = service.divide(new BigDecimal("8.2"),new BigDecimal("6.3"));
		assertEquals(new BigDecimal("1.302"),multiplyDecimals);
		
		BigDecimal multiplyNegative = service.divide(new BigDecimal("-3"),new BigDecimal("2"));
		assertEquals(new BigDecimal("-1.5"),multiplyNegative);
		
		try {
			   service.divide(new BigDecimal("a"),new BigDecimal("2"));
			   fail("Expected NumberFormatException");
		}
			catch(NumberFormatException e) {
			  // no-op (pass)
			}
		
		try {
			service.divide(new BigDecimal("4"),new BigDecimal("0"));
			fail("Expected ArithmeticException");
		}
			catch(ArithmeticException e) {
			  // no-op (pass)
			}
		
	}
	
	@After
	public void tearDown(){
		
	}
}
