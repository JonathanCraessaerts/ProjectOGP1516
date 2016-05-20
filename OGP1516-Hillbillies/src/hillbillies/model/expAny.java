package hillbillies.model;

import java.util.ArrayList;

public class expAny extends Expressions{

	
	protected expAny() {
	}
	
	private Unit unit;


	@Override
	public Unit getUnit() {
		return this.unit;
	}
	
	public Unit getAnyUnit(){
		ArrayList<Unit> u = (ArrayList<Unit>) world.getAllUnits();
		if (u.get(0) != getUnit())
			return u.get(0);
		else
			return u.get(1);
	}
	
	
	private World world;
	

	@Override
	public int[] getPosition() {
		return null;
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}

}
