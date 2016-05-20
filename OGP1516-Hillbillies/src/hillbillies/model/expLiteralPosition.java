package hillbillies.model;

public class expLiteralPosition extends Expressions{

	protected expLiteralPosition(int x, int y, int z)  {
		int[] a = {x,y,z};
		this.position = a;
	}
	
	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public int[] getPosition() {
		return this.position;
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}

	private int[] position;
	
}
