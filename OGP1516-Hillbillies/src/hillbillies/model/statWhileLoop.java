package hillbillies.model;

public class statWhileLoop extends Statements {
	
	protected statWhileLoop(Expressions condition, Statements body) throws IllegalArgumentException{
		if (! isValidExpression(condition))
			throw new IllegalArgumentException();
		if (! isValidStatement(body))
			throw new IllegalArgumentException();
		setBody(body);
		setcondition(condition);
	}

	public void whileLoop(){
		while (getcondition().getBooleanValue()){
			getBody();
		}
	}
	
	
	public Statements getBody(){
		return this.Body;
	}
	
	public Expressions getcondition(){
		return this.condition;
	}
	
	public void setcondition(Expressions conditionue){
		this.condition = conditionue;
	}
	public void setBody(Statements Body){
		this.Body = Body;
	}
	
	private Statements Body;
	private Expressions condition;
}
