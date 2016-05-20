package hillbillies.model;

public class expIsFriend extends unitExpression {

	protected expIsFriend(Expressions e) throws IllegalArgumentException {
		super(e);
	}

	@Override
	public Unit getUnit() {
		return getThisUnit().getUnit();
	}


	@Override
	public boolean getBooleanValue() {
		if (unit.getFaction() == getUnit().getFaction())
			return true;
		else
			return false;
	}
	
	
	private Unit unit;

}
