package hillbillies.model;

public class expIsAlive extends unitExpression {

	protected expIsAlive(Expressions e) throws IllegalArgumentException {
		super(e);
	}

	
	@Override
	public Unit getUnit() {
		return getThisUnit().getUnit();
	}


	@Override
	public boolean getBooleanValue() {
		return !(getUnit().isDead());
	}
	
}
