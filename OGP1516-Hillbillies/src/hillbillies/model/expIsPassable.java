package hillbillies.model;

public class expIsPassable extends positionExpression {

	protected expIsPassable(Expressions e) throws IllegalArgumentException {
		super(e);

	}

	@Override
	public int[] getPosition() {
		return getPos().getPosition();
	}
	
	
	@Override
	public boolean getBooleanValue() {
		return world.isPassable(getPosition()[0], getPosition()[1], getPosition()[2]);
	}
	
	private World world;

}
