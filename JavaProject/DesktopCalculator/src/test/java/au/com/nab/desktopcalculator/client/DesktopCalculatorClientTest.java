package au.com.nab.desktopcalculator.client;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import au.com.nab.calculator.service.impl.MathematicalFactory;
import au.com.nab.calculator.service.impl.mathematical.Add;
import au.com.nab.calculator.service.impl.mathematical.Divide;
import au.com.nab.calculator.service.impl.mathematical.Multiply;
import au.com.nab.calculator.service.impl.mathematical.Subtract;
import au.com.nab.desktopcalculator.client.DesktopCalculatorClient;

public class DesktopCalculatorClientTest {
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void psvmTest(){
		String[] addArgs1 = {"2","+","5"};
		DesktopCalculatorClient.main(addArgs1);
		
		String[] addArgs2 = {"2","-","5"};
		DesktopCalculatorClient.main(addArgs2);
		
		String[] addArgs3 = {"2","*","5"};
		DesktopCalculatorClient.main(addArgs3);
		
		String[] addArgs4 = {"a","/","5"};
		DesktopCalculatorClient.main(addArgs4);
		
	}
	
	@After
	public void tearDown(){
		
	}
	}


