package au.com.nab.calculator.service.impl.mathematical;

import java.math.BigDecimal;

import au.com.nab.calculator.service.impl.Mathematical;

public class Add implements Mathematical{

	@Override
	public BigDecimal calculate(BigDecimal... a) {
		BigDecimal total = new BigDecimal(0);
		for (int i = 0; i < a.length; i++) {
			total = total.add(a[i],context);
		}
		return total;
	}
}
