package au.com.nab.calculator.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface Mathematical extends Function<BigDecimal>{
	public static final MathContext context = new MathContext(4,RoundingMode.HALF_DOWN) ;

}
