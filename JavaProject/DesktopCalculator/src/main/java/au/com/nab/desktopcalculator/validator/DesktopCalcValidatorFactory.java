package au.com.nab.desktopcalculator.validator;

public class DesktopCalcValidatorFactory {
	private DesktopMathsValidator desktopMathsValidator;
	
	public DesktopCalcValidatorFactory(){
		desktopMathsValidator = new DesktopMathsValidator();
	}

	public DesktopMathsValidator getDesktopMathsValidator() {
		return desktopMathsValidator;
	}

	public void setDesktopMathsValidator(DesktopMathsValidator desktopMathsValidator) {
		this.desktopMathsValidator = desktopMathsValidator;
	}
	
}
