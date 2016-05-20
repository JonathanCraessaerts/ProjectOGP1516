package hillbillies.model;

public class statAssignment extends Statements {

	protected statAssignment(String varName, Expressions val) throws IllegalArgumentException{
		if (! isValidExpression(val))
			throw new IllegalArgumentException();
		if (! isValidString(varName))
			throw new IllegalArgumentException();
		setVarName(varName);
		setVal(val);
	}
	
	public String getVarName(){
		return this.varName;
	}
	
	public Expressions getVal(){
		return this.val;
	}
	
	public void setVal(Expressions value){
		this.val = value;
	}
	public void setVarName(String varName){
		this.varName = varName;
	}
	
	
	private String varName;
	private Expressions val;

	
}
