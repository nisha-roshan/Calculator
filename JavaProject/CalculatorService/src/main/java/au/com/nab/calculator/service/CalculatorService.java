package au.com.nab.calculator.service;

import java.math.BigDecimal;

import au.com.nab.calculator.service.impl.MathematicalFactory;
import au.com.nab.calculator.service.impl.mathematical.Add;
import au.com.nab.calculator.service.impl.mathematical.Divide;
import au.com.nab.calculator.service.impl.mathematical.Multiply;
import au.com.nab.calculator.service.impl.mathematical.Subtract;

public class CalculatorService {
	MathematicalFactory maths;
	
	public CalculatorService() {
		this.maths = new MathematicalFactory();
	}

	public BigDecimal add(BigDecimal... a){
		Add add = maths.getAdd();
		return add.calculate(a);
	}
	
	public BigDecimal subtract(BigDecimal... a){
		Subtract sub = maths.getSubtract();
		return sub.calculate(a);
	}
	public BigDecimal multiply(BigDecimal... a){
		Multiply multi = maths.getMultiply();
		return multi.calculate(a);
	}
	public BigDecimal divide(BigDecimal... a){
		Divide div = maths.getDivide();
		return div.calculate(a);
	}
}
