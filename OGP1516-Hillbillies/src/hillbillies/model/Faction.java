package hillbillies.model;


import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;
/** 
 * @invar  The Factionsize of each faction must be a valid Factionsize for any
 *         faction.
 *       | isValidFactSize(getFactSize())
 */
/**
 
* @invar   Each share must have a valid name.
*        | canHaveAsname(getname())
*/        
public class Faction {



/**
 * Initialize this new faction with given Factionsize.
 *
 * @param  Factsize
 *         The Factionsize for this new faction.
 * @effect The Factionsize of this new faction is set to
 *         the given Factionsize.
 *       | this.setFactSize(Factsize)
 */
public Faction(String name, int Factsize) throws IllegalArgumentException{
	if (! isValidFactSize(Factsize))
		throw new IllegalArgumentException("invalid factionsize");
	setFactSize(Factsize);
	this.name = name;
	allNames.add(name);

}

/**
 * Return this faction
 */
@Basic
@Raw
public List<Unit> getFaction() {
	return this.faction;
}


/**
 * Initialize this new faction as a non-terminated faction with given
 * name and no units in it yet
 * 
 * @param  name
 *         The name for this new faction
 * @effect This new faction is initialized with the given name
 *         and no units
 *       | this(name,0)
 */
@Raw
public Faction(String name) throws IllegalArgumentException {
	this(name, 0);
}

/**
 * Return the name ascribed to this faction
 */
@Basic
@Raw
public String getName() {
	return this.name;
}

public Faction getFactionFromName(String name){
	if (this.getName() == name)
		return this;
	else
		return null;
}

/**
 * Check whether the given name is a valid name for this faction
 * 
 * @param  name
 *         The name to check.
 * @return False if the given name is not effective
 *       | if ( (name != null) 
 *       |   then result == false
 *         Otherwise true if and only if if the given name is
 *         not ascribed to another non-terminated faction
 *       | else result ==
 *       |   for each faction in Faction
 *       |     ( faction.isExtinct() ||
 *       |       (faction == this) ||
 *       |       (! faction.getname().equals(name)) )
 */
@Raw
public boolean canHaveAsName(String name) {
	if ((name == null))
		return false;
	return name.equals(this.getName()) || (!allNames.contains(name));
}

/**
 * Variable referencing the name ascribed to this share.
 */
private final String name;

/**
 * Variable collecting all the names of non extinct factions
 */
private static final SortedSet<String> allNames = new TreeSet<String>();


/**
 * Enumeration of all possible states of a faction
 */
private static enum State {
	ALIVE, EXTINCT;
}
/**
 * Check whether this faction is extinct
 */
@Basic @Raw
public boolean isExtinct() {
	return this.getState() == State.EXTINCT;
}
/**
 * Check whether this faction is alive
 */
@Basic @Raw
public boolean isAlive() {
	return this.getState() == State.ALIVE;
}

/**
 * Check whether this faction has a proper state.
 * 
 * @return True if and only if this faction is either alive or extinct
 *       | result == isOrdered() ^ isGranted() ^ isTerminated()
 */
@Raw
public boolean isValidState() {
	return isAlive() || isExtinct();
}


/**
 * Return the state of this faction
 */
@Raw
private State getState() {
	return this.state;
}
/**
 * Variable registering the state of this faction
 */
private State state = State.ALIVE;

/**
 * Set the state of this faction to the given state.
 * 
 * @param  state
 *         The new state for this faction
 * @pre    The given state must be effective.
 *       | state != null
 * @post   The state of this purchase is the same as the
 *         given state.
 *       | new.getState() == state
 */
private void setState(State state) {
	assert (state != null);
	this.state = state;
}

public void Extinct(){
	assert(getFactSize() == 0);
	if (! isExtinct()){
			setState(State.EXTINCT);
			allNames.remove(this.getName());
	}
}


/**
 * Return the Factionsize of this faction.
 */
@Basic @Raw
public int getFactSize() {
	int a = faction.size();
	this.Factsize = a;
	return this.Factsize;
}

/**
 * Check whether the given Factionsize is a valid Factionsize for
 * any faction.
 *  
 * @param  Factionsize
 *         The Factionsize to check.
 * @return 
 *       | result == 0 < Factsize <= maxFactSize
*/
public static boolean isValidFactSize(int Factsize) {
	return (0 <= Factsize && Factsize <= maxFactSize);
}

/**
 * Set the Factionsize of this faction to the given Factionsize.
 * 
 * @param  Factsize
 *         The new Factionsize for this faction.
 * @post   The Factionsize of this new faction is equal to
 *         the given Factionsize.
 *       | new.getFactSize() == Factsize
 * @throws IllegalArgumentException
 *         The given Factionsize is not a valid Factionsize for any
 *         faction.
 *       | ! isValidFactSize(getFactSize())
 */
@Raw
public void setFactSize(int Factsize) 
		throws IllegalArgumentException {
	if (! isValidFactSize(Factsize))
		throw new IllegalArgumentException("Invalid fact size");
	this.Factsize = Factsize;
}

/**
 * Check whether this unit has the given faction as his faction
 * 
 * @param unit
 * 			the units faction that has to be checked
 * @return
 * 		whether the unit is in the faction or not
 */
public boolean hasAsFaction(Unit unit) {
	return faction.contains(unit);
}

/**
 * Add the given unit to the faction
 * 
 * @param  unit
 * 			the unit that needs to be added to the faction 
 * @post
 * 		the unit has been added to the faction
 * @post 
 * 		add 1 to the factionsize 
 */
public void addUnitToFact(Unit unit) {
	assert (unit != null)&& (!this.hasAsFaction(unit));
	faction.add(unit);
	int a = getFactSize();
	setFactSize(++a);
	
}

/**
 * Remove the given unit from the faction
 * @param unit
 * 			the unit that has to be removed
 * @post
 * 		unit has been removed from faction
 * @post
 * 		lower the factionsize with 1
 */
@Raw
public void removeUnitFromFact(Unit unit) {
	assert (unit != null) && this.hasAsFaction(unit);
	faction.remove(unit);
	int a = getFactSize();
	setFactSize(--a);
}

/**
 * Returns a list of all units in this faction
 * @return
 * 			| result == List[getFactSize()]
 */
public List<Unit> getAllUnitsFromFaction(){
	List<Unit> allFact = new ArrayList<Unit>();
	for (Unit key : getFaction()) 
		allFact.add(key);
	assert allFact.size() == getFactSize();
	return allFact;
	
}

/**
 * Variable referencing a list collecting all the units that are involved in this faction
 * 
 * @invar  The referenced list is effective.
 *       | faction != null
 * @invar  Each unit registered in the referenced list is
 *         effective and not yet killed
 *       | for each unit in faction:
 *       |   ( (unit != null) &&
 *       |     (! unit.isDeath()) )
 */
private final List<Unit> faction = new ArrayList<Unit>();


/**
 * Variable registering the Factionsize of this faction.
 */
private int Factsize;
private static int maxFactSize = 50;

/**
 * Return the scheduler of this faction
 */
public Scheduler getScheduler(){
	return this.scheduler;
}
/**
 * set the given scheduler as the scheduler of this faction
 */
public void setScheduler(Scheduler sched){
	this.scheduler = sched;
}


private Scheduler scheduler;


}
