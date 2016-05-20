package hillbillies.model;

public class statWorkAt extends Statements {

	protected statWorkAt(Expressions position) throws IllegalArgumentException{
		if (! isValidExpression(position))
			throw new IllegalArgumentException();
		setPosition(position);
	}

	public void workAt(Expressions position){
		int[] a = position.getPosition();
		int a0 = a[0];
		int a2 = a[2];
		int a1 = a[1];
		unit.workAt(a0, a1, a2);
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
