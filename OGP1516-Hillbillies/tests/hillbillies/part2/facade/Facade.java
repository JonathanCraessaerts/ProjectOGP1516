package hillbillies.part2.facade;

import hillbillies.model.Unit;
import hillbillies.model.World;
import hillbillies.part2.listener.DefaultTerrainChangeListener;

public class Facade {

	public Object getNbCubesX(World world) {
		return world.getNbCubesX();
	}

	public Object getNbCubesY(World world) {
		return world.getNbCubesY();
	}

	public Object getNbCubesZ(World world) {
		return world.getNbCubesZ();
	}

	public World createWorld(int[][][] is, DefaultTerrainChangeListener defaultTerrainChangeListener) {
		World world = new World(is, defaultTerrainChangeListener);
		return world;
	}

	public Unit createUnit(String string, int[] is, int i, int j, int k, int l, boolean b) {
		Unit unit = new Unit(string, is, i, j, k, l, b);
		return unit;
	}

	public void addUnit(Unit unit, World world) {
		world.addUnit(unit);
	}

	public boolean isSolidConnectedToBorder(World world, int i, int j, int k) {
		return world.isSolidConnectedToBorder(i, j, k);
	}

	public void workAt(Unit unit, int i, int j, int k) {
		unit.workAt(i, j, k);
		
	}

	public Object getCubeType(World world, int i, int j, int k) {
		return world.getCubeType(i, j, k);
	}

}
