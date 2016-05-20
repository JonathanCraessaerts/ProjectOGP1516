package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;

public abstract class unitExpression extends Expressions {
	
	@Model
	protected unitExpression(Expressions e) throws IllegalArgumentException{
		if (! canHaveAsUnit(e))
			throw new IllegalArgumentException();
		this.unit = e;
	}
	
	
	public boolean canHaveAsUnit(Expressions e){
		if (e==null)
			return false;
		else
			return true;
	}
	
	@Basic
	public Expressions getThisUnit() {
		return unit;
	}
	
	@Override
	public int[] getPosition() {
		return null;
	}
	
	private Expressions unit;

}
