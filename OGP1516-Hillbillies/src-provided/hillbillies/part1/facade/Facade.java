package hillbillies.part1.facade;

import hillbillies.model.Unit;
import java.util.Random;
import ogp.framework.util.ModelException;

public class Facade implements IFacade {

		
	

	@Override
	public Unit createUnit(String name, int[] initialPosition, int weight, int agility, int strength, int toughness,
			boolean enableDefaultBehavior) throws ModelException {
		Unit unit = new Unit(name, initialPosition, weight, agility, toughness, toughness, enableDefaultBehavior);
		return unit;
	}

	@Override
	public double[] getPosition(Unit unit) throws ModelException {

		return unit.getCenterPosition();
	}

	@Override
	public long[] getCubeCoordinate(Unit unit) throws ModelException {

		return unit.getOccupiedGameCube(unit.getPoistion());
	}

	@Override
	public String getName(Unit unit) throws ModelException {

		return unit.getName();
	}

	@Override
	public void setName(Unit unit, String newName) throws ModelException {
		if (unit.isValidName(newName))
			unit.setName(newName);

	}

	@Override
	public int getWeight(Unit unit) throws ModelException {

		return unit.getWeight();
	}

	@Override
	public void setWeight(Unit unit, int newValue) throws ModelException {
		if (unit.isValidWeight(newValue))
			unit.setWeight(newValue);

	}

	@Override
	public int getStrength(Unit unit) throws ModelException {

		return unit.getStength();
	}

	@Override
	public void setStrength(Unit unit, int newValue) throws ModelException {
		if (unit.isValidStength(newValue))
			unit.setStength(newValue);

	}

	@Override
	public int getAgility(Unit unit) throws ModelException {

		return unit.getAgility();
	}

	@Override
	public void setAgility(Unit unit, int newValue) throws ModelException {
		if (unit.isValidAgility(newValue))
			unit.setAgility(newValue);

	}

	@Override
	public int getToughness(Unit unit) throws ModelException {

		return unit.getToughness();
	}

	@Override
	public void setToughness(Unit unit, int newValue) throws ModelException {
		if (unit.isValidToughness(newValue))
			unit.setToughness(newValue);
		

	}

	@Override
	public int getMaxHitPoints(Unit unit) throws ModelException {

		return unit.maxHP();
	}

	@Override
	public int getCurrentHitPoints(Unit unit) throws ModelException {

		return unit.getHitpoints();
	}

	@Override
	public int getMaxStaminaPoints(Unit unit) throws ModelException {

		return unit.maxStamina();
	}

	@Override
	public int getCurrentStaminaPoints(Unit unit) throws ModelException {

		return unit.getStamina();
	}

	@Override
	public void advanceTime(Unit unit, double dt) throws ModelException {
		unit.advanceTime(dt);

	}

	@Override
	public void moveToAdjacent(Unit unit, int dx, int dy, int dz) throws ModelException {
		double[] d = {dx, dy, dz};
		unit.moveToAdjacent(d);
	}

	@Override
	public double getCurrentSpeed(Unit unit) throws ModelException {
		return unit.getCurrentSpeed();
	}

	@Override
	public boolean isMoving(Unit unit) throws ModelException {
		return unit.isMoving();
	}

	@Override
	public void startSprinting(Unit unit) throws ModelException {
		unit.startSprint();

	}

	@Override
	public void stopSprinting(Unit unit) throws ModelException {
		unit.stopSprint();

	}

	@Override
	public boolean isSprinting(Unit unit) throws ModelException {
		return unit.isSprinting();
	}

	@Override
	public double getOrientation(Unit unit) throws ModelException {
		return unit.getOrientation();
	}

	@Override
	public void moveTo(Unit unit, int[] cube) throws ModelException {
		double a = (double) cube[0];
		double b = (double) cube[1];
		double c = (double) cube[2];
		double[] d = {a,b,c};
		unit.moveTo(d);

	}

	@Override
	public void work(Unit unit) throws ModelException {
		unit.work();

	}

	@Override
	public boolean isWorking(Unit unit) throws ModelException {
		return unit.isWorking();
	}

	@Override
	public void fight(Unit attacker, Unit defender) throws ModelException {
		attacker.attack(attacker, defender);
		defender.defend(attacker, defender);

	}

	@Override
	public boolean isAttacking(Unit unit) throws ModelException {
		return unit.isAttacking();
	}

	@Override
	public void rest(Unit unit) throws ModelException {
		unit.rest();

	}

	@Override
	public boolean isResting(Unit unit) throws ModelException {
		return unit.isResting();
	}

	@Override
	public void setDefaultBehaviorEnabled(Unit unit, boolean value) throws ModelException {
		unit.startDefaultBehaviour(value);

	}

	@Override
	public boolean isDefaultBehaviorEnabled(Unit unit) throws ModelException {
	return unit.isDefaultBehaviourEnabled();
	}

}
