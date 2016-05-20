package hillbillies.model;


import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;
import be.kuleuven.cs.som.annotate.Raw;
import hillbillies.part2.listener.DefaultTerrainChangeListener;

/**
 * A class of things that have a weight and a position and can be carried around by units
 *
 * @invar  The Weight of each object must be a valid Weight for any
 *         object.
 *       | isValidwEIGHT(getwEIGHT())
 * @invar  The Position of each object must be a valid Position for any
 *         object.
 *       | isValidPosition(getPosition())
 * @invar  The Holder of each object must be a valid Holder for any
 *         object.
 *       | isValidHolder(getHolder())
 */
public abstract class Objects {
	
	/**
	 * Initialize this new Weight with given Position and given Weight.
	 *
	 * @param  Position
	 *         The Position for this new object.
	 * @param  Weight
	 *         The Weight of this new object.
	 * @param  holder
	 * 		   The holder of this new object
	 * @effect The Position of this new object is set to the given
	 *         Position.
	 * @effect The weight of this new object is set to the given
	 *         weight.
	 * @effect The holder of this new object is set to the given
	 *         holder.
	 *       | setPositionTo(Position)
	 * @effect The Weight of this new Weight is set to the given Weight.
	 *       | setWeight(Weight)
	 */
	@Raw
	@Model
	protected Objects(double[] Position, int Weight, Unit holder)
			throws IllegalArgumentException {
		Random rand = new Random();
		if (! isValidWeight(Weight))
			setWeight(rand.nextInt(maxWeight-minWeight)+minWeight);
		setWeight(Weight);
		setHolder(holder);
		if (! isValidPosition(Position))
			Fall();
		setPosition(Position);
		
	}
	
	
	/**
	 * Creating an object that doesn't have a holder
	 * @param Position
	 * 			The Position of this new object.
	 * @param Weight
	 * 			The Weight of this new object.
	 * @throws IllegalArgumentException
	 */
	@Raw
	@Model
	protected Objects(double[] Position, int Weight)
			throws IllegalArgumentException {
		Random rand = new Random();
		if (! isValidWeight(Weight))
			setWeight(rand.nextInt(maxWeight-minWeight)+minWeight);
		setWeight(Weight);
		if (! isValidPosition(Position))
			Fall();
		setPosition(Position);
		
	}
	
	
	/**
	 * Check whether this object is consumed
	 */
	@Basic
	public boolean isConsumed() {
		return getWeight() == 0;
	}
	
	/**
	 * Consume this object
	 *
	 * @effect The position is unset from this object
	 *       | unsetPosition()
	 * @effect The holder is unset from this object
	 *       | unsetHolder()
	 * @post   The weight of this object is now equal to null cause it got consumed
	 *       | new.setWeight(0)
	 */
	public void Consume() {
		unsetPosition();
		if (hasHolder())
			unsetHolder();
		this.setWeight(0);
	}
	
	/**
	 * Return the Weight of this Object.
	 */
	@Basic
	public int getWeight() {
		return this.Weight;
	}

	/**
	 * Check whether this Object can have the given Weight
	 * as its Weight.
	 * 
	 * @param  Weight
	 *         The Weight to be checked.
	 * @return True if the given Weight is between minWeight and maxWeight (minWeight and maxWeight incl)
	 *       | result == 
	 *       |   ( (Weight >=minWeight) &&
	 *       |     (Weight <= maxWeight )
	 */       
	@Raw
	public boolean isValidWeight(int Weight) {
		return (Weight >= minWeight) && (Weight <= maxWeight);
	}

	/**
	 * Set the Weight of this Object to the given Weight.
	 *
	 * @param  Weight
	 *         The new Weight for this Object.
	 * @return 
	 * @post   The Weight of this Object is the same as the given Weight.
	 *       | new.getWeight() == Weight
	 * @throws IllegalWeightException
	 *         This Object cannot have the given Weight as its Weight.
	 *       | ! canHaveAsWeight(Weight))
	 */
	@Raw
	public void setWeight(int Weight) throws IllegalArgumentException{
		if (!isValidWeight(Weight))
			throw new IllegalArgumentException();
		this.Weight = Weight;
	}

