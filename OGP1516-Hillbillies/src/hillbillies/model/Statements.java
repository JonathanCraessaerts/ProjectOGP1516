package hillbillies.model;
import java.util.List;

public abstract class Statements {

	public boolean isValidString(String str){
		return !(str == null);
	}
	
	public boolean isValidExpression(Expressions exp){
		return !(exp == null);
	}
	
	public boolean isValidStatement(Statements stat){
		return !(stat == null);
	}
	
	public boolean isValidStatements(List<Statements> stats){
		return !(stats == null);
	}
	
}
