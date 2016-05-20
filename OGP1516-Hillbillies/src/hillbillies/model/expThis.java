package hillbillies.model;


public class expThis extends Expressions{

	
	protected expThis() {
	}
	
	private Unit unit;


	@Override
	public Unit getUnit() {
		return this.unit;
	}
	
	@Override
	public int[] getPosition() {
		return null;
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}
}
