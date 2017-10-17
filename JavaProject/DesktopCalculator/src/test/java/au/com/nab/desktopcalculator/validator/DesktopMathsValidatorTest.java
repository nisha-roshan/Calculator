package au.com.nab.desktopcalculator.validator;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
import au.com.nab.desktopcalculator.data.ConsoleInput;

public class DesktopMathsValidatorTest {
	private DesktopMathsValidator desktopMathValidator;
	private final String OPERAND_PATTERN= "[0-9]*\\.?[0-9]*";
	private final String OPERATOR_PATTERN= "[\\+\\*\\/\\-]";
	@Before
	public void setup(){
		DesktopCalcValidatorFactory fac = new DesktopCalcValidatorFactory();
		this.desktopMathValidator = fac.getDesktopMathsValidator();
	}
	
	@Test
	public void validateFormatTest(){
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("9");
		assertTrue(this.desktopMathValidator.validateFormat(lst, OPERAND_PATTERN).isEmpty());
		
		lst.add("0");
		assertTrue(this.desktopMathValidator.validateFormat(lst, OPERAND_PATTERN).isEmpty());
		
		lst.add("0.5");
		assertTrue(this.desktopMathValidator.validateFormat(lst, OPERAND_PATTERN).isEmpty());
		
		lst.add("a");
		assertTrue(!this.desktopMathValidator.validateFormat(lst, OPERAND_PATTERN).isEmpty());
		
		ArrayList<String> operatorLst = new ArrayList<String>();
		operatorLst.add("*");
		assertTrue(this.desktopMathValidator.validateFormat(operatorLst, OPERATOR_PATTERN).isEmpty());
		
		operatorLst.add("/");
		assertTrue(this.desktopMathValidator.validateFormat(operatorLst, OPERATOR_PATTERN).isEmpty());
		
		operatorLst.add("+");
		assertTrue(this.desktopMathValidator.validateFormat(operatorLst, OPERATOR_PATTERN).isEmpty());
		
		operatorLst.add("-");
		assertTrue(this.desktopMathValidator.validateFormat(operatorLst, OPERATOR_PATTERN).isEmpty());
		
		operatorLst.add("9");
		assertTrue(!this.desktopMathValidator.validateFormat(operatorLst, OPERATOR_PATTERN).isEmpty());
		
	}
	@Test
	public void validateConsoleLengthTest(){
		String[] args = {"3","+","5"};
		ConsoleInput input = new ConsoleInput(args, true);
		assertTrue(this.desktopMathValidator.validateConsoleLength(input, 3).isEmpty());
		
		String[] args1 = {"3","+","5","9"};
		ConsoleInput input1 = new ConsoleInput(args1, true);
		assertTrue(!this.desktopMathValidator.validateConsoleLength(input1, 3).isEmpty());
	}
	
	@Test
	public void validateOrderTest(){
		String[] args = {"3","+","5"};
		ConsoleInput input = new ConsoleInput(args, true);
		assertTrue(this.desktopMathValidator.validateOrder(input).isEmpty());
		
		String[] args1 = {"3","+","5","9"};
		ConsoleInput input1 = new ConsoleInput(args1, true);
		assertTrue(!this.desktopMathValidator.validateOrder(input1).isEmpty());
	}
	
	@After
	public void tearDown(){
		
	}
	}


