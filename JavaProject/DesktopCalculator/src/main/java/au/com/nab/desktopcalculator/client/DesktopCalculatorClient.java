package au.com.nab.desktopcalculator.client;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.nab.calculator.service.CalculatorService;
import au.com.nab.desktopcalculator.data.ConsoleInput;
import au.com.nab.desktopcalculator.validator.DesktopCalcValidatorFactory;

public class DesktopCalculatorClient {
	private final static Map<String, String> operatorLookup = new HashMap<String, String>();
	static{
		operatorLookup.put("+", "add");
		operatorLookup.put("-", "subtract");
		operatorLookup.put("*", "multiply");
		operatorLookup.put("/", "divide");
	}
	
	
	public static void main(String[] args){
		DesktopCalcValidatorFactory validatorFactory = new DesktopCalcValidatorFactory();
		ConsoleInput consoleInput = new ConsoleInput(args,true);
		List<String> validateMessage = validatorFactory.getDesktopMathsValidator().validate(consoleInput);
		if(validateMessage.isEmpty()){
			CalculatorService calc = new CalculatorService();
			String operation = operatorLookup.get(args[1]);
			
			try {
				
				Method method = Class.forName("au.com.nab.calculator.service.CalculatorService").getMethod(operation,new Class[]{BigDecimal[].class});
				BigDecimal[] operands = {new BigDecimal(consoleInput.getArgs()[0]),new BigDecimal(consoleInput.getArgs()[2])};
				
				 Object result = method.invoke(calc,new Object[]{operands});
				 System.out.println(operation+" Result : "+ (BigDecimal)result);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			System.out.println("Validation Failed : "+ validateMessage);
		}
		
	}

}
