package au.com.nab.calculator.service.impl;

import au.com.nab.calculator.service.impl.mathematical.Add;
import au.com.nab.calculator.service.impl.mathematical.Divide;
import au.com.nab.calculator.service.impl.mathematical.Multiply;
import au.com.nab.calculator.service.impl.mathematical.Subtract;

public class MathematicalFactory {
	private final Add add;
	private final Divide divide;
	private final Multiply multiply;
	private final Subtract subtract;
	
	public MathematicalFactory(){
		this.add = new Add();
		this.subtract = new Subtract();
		this.divide = new Divide();
		this.multiply = new Multiply();
	}
	
	public Add getAdd(){
		
		return add;
	}
	public Subtract getSubtract(){
			
			return subtract;
		}
	
	public Divide getDivide(){
		
		return divide;
	}

	public Multiply getMultiply(){
		
		return multiply;
	}

	
}
