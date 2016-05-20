package hillbillies.model;

public class expLog extends Expressions{

	protected expLog()  {
	}
	
	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public int[] getPosition() {
		return getLogCube();
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}
	
	public int[] getLogCube(){
		for (int i = 0; i < World.getNbCubesX(); i++)
			for (int j =0; j<World.getNbCubesY(); j++)
				for (int k=0; k<World.getNbCubesZ(); k++){
					if (world.hasLog(i, j, k)==true){
						int[] a = {i,j,k};
						return a;
					}
				}
		return null;
	}
	
	private World world;
}