	/**
	 * Variable referencing the Weight of this Object.
	 */
	private int Weight;
	private static int minWeight = 10;
	private static int maxWeight = 50;



/**
 * Initialize this new object with given Position.
 *
 * @param  Position
 *         The Position for this new object.
 * @effect The Position of this new object is set to
 *         the given Position.
 *       | this.setPosition(Position)
 */
public Objects(double[] Position)
		throws IllegalArgumentException {
	this.setPosition(Position);
}


/**
 * Return the Position of this object.
 */
@Basic @Raw
public double[] getPosition() {
	return this.Position;
}

/**
 * Check whether the given Position is a valid Position for
 * any object.
 *  
 * @param  Position
 *         The Position to check.
 * @return 
 *       | result == (Position[0] >= 0) && (Position[0] <= xDim - 1) 
			&& (Position[1] >= 0) && (Position[1] <= yDim - 1)
			&& (Position[2] >= 0) && (Position[2] <= zDim- 1)
			&& world.isPassable(Position[0],Position[1],Position[2]);
*/
public static boolean isValidPosition(double[] Position) {
	try {
		int x = (int) Math.floor(Position[0]);
		int y = (int) Math.floor(Position[1]);
		int z = (int) Math.floor(Position[2]);
	return (Position[0] >= 0) && (Position[0] <= xDim - 1) 
			&& (Position[1] >= 0) && (Position[1] <= yDim - 1)
			&& (Position[2] >= 0) && (Position[2] <= zDim- 1)
			&& world.isPassable(x,y,z);
	}
	catch (NullPointerException exc){
		assert (Position == null);
		return true;
	}
}

/**
 * Set the Position of this object to the given Position.
 * 
 * @param  Position
 *         The new Position for this object.
 * @post   The Position of this new object is equal to
 *         the given Position.
 *       | new.getPosition() == Position
 * @throws IllegalArgumentException
 *         The given Position is not a valid Position for any
 *         object.
 *       | ! isValidPosition(getPosition())
 */
@Raw
public void setPosition(double[] Position) 
		throws IllegalArgumentException {
	if (! isValidPosition(Position))
		throw new IllegalArgumentException();
	this.Position = Position;
}

/**
 * Unset the Position, if any, from this object
 *
 * @post   This object no longer has an Position.
 *       | getPosition() == null
 */
public void unsetPosition() {
	if (getPosition() != null) {
		setPosition(null);
	}
}


/**
 * Variable registering the Position of this object.
 */
private double[] Position;
private static int xDim = World.getNbCubesX();
private static int zDim = World.getNbCubesY();
private static int yDim = World.getNbCubesZ();









/**
 * Return the Holder of this object.
 */
@Basic @Raw
public Unit getHolder() {
	return this.holder;
}

/**
 * Check whether the given Holder is a valid Holder for
 * any object.
 *  
 * @param  Holder
 *         The Holder to check.
 * @return 
 *       | every unit in world is a valid holder
*/
public static boolean isValidHolder(Unit holder) {
	return true;
}

/**
 * Check whether this object has an Holder.
 *
 * @return True if and only if the Holder of this object is effective.
 *       | result == (getHolder() != null)
 */
@Raw
public boolean hasHolder() {
	return getHolder() != null;
}

/**
 * Set the Holder of this object to the given Holder.
 *
 * @param  Holder
 *         The new Holder for this object.
 * @post   The Holder of this object is the same as the given Holder.
 *       | new.getHolder() == Holder
 * @post   The given Holders Weight is increased with the weight of the object
 *       | Holder.setWeight(Holder.getWeight() + this.getWeight());
 * @throws IllegalArgumentException
 *         The given Holder is not effective or it cannot hold this object
 *       | (Holder == null) ||
 *       |   (! isValidHolder(Holder))
 * @throws IllegalStateException
 *         This object already has a Holder.
 *       | hasHolder()
 */
public void setHolderTo(Unit Holder)throws IllegalArgumentException{
	if ((Holder == null) || (! isValidHolder(Holder)))
		throw new IllegalArgumentException();
	if (this.hasHolder())
		throw new IllegalStateException("Already has Holder!");
	unsetPosition();
	setHolder(Holder);
	Holder.setWeight(Holder.getWeight() + this.getWeight());
}

/**
 * Set the Holder of this object to the given Holder.
 * 
 * @param  holder
 *         The new Holder for this object.
 * @post   The Holder of this new object is equal to
 *         the given Holder.
 *       | new.getHolder() == holder
 * @throws IllegalArgumentException
 *         The given Holder is not a valid Holder for any
 *         object.
 *       | ! isValidHolder(getHolder())
 */
@Raw
public void setHolder(Unit holder) 
		throws IllegalArgumentException {
	if (! isValidHolder(holder))
		throw new IllegalArgumentException();
	this.holder = holder;
}

/**
 * Unset the holder, if any, from this object.
 *
 * @post   This object no longer has an holder.
 *       | ! new.hasholder()
 * @post   The former holder of this object, if any, no longer
 *         has this object as one of its objects.
 *       |    (getholder() == null)
 *       | || (! (new getholder()).hasAsobject(object))
 *@post   The position of the object is the same as the position of the former holder
 *		| new.getPosition == getHolder.getCenterPosition()
 *@post the weight of the formerholder is his prev weight - the weight of the object
 *		|new.formerholder.getWeight() == old.formerholder.getWeight() - this.getWeight()
 *		
 */
public void unsetHolder() {
	if (hasHolder()) {
		Unit formerholder = this.getHolder();
		setPosition(formerholder.getCenterPosition());
		formerholder.setWeight(formerholder.getWeight() - this.getWeight());
		setWeight(this.getWeight());
		setHolder(null);
	}
}


/**
 * Variable registering the Holder of this object.
 */
private Unit holder;


/**
 * Method to advance time in the game
 * @param deltaT
 * 			difference in time 0 <= deltaT <= 0.2 in seconds
 */
public void advanceTime(double deltaT){
	double d = deltaT/dt;
	int i = 0;
	while (i < d){
	this.setTime(this.getTime() + dt);
	i++;
	}

}
/**
 *Returns the current Time
 */
public double getTime() {
	return Time;
}

/**
 * Sets the current Time to time
 * @param time
 * 			the Time that has to be set
 */
public void setTime(double time) {
	Time = time;
}

private double Time;
private double dt = 0.2;

/**
 * Makes an object fall if the cube under it is passable
 * @param world
 * 			| the world in which the object exists
 * @post 	if there is a passable cube under the object and z coordinate is not 0
 * 			| while (world.isPassable(x,y,z-1) && z > 0
 * 			|    new.setPosition(x,y,z-1)	
 */
public void Fall(){
	double[] p = getPosition();
	int x = (int) Math.floor(p[0]);
	int y = (int) Math.floor(p[1]);
	int z = (int) Math.floor(p[2]);
	boolean canFall = false;
	int v = -3;
	
	if (world.isPassable(x,y,z-1) && z != 0)
		canFall = true;
	if (canFall == true){
		double dt = Unit.Lc/v;
		advanceTime(dt);
		z--;
		double[] p2 = {x,y,z};
		this.setPosition(p2);
		if (world.isPassable(x, y, z) && z > 0)
			Fall();
			
	}
	
}
/**
 * Variable referencing to the world this unit belongs to
 */
private static World world = new World(new int[xDim][yDim][zDim], new DefaultTerrainChangeListener());


}
