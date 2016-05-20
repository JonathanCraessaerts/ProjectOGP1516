package hillbillies.model;


import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;


/** 
 * @invar  The Name of each Task must be a valid Name for any 
 *         Task.
 *       | isValidName(getName())
 */
/** 
 * @invar  The Priority of each Task must be a valid Priority for any
 *         Task.
 *       | isValidPriority(getPriority())
 */

/** 
 * @invar  The Activities of each Task must be a valid Activities for any
 *         Task.
 *       | isValidActivities(getActivities())
 */

public class Task {



/**
 * Initialize this new Task with given Name.
 *
 * @param  Name
 *         The Name for this new Task.
 * @effect The Name of this new Task is set to
 *         the given Name.
 *       | this.setName(Name)
 */
	/**
	 * Initialize this new Task with given Priority.
	 *
	 * @param  Priority
	 *         The Priority for this new Task.
	 * @effect The Priority of this new Task is set to
	 *         the given Priority.
	 *       | this.setPriority(Priority)
	 */	
/**
 * Initialize this new Task with given Activities.
 *
 * @param  activities
 *         The Activities for this new Task.
 * @effect The Activities of this new Task is set to
 *         the given Activities.
 *       | this.setActivities(activities)
 */
public Task(String Name, int Priority, Statements activities)
		throws IllegalArgumentException {
	this.setName(Name);
	this.setPriority(Priority);
	this.setActivities(activities);
}


/**
 * Return the Name of this Task.
 */
@Basic @Raw
public String getName() {
	return this.Name;
}

/**
 * Check whether the given Name is a valid Name for
 * any Task.
 *  
 * @param  Name
 *         The Name to check.
 * @return 
 *       | result == true
*/
public static boolean isValidName(String Name) {
	return true;
}

/**
 * Set the Name of this Task to the given Name.
 * 
 * @param  Name
 *         The new Name for this Task.
 * @post   The Name of this new Task is equal to
 *         the given Name.
 *       | new.getName() == Name
 * @throws IllegalArgumentException
 *         The given Name is not a valid Name for any
 *         Task.
 *       | ! isValidName(getName())
 */
@Raw
public void setName(String Name) 
		throws IllegalArgumentException {
	if (! isValidName(Name))
		throw new IllegalArgumentException();
	this.Name = Name;
}

/**
 * Variable registering the Name of this Task.
 */
private String Name;




/**
 * Return the Priority of this Task.
 */
@Basic @Raw
public int getPriority() {
	return this.Priority;
}

/**
 * Check whether the given Priority is a valid Priority for
 * any Task.
 *  
 * @param  Priority
 *         The Priority to check.
 * @return 
 *       | result == true
*/
public static boolean isValidPriority(int Priority) {
	return false;
}

/**
 * Set the Priority of this Task to the given Priority.
 * 
 * @param  Priority
 *         The new Priority for this Task.
 * @post   The Priority of this new Task is equal to
 *         the given Priority.
 *       | new.getPriority() == Priority
 * @throws IllegalArgumentException
 *         The given Priority is not a valid Priority for any
 *         Task.
 *       | ! isValidPriority(getPriority())
 */
@Raw
public void setPriority(int Priority) 
		throws IllegalArgumentException {
	if (! isValidPriority(Priority))
		throw new IllegalArgumentException();
	this.Priority = Priority;
}

/**
 * Variable registering the Priority of this Task.
 */
private int Priority;






/**
 * Return the Activities of this Task.
 */
@Basic @Raw
public Statements getActivities() {
	return this.activities;
}

/**
 * Check whether the given Activities is a valid Activities for
 * any Task.
 *  
 * @param  Activities
 *         The Activities to check.
 * @return 
 *       | result == 
*/
public static boolean isValidActivities(Statements activities) {
	if (activities == null)
		return false;
	else
		return true;
}

/**
 * Set the Activities of this Task to the given Activities.
 * 
 * @param  activities
 *         The new Activities for this Task.
 * @post   The Activities of this new Task is equal to
 *         the given Activities.
 *       | new.getActivities() == activities
 * @throws ExceptionName_Java
 *         The given Activities is not a valid Activities for any
 *         Task.
 *       | ! isValidActivities(getActivities())
 */
@Raw
public void setActivities(Statements activities) 
		throws IllegalArgumentException {
	if (! isValidActivities(activities))
		throw new IllegalArgumentException();
	this.activities = activities;
}

/**
 * Returns whether a task is assigned to a unit or not
 */
public boolean isTaskAssigned(){
	return isAssigned;
}

/**
 * Assign this task to a unit
 * @param unit
 * 			the unit to which the task is assigned
 */
public void AssignTo(Unit unit){
	this.isAssigned = true;
}
/**
 * Remove this task from the assigned tasks of this unit
 * @param unit
 */
public void UnassignFrom(Unit unit){
	this.isAssigned = false;
}
/**
 * Complete a task
 * @post
 * 		this.isCompleted == true
 */
public void completeTask(){
	this.isCompleted = true;
}
/**
 * Check whether a task is completed or not
 * @return
 * 		whether a task is completed or not
 */
public boolean isCompleted(){
	return this.isCompleted;
}
/*
 * Variable for registering the completion of a task
 */
private boolean isCompleted;

/**
 * Variable registering whether a task is assigned or not
 */
private boolean isAssigned;

/**
 * Variable registering the Activities of this Task.
 */
private Statements activities;

	
}
