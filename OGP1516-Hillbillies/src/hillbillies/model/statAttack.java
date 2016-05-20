package hillbillies.model;

public class statAttack extends Statements {

	protected statAttack(Expressions unit) throws IllegalArgumentException{
		if (! isValidExpression(unit))
			throw new IllegalArgumentException();
		setUnit(unit);
	}

	public void attack(){
		this.unit.attack(this.unit, getUnit().getUnit());
	}
	
	
	
	public Expressions getUnit(){
		return this.Unit;
	}
	
	public void setUnit(Expressions Unit){
		this.Unit = Unit;
	}

	private Unit unit;
	private Expressions Unit;
}
