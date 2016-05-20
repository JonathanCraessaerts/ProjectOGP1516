package hillbillies.model;

public class expDisjunction extends binBooleanExpression {

	protected expDisjunction(Expressions e1, Expressions e2) throws IllegalArgumentException {
		super(e1, e2);
	}

	@Override
	public boolean getBooleanValue() {
		if (getFirstBool().getBooleanValue()==true || 
				getSecondBool().getBooleanValue()==true)
			return true;
		else	
			return false;
	}

	@Override
	public int[] getPosition() {
		// TODO Auto-generated method stub
		return null;
	}



}
