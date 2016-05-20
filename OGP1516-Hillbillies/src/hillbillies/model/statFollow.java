package hillbillies.model;

public class statFollow extends Statements {
	
	protected statFollow(Expressions unit) throws IllegalArgumentException{
		if (! isValidExpression(unit))
			throw new IllegalArgumentException();
		setUnit(unit);
	}

	public void follow(){
		while (this.unit.getPoistion() != getUnit().getUnit().getPoistion()){
			this.unit.setPosition(getUnit().getUnit().getPoistion());
		}
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
