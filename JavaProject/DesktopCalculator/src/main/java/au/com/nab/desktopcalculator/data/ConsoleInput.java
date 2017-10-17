package au.com.nab.desktopcalculator.data;

public class ConsoleInput {
	private String[] args;
	private boolean isMathFunction;
	
	public ConsoleInput(String[] args, boolean isMathFunction){
		this.args = args;
		this.isMathFunction = isMathFunction;
	}
	public String[] getArgs() {
		return args;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	public boolean isMathFunction() {
		return isMathFunction;
	}
	public void setMathFunction(boolean isMathFunction) {
		this.isMathFunction = isMathFunction;
	}
}
