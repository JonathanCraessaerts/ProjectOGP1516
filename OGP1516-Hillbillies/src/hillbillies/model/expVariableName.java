package hillbillies.model;

public class expVariableName extends Expressions{

	protected expVariableName(String var) {
		this.varName = var;
	}
	
	
	public String getVarName(){
		return this.varName;
	}
	
	private String varName;
	
	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public int[] getPosition() {
		return null;
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}

}
