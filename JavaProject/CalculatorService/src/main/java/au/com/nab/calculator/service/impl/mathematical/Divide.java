package au.com.nab.calculator.service.impl.mathematical;

import java.math.BigDecimal;
import java.math.RoundingMode;

import au.com.nab.calculator.service.impl.Mathematical;

public class Divide implements Mathematical{

	@Override
	public BigDecimal calculate(BigDecimal... a) {
		BigDecimal total = new BigDecimal(0);
		for (int i = 0; i < a.length; i++) {
			if(i == 0){
				total = a[i];
			}
			int j = (i==(a.length-1))?0:i+1; 
			if(j!=0){
				total = total.divide(a[j],context);	
			}
			
		}
		return total;
	}

}
