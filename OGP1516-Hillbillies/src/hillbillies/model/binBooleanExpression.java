package hillbillies.model;

import be.kuleuven.cs.som.annotate.Model;
import be.kuleuven.cs.som.annotate.Raw;

public abstract class binBooleanExpression extends Expressions {

	@Model
	protected binBooleanExpression(Expressions e1, Expressions e2) throws IllegalArgumentException {
		if (! canHaveAsBoolean(e1))
			throw new IllegalArgumentException();
		if (! canHaveAsBoolean(e2))
			throw new IllegalArgumentException();
		setBooleanAt(1, e1);
		setBooleanAt(2, e2);
	}

	public boolean canHaveAsBoolean(Expressions e){
		if (e==null)
			return false;
		else
			return true;
	}
	
	@Raw
	public final Expressions getBooleanAt(int index)
			throws IndexOutOfBoundsException {
		if ((index != 1) && (index != 2))
			throw new IndexOutOfBoundsException();
		if (index == 1)
			return getFirstBool();
		else
			return getSecondBool();
	}
	
	
	@Raw
	protected void setBooleanAt(int index, Expressions bool) {
		if (index == 1)
			this.firstBool = bool;
		else
			this.secondBool = bool;
	}
	
	
	public Expressions getFirstBool(){
		return firstBool;
	}
	
	public Expressions getSecondBool(){
		return secondBool;
	}
	
	
	
	@Override
	public abstract boolean getBooleanValue(); 
	

	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public int[] getPosition() {

		return null;
	}
	
	private Expressions firstBool;
	private Expressions secondBool;

}
