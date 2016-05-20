package hillbillies.model;

public class statPrint extends Statements {
	protected statPrint(Expressions val) throws IllegalArgumentException{
		if (! isValidExpression(val))
			throw new IllegalArgumentException();
		setVal(val);
	}
	
	public void print(){
		System.out.println(getVal().toString());
	}
	
	public Expressions getVal(){
		return this.val;
	}
	
	public void setVal(Expressions value){
		this.val = value;
	}

	
	
	private Expressions val;
}
