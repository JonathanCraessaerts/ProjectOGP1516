package hillbillies.model;

import java.util.ArrayList;

public class expFriend extends Expressions{

	
	protected expFriend() {
	}
	
	private Unit unit;


	@Override
	public Unit getUnit() {
		return this.unit;
	}
	
	public Unit getFriendUnit(){
		ArrayList<Unit> u = (ArrayList<Unit>) world.getAllUnits();
		for (int i = 0; i < u.size(); i++){
			if (u.get(i) != getUnit() && u.get(i).getFaction() == getUnit().getFaction())
				return u.get(i);
		}
		return null;

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
