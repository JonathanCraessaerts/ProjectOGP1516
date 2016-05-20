package hillbillies.model;

public class expNegation extends booleanExpression{
	
	public expNegation(Expressions exp) {
		super(exp);
	}



	@Override
	public boolean getBooleanValue() {
		return ! getBoolean().getBooleanValue();
	}








}
