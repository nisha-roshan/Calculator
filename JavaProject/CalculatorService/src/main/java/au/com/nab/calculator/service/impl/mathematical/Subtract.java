package au.com.nab.calculator.service.impl.mathematical;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import au.com.nab.calculator.service.impl.Mathematical;

public class Subtract implements Mathematical{

	@Override
	public BigDecimal calculate(BigDecimal... a) {
		BigDecimal total = new BigDecimal(0);
		for (int i = 0; i < a.length; i++) {
			if(i == 0){
				total = a[i];
			}
			total = total.subtract(a[++i],context);
		}
		return total;
	}

}
