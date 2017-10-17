package au.com.nab.desktopcalculator.validator;

import java.util.List;

public interface DesktopCalcValidator<T> {
	public List<String> validate(T t);
}
