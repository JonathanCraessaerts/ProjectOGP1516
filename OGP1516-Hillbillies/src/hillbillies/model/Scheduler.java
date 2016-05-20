package hillbillies.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;



public class Scheduler {

/** TO BE ADDED TO CLASS HEADING
 * @invar  The Tasks of each Scheduler must be a valid Tasks for any
 *         Scheduler.
 *       | isValidTasks(getTasks())
 */


/**
 * Initialize this new Scheduler with given Tasks.
 *
 * @param  tasks
 *         The Tasks for this new Scheduler.
 * @effect The Tasks of this new Scheduler is set to
 *         the given Tasks.
 *       | this.setTasks(tasks)
 */
public Scheduler(List<Task> tasks)
		throws IllegalArgumentException {
	this.setTasks(tasks);
}


/**
 * Return the Tasks of this Scheduler.
 */
@Basic @Raw
public List<Task> getTasks() {
	return this.tasks;
}

/**
 * Check whether the given Tasks is a valid Tasks for
 * any Scheduler.
 *  
 * @param  Tasks
 *         The Tasks to check.
 * @return 
 *       | result == tasks.size >=1
*/
public static boolean isValidTasks(List<Task> tasks) {
	return tasks.size()>=1;
}

/**
 * Set the Tasks of this Scheduler to the given Tasks.
 * 
 * @param  tasks
 *         The new Tasks for this Scheduler.
 * @post   The Tasks of this new Scheduler is equal to
 *         the given Tasks.
 *       | new.getTasks() == tasks
 * @throws IllegalArgumentException
 *         The given Tasks is not a valid Tasks for any
 *         Scheduler.
 *       | ! isValidTasks(getTasks())
 */
@Raw
public void setTasks(List<Task> tasks) 
		throws IllegalArgumentException {
	if (! isValidTasks(tasks))
		throw new IllegalArgumentException();
	this.tasks = tasks;
}

/**
 * Add a Task to the scheduler
 * @param task
 * 			The task to be added
 * @post  Task has been added to the sheduler
 * 			new.getTasks = old.getTasks + task
 */
public void addTask(Task task){
	List<Task> t = getTasks();
	t.add(task);
	setTasks(t);
}

/**
 * Remove a Task from the scheduler
 * @param task
 * 			The task to be removed
 * @post  Task has been added to the sheduler
 * 			new.getTasks = old.getTasks + task
 */
public void removeTask(Task task){
	List<Task> t = getTasks();
	t.remove(task);
	setTasks(t);
}

/**
 * Replace a task with another task
 * @param removeTask
 * 			the task that has to be replaced
 * @param addTask
 * 			the task that replaces the other task
 * @post	removeTask has been replaced with addTask
 * 			new.getTasks.contains(addTask) && ! new.getTasks.contains(removeTask)	
 * @throws IllegalArgumentException
 * 			the task that has to be replaced is not in task
 * 			! getTasks.contains(removeTask)
 */
public void replaceTask(Task removeTask, Task addTask) throws IllegalArgumentException{
	if (! getTasks().contains(removeTask))
		throw new IllegalArgumentException();
	removeTask(removeTask);
	addTask(addTask);
	
}



/**
 * Check if a set of tasks is in the scheduler
 * @param singleton
 * 		 the tasks to be checked
 * @return
 * 		result == true if getTasks.contains(singleton[0..singleton.size])
 * 		result == false otherwise
 */
public boolean containsTasks(Set<Task> singleton){
	for (Task t : singleton){
		if (! singleton.contains(t))
			return false;
	}
	return true;
}

/**
 * Return the highest priority task
 * @return
 * 		task.getPriority >= getTasks.get(0..size).getPriority
 */
public Task highestPriorTask(){
	Task hpt = getTasks().get(0);
	if (getTasks().size() > 0)
	for (int i = 1; i < getTasks().size(); i++){
		if (getTasks().get(i).getPriority() > hpt.getPriority())
			hpt = getTasks().get(i);
	}
	return hpt;
}

/**
 * Return a list with tasks in descending order of priority
 * @return
 * 		for (int i = 0; i < getTasks().size(); i++)
 * 			getTasks.get(i).getPriority > getTasks.get(i+1).getPriority 
 */
public List<Task> tasksInDescendingPriority(){
	List<Task> tasks = getTasks();
	List<Task> newOrder = new ArrayList<Task>();
	while (! tasks.isEmpty()){
		Task hpt = tasks.get(0);
		if (tasks.size() > 0)
		for (int i = 1; i < tasks.size(); i++){
			if (getTasks().get(i).getPriority() > hpt.getPriority() 
					&& ! getTasks().get(i).isTaskAssigned())
				hpt = getTasks().get(i);
		}
		newOrder.add(hpt);
		tasks.remove(hpt);
	}
	return newOrder;
}

/**
 * Return a list of tasks satisfying a condition
 * @param condition
 * 			the condition that has to be satified
 * @return
 * 		  for (int i = 0; i < tasks().size(); i++)
 * 				tasks.get(i) == condition
 */
public List<Task> tasksSatisfyingCond(Object condition){
	List<Task> tasks = new ArrayList<Task>();
	for (int i = 0; i < getTasks().size(); i++)
		if (getTasks().get(i) == condition)
			tasks.add(tasks.get(i));
	return tasks;
}

/**
 * Assign a task to a unit
 * @param unit
 * 			unit to which the task shall be assigned
 * @param task
 * 			the task that has to be assigned
 * @post
 * 		the task is assigned to the unit
 */
public void assignTaskTo(Unit unit, Task task){
	if (! task.isTaskAssigned())
	task.AssignTo(unit);
}





/**
 * Variable registering the Tasks of this Scheduler.
 */
private List<Task> tasks = new ArrayList<Task>();

}
