package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;

public abstract class booleanExpression extends Expressions {
	
	@Model
	protected booleanExpression(Expressions e) throws IllegalArgumentException{
		if (! canHaveAsBoolean(e))
			throw new IllegalArgumentException();
		this.bool = e;
	}
	
	
	public boolean canHaveAsBoolean(Expressions e){
		if (e==null)
			return false;
		else
			return true;
	}
	
	@Basic
	public Expressions getBoolean() {
		return bool;
	}

	private Expressions bool;
	
	

	@Override
	public Unit getUnit() {
		return null;
	}
	

	@Override
	public int[] getPosition() {

		return null;
	}

}
