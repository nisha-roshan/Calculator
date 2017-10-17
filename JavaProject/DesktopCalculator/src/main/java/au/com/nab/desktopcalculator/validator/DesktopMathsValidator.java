package au.com.nab.desktopcalculator.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.nab.desktopcalculator.data.ConsoleInput;

public class DesktopMathsValidator implements DesktopCalcValidator<ConsoleInput>{
	private final static String OPERAND_PATTERN = "[0-9]*\\.?[0-9]*";//"[0-9]+[.]?[0-9]";
	private final static String OPERATOR_PATTERN = "[\\+\\*\\/\\-]";
	
	
	public List<String> validate(ConsoleInput consoleInput) {
		System.out.println("Validation ON ------");
		ArrayList<String> msg = new ArrayList<String>();
		
		addMessage(msg,validateConsoleLength(consoleInput,3));
		
		if(msg.isEmpty()){
			addMessage(msg,validateOrder(consoleInput));
			
		}else{
			return msg;
		}
		if(msg.isEmpty()){
			ArrayList<String> lst = new ArrayList<String>();
			lst.add(consoleInput.getArgs()[0]);
			lst.add(consoleInput.getArgs()[2]);
			addMessage(msg,validateFormat(lst, OPERAND_PATTERN));
			
			String operator = consoleInput.getArgs()[1];
			addMessage(msg,validateLength(operator,1));
			ArrayList<String> operatorLst = new ArrayList<String>();
			operatorLst.add(consoleInput.getArgs()[1]);
			addMessage(msg,validateFormat(operatorLst,OPERATOR_PATTERN));
		}
		
		return msg;
	}
	
	public ArrayList<String> addMessage(ArrayList<String> msgList, String msg){
		if(msg.length()>0){
			msgList.add(msg);
		}
		return msgList;
	}
	
	public String validateConsoleLength(
			ConsoleInput consoleInput, int len) {
		if(consoleInput.getArgs().length != len){
			return "Please enter "+len+" arguements"+consoleInput.getArgs().length;
		}
		return "";
	}
	public String validateLength(
			String s, int len) {
		if(s.length() != len){
			return "Length incorrect for "+s;
		}
		return "";
	}
	public String validateOrder(ConsoleInput consoleInput) {
		String validateConsoleLength = validateConsoleLength(consoleInput, 3);
		String msg="";
		if(validateConsoleLength.isEmpty()){
			String[] args = consoleInput.getArgs();
			msg = validateNumber(args[0]);
			if(msg.isEmpty()){
				return validateNumber(args[2]);
			}
		}else{
			return validateConsoleLength;
		}
		return msg;
	}
	public String validateNumber(String arg){
		try {
			BigDecimal decimal = new BigDecimal(arg);
		} catch (NumberFormatException  e) {
			return "Arguement ["+arg+ "] should be a number";
		}
		return "";
	} 
	public String validateFormat(
			ArrayList<String> lst, String pattern) {
		for (String arg : lst) {
			if(!isValidPattern(pattern,String.valueOf(arg))){
				return "Argument ["+ arg+"] should follow pattern "+ pattern;
			}
		}
		return "";
	}
  
	private boolean isValidPattern(String format , String matcherString){
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(matcherString);
		if(!matcher.matches()){
			return false;
		}
		return true;
	}
	

}
