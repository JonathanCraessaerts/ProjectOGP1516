package hillbillies.model;

public class statIf extends Statements {
	protected statIf(Expressions condition, Statements ifBody, Statements elseBody) throws IllegalArgumentException{
		if (! isValidExpression(condition))
			throw new IllegalArgumentException();
		if (! isValidStatement(ifBody))
			throw new IllegalArgumentException();
		if (! isValidStatement(elseBody))
			throw new IllegalArgumentException();
		setIfBody(ifBody);
		setcondition(condition);
		setElseBody(elseBody);
	}

	public void ifStatement(){
		if (getcondition().getBooleanValue()){
			getIfBody();
		}
		else{
			getElseBody();
		}
	}
	
	
	public Statements getIfBody(){
		return this.ifBody;
	}
	public Statements getElseBody(){
		return this.elseBody;
	}
	
	public Expressions getcondition(){
		return this.condition;
	}
	
	public void setcondition(Expressions conditionue){
		this.condition = conditionue;
	}
	public void setIfBody(Statements Body){
		this.ifBody = Body;
	}
	public void setElseBody(Statements Body){
		this.elseBody = Body;
	}
	private Statements elseBody;
	private Statements ifBody;
	private Expressions condition;
}
