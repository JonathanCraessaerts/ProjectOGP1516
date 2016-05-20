package hillbillies.model;

import java.util.ArrayList;
import java.util.List;

import hillbillies.part3.programs.ITaskFactory;
import hillbillies.part3.programs.SourceLocation;



public class TaskFactory implements ITaskFactory<Expressions, Statements, Task>{

	@Override
	public List<Task> createTasks(String name, int priority, Statements activity, List<int[]> selectedCubes) {
		List<Task> tasks = new ArrayList<Task>();
		if (selectedCubes.isEmpty()){
			Task t = new Task(name, priority, activity);
			tasks.add(t);
		}
		else
			for (int i = 0; i < selectedCubes.size(); i++){
				Task t = new Task(name, priority, activity);
				tasks.add(t);
			}
		return tasks;
	}

	@Override
	public Statements createAssignment(String variableName, Expressions value, SourceLocation sourceLocation) {
		return new statAssignment(variableName, value);
	}

	@Override
	public Statements createWhile(Expressions condition, Statements body, SourceLocation sourceLocation) {
		return new statWhileLoop(condition, body);
	}

	@Override
	public Statements createIf(Expressions condition, Statements ifBody, Statements elseBody,
			SourceLocation sourceLocation) {
		return new statIf(condition, ifBody, elseBody);
	}

	@Override
	public Statements createBreak(SourceLocation sourceLocation) {
		return null;
	}

	@Override
	public Statements createPrint(Expressions value, SourceLocation sourceLocation) {
		return new statPrint(value);
	}

	@Override
	public Statements createSequence(List<Statements> statements, SourceLocation sourceLocation) {
		return new statSequence(statements);
	}

	@Override
	public Statements createMoveTo(Expressions position, SourceLocation sourceLocation) {
		return new statMoveTo(position);
	}

	@Override
	public Statements createWork(Expressions position, SourceLocation sourceLocation) {
		return new statWorkAt(position);
	}

	@Override
	public Statements createFollow(Expressions unit, SourceLocation sourceLocation) {
		return new statFollow(unit);
	}

	@Override
	public Statements createAttack(Expressions unit, SourceLocation sourceLocation) {
		return new statAttack(unit);
	}

	@Override
	public Expressions createReadVariable(String variableName, SourceLocation sourceLocation) {
		return new expVariableName(variableName);
	}

	@Override
	public Expressions createIsSolid(Expressions position, SourceLocation sourceLocation) {
		return new expIsSolid(position);
	}

	@Override
	public Expressions createIsPassable(Expressions position, SourceLocation sourceLocation) {
		return new expIsPassable(position);
	}

	@Override
	public Expressions createIsFriend(Expressions unit, SourceLocation sourceLocation) {
		return new expIsFriend(unit);
	}

	@Override
	public Expressions createIsEnemy(Expressions unit, SourceLocation sourceLocation) {
		return new expIsEnemy(unit);
	}

	@Override
	public Expressions createIsAlive(Expressions unit, SourceLocation sourceLocation) {
		return new expIsAlive(unit);
	}

	@Override
	public Expressions createCarriesItem(Expressions unit, SourceLocation sourceLocation) {
		return new expCarriesItem(unit);
	}

	@Override
	public Expressions createNot(Expressions expression, SourceLocation sourceLocation) {	
		return new expNegation(expression);
	}

	@Override
	public Expressions createAnd(Expressions left, Expressions right, SourceLocation sourceLocation) {		
		return new expConjunction(left, right);
	}

	@Override
	public Expressions createOr(Expressions left, Expressions right, SourceLocation sourceLocation) {	
		return new expDisjunction(left, right);
	}

	@Override
	public Expressions createHerePosition(SourceLocation sourceLocation) {
		return new expHere();
	}

	@Override
	public Expressions createLogPosition(SourceLocation sourceLocation) {
		return new expLog();
	}

	@Override
	public Expressions createBoulderPosition(SourceLocation sourceLocation) {
		return new expBoulder();
	}

	@Override
	public Expressions createWorkshopPosition(SourceLocation sourceLocation) {
		return new expWorkshop();
	}

	@Override
	public Expressions createSelectedPosition(SourceLocation sourceLocation) {
		return null;
	}

	@Override
	public Expressions createNextToPosition(Expressions position, SourceLocation sourceLocation) {
		return new expNextTo(position);
	}

	@Override
	public Expressions createPositionOf(Expressions unit, SourceLocation sourceLocation) {
		return new expPositionOf(unit);
	}

	@Override
	public Expressions createLiteralPosition(int x, int y, int z, SourceLocation sourceLocation) {
		return new expLiteralPosition(x, y, z);
	}

	@Override
	public Expressions createThis(SourceLocation sourceLocation) {
		return new expThis();
	}

	@Override
	public Expressions createFriend(SourceLocation sourceLocation) {
		return new expFriend();
	}

	@Override
	public Expressions createEnemy(SourceLocation sourceLocation) {
		return new expEnemy();
	}

	@Override
	public Expressions createAny(SourceLocation sourceLocation) {
		return new expAny();
	}

	@Override
	public Expressions createTrue(SourceLocation sourceLocation) {
		return new expTrue();
	}

	@Override
	public Expressions createFalse(SourceLocation sourceLocation) {
		return new expFalse();
	}

}
