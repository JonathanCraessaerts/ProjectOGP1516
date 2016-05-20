package hillbillies.model;

public class expNextTo extends positionExpression {

	protected expNextTo(Expressions e) throws IllegalArgumentException {
		super(e);

	}
	
	
	public int[] getNextPos(){
		int[] p = getPos().getPosition();
		if (world.isPassable(p[0]+1, p[1], p[2])){
			int[] pos = {p[0]+1, p[1], p[2]};
			return pos;
		}
		else if (world.isPassable(p[0]-1, p[1], p[2])){
			int[] pos = {p[0]-1, p[1], p[2]};
			return pos;
		}
		else if (world.isPassable(p[0], p[1]+1, p[2])){
			int[] pos = {p[0], p[1]+1, p[2]};
			return pos;
		}
		else if (world.isPassable(p[0]-1, p[1]-1, p[2])){
			int[] pos = {p[0], p[1]-1, p[2]};
			return pos;
		}
		else if (world.isPassable(p[0], p[1], p[2]+1)){
			int[] pos = {p[0], p[1], p[2]+1};
			return pos;
		}
		else {
			int[] pos = {p[0], p[1], p[2]-1};
			return pos;
		}
			
	}


	@Override
	public int[] getPosition() {
		return getNextPos();
	}
	
	private World world;
}