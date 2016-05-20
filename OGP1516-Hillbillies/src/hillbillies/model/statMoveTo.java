package hillbillies.model;

public class statMoveTo extends Statements {

	protected statMoveTo(Expressions position) throws IllegalArgumentException{
		if (! isValidExpression(position))
			throw new IllegalArgumentException();
		setPosition(position);
	}

	public void moveTo(Expressions position){
		int[] a = position.getPosition();
		double a0 = a[0];
		double a2 = a[2];
		double a1 = a[1];
		double[] pos = {a0,a1,a2};
		unit.setPosition(pos);
	}
	
	
	
	public Expressions getPosition(){
		return this.position;
	}
	
	public void setPosition(Expressions position){
		this.position = position;
	}

	private Unit unit;
	private Expressions position;
}
