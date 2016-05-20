package hillbillies.model;

public class expWorkshop extends Expressions {

	protected expWorkshop()  {
	}
	
	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public int[] getPosition() {
		return getWorkshopCube();
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}
	
	public int[] getWorkshopCube(){
		for (int i = 0; i < World.getNbCubesX(); i++)
			for (int j =0; j<World.getNbCubesY(); j++)
				for (int k=0; k<World.getNbCubesZ(); k++){
					if (world.getCubeType(i, j, k)==(Object) 3){
						int[] a = {i,j,k};
						return a;
					}
				}
		return null;
	}
	
	private World world;

}
