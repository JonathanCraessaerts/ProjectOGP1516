package hillbillies.part3.facade;

import java.util.Set;

import hillbillies.model.Expressions;
import hillbillies.model.Faction;
import hillbillies.model.Scheduler;
import hillbillies.model.Statements;
import hillbillies.model.Task;
import hillbillies.model.TaskFactory;
import hillbillies.model.Unit;
import hillbillies.model.World;
import hillbillies.part2.listener.DefaultTerrainChangeListener;
import hillbillies.part3.programs.ITaskFactory;

public class Facade {

	public World createWorld(int[][][] types, DefaultTerrainChangeListener defaultTerrainChangeListener) {
		World world = new World(types, defaultTerrainChangeListener);
		return world;
	}

	public Unit createUnit(String string, int[] is, int i, int j, int k, int l, boolean b) {
		Unit unit = new Unit(string, is, i, j, k, l, b);
		return unit;
	}

	public void addUnit(Unit unit, World world) {
		world.addUnit(unit);
		
	}

	public Faction getFaction(Unit unit) {
		return unit.getFaction();
	}

	public Scheduler getScheduler(Faction faction) {
	return faction.getScheduler();
	}

	public Object getName(Task task) {
		return task.getName();
	}

	public Object getPriority(Task task) {
		return task.getPriority();
	}

	public void schedule(Scheduler scheduler, Task task) {
		scheduler.addTask(task);
	}

	public Object getCubeType(World world, int i, int j, int k) {
		return world.getCubeType(i, j, k);
	}

	public boolean areTasksPartOf(Scheduler scheduler, Set<Task> singleton) {
		return scheduler.containsTasks(singleton);
	}

	public void advanceTime(World world, double step) {
		world.advanceTime(step);
		
	}

	public ITaskFactory<Expressions, Statements, Task> createTaskFactory() {
		 ITaskFactory<Expressions, Statements, Task> factory = new TaskFactory();
		return factory;
	}

}
