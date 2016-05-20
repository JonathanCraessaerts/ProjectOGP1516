package hillbillies.model;

public class expHere extends Expressions{

	protected expHere() {
	}

	@Override
	public int[] getPosition() {
		int x = (int) Math.round(getUnit().getPoistion()[0]);
		int y = (int) Math.round(getUnit().getPoistion()[1]);
		int z = (int) Math.round(getUnit().getPoistion()[2]);
		int[] p = {x, y, z};
		return p;
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}

	
	private Unit unit;


	@Override
	public Unit getUnit() {
		return this.unit;
	}
	

}
