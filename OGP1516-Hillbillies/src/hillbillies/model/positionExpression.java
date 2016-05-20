package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;

public abstract class positionExpression extends Expressions {

	
	@Model
	protected positionExpression(Expressions e) throws IllegalArgumentException{
		if (! canHaveAsPosition(e))
			throw new IllegalArgumentException();
		this.position = e;
	}
	
	
	public boolean canHaveAsPosition(Expressions e){
		if (e==null)
			return false;
		else
			return true;
	}


	@Basic
	public Expressions getPos() {
		return position;
	}
	
	private Expressions position;
	
	
	@Override
	public boolean getBooleanValue() {
		return false;
	}
	@Override
	public Unit getUnit() {
		return null;
	}
	
}
