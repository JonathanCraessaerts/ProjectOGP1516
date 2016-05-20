package hillbillies.model;

public class expCarriesItem extends unitExpression {

	protected expCarriesItem(Expressions e) throws IllegalArgumentException {
		super(e);
	}
	
	@Override
	public Unit getUnit() {
		return getThisUnit().getUnit();
	}


	@Override
	public boolean getBooleanValue() {
		if (getUnit().holdsBoulder() || getUnit().holdsLog())
			return true;
		else
			return false;
	}
	
	

}
