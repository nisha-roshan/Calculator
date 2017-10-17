# Calculator
Java Project
Design :
	1. Two Maven Java Projects
		a. CalculatorService 
			i. Façade Pattern : CalculatorService.java is the façade
			ii. Interface for Functions (Operations)
			iii. Factory pattern for instantiating different Mathematical functions
			iv. TDD approach

		b. DesktopCalculator
			i. Treated like the Client project accessing the Calculator Service Façade for various functions
			ii. Required validations in place
			iii. TDD approach
Packaging
	1. JavaProjects : Contain projects CalculatorService and DesktopCalculator with source
	2. Executable : Jar for executions
		a. Execution Command

		java -jar DesktopCalculator-0.1-jar-with-dependencies.jar OPERAND OPERATOR OPERAND
		

	Please Note :   Multiplication symbol (asterisk *) on command line has to be included within double quotes as it is treated like a wildcard
