package hillbillies.model;

public class expIsEnemy extends unitExpression  {

	protected expIsEnemy(Expressions e) throws IllegalArgumentException {
		super(e);
	}

	@Override
	public Unit getUnit() {
		return getThisUnit().getUnit();
	}


	@Override
	public boolean getBooleanValue() {
		if (unit.getFaction() == getUnit().getFaction())
			return false;
		else
			return true;
	}
	
	
	private Unit unit;

}
