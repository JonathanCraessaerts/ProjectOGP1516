package hillbillies.model;

public class expBoulder extends Expressions{

	
	protected expBoulder()  {
	}
	
	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public int[] getPosition() {
		return getBoulderCube();
	}

	@Override
	public boolean getBooleanValue() {
		return false;
	}
	
	public int[] getBoulderCube(){
		for (int i = 0; i < World.getNbCubesX(); i++)
			for (int j =0; j<World.getNbCubesY(); j++)
				for (int k=0; k<World.getNbCubesZ(); k++){
					if (world.hasBoulder(i, j, k)==true){
						int[] a = {i,j,k};
						return a;
					}
				}
		return null;
	}
	
	private World world;

}
