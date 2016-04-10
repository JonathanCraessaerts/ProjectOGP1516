package hillbillies.model;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;

import be.kuleuven.cs.som.annotate.Raw;

import ogp.framework.util.Util;



/** 
 * @invar  Each Unit can have its Position as Position.
 *       | canHaveAsPoistion(this.getPoistion())
 */
/** 
 * @invar  The Name of each Unit must be a valid Name for any
 *         Unit.
 *       | isValidName(getName())
 */
/**
 * @invar  The Strength of each Unit must be a valid Strength for any
 *         Unit.
 *       | isValidStength(getStength())
 */
/**
 * @invar  The Agility of each Unit must be a valid Agility for any
 *         Unit.
 *       | isValidAgility(getAgility())
 */
/**
 * @invar  The Toughness of each Unit must be a valid Toughness for any
 *         Unit.
 *       | isValidToughness(getToughness())
 */
/**
 * @invar  The Weight of each Unit must be a valid Weight for any
 *         Unit.
 *       | isValidWeight(getWeight())
 */
/**
 * @invar  The Stamina of each Unit must be a valid Stamina for any
 *         Unit.
 *       | isValidStamina(getStamina())
 */
/**
 * @invar  The Hitpoints of each Unit must be a valid Hitpoints for any
 *         Unit.
 *       | isValidHitpoints(getHitpoints())
 */
/**
 * @invar  The Orientation of each Unit must be a valid Orientation for any
 *         Unit.
 *       | isValidOrientation(getOrientation())
 */


public class Unit {
	

//=======POSITION========	
	
/**
 * Initialize this new Unit with given Position.
 * 
 * @param  Position
 *         The Position for this new Unit.
 * @post   The Position of this new Unit is equal to the given
 *         Position.
 *       | new.getPoistion() == Position
 * @throws IllegalArgumentException
 *         This new Unit cannot have the given Position as its Position.
 *       | ! canHaveAsPoistion(this.getPoistion())
 */
	/**
	 * Initialize this new Unit with given Name.
	 *
	 * @param  Name
	 *         The Name for this new Unit.
	 * @effect The Name of this new Unit is set to
	 *         the given Name.
	 *       | this.setName(Name)
	 */

/**
 * Initialize this new Unit with given Strength.
 * 
 * @param  Strength
 *         The Strength for this new Unit.
 * @post   If the given Strength is a valid Strength for any Unit,
 *         the Strength of this new Unit is equal to the given
 *         Strength. Otherwise, the Strength of this new Unit is equal
 *         to value between (maxInitStrength - minInitStrength) + minInitStrength.
 *       | if (isValidStength(Strength))
 *       |   then new.getStength() == Strength
 *       |   else new.getStength() == value between 
 *       |	(maxInitStrength - minInitStrength) + minInitStrength
 */



/**
 * Initialize this new Unit with given Agility.
 * 
 * @param  Agility
 *         The Agility for this new Unit.
 * @post   If the given Agility is a valid Agility for any Unit,
 *         the Agility of this new Unit is equal to the given
 *         Agility. Otherwise, the Agility of this new Unit is equal
 *         to value between (maxInitAgility - minInitAgility) + minInitAgility.
 *       | if (isValidAgility(Agility))
 *       |   then new.getAgility() == Agility
 *       |   else new.getAgility() == value between 
 *       |			(maxInitAgility - minInitAgility) + minInitAgility
 */




/**
 * Initialize this new Unit with given Toughness.
 * 
 * @param  Toughness
 *         The Toughness for this new Unit.
 * @post   If the given Toughness is a valid Toughness for any Unit,
 *         the Toughness of this new Unit is equal to the given
 *         Toughness. Otherwise, the Toughness of this new Unit is equal
 *         to value between (maxInitThoughness - minInitThoughness) 
		+ minInitThoughness.
 *       | if (isValidToughness(Toughness))
 *       |   then new.getToughness() == Toughness
 *       |   else new.getToughness() == value between 
 *       |		(maxInitThoughness - minInitThoughness) + minInitThoughness
 */



/**
 * Initialize this new Unit with given Weight.
 * 
 * @param  Weight
 *         The Weight for this new Unit.
 * @post   If the given Weight is a valid Weight for any Unit,
 *         the Weight of this new Unit is equal to the given
 *         Weight. Otherwise, the Weight of this new Unit is equal
 *         to random value between (maxInitWeight - minInitWeight) 
		+ minInitWeight
 *       |   then new.getWeight() == Weight
 *       |   else new.getWeight() == random value between 
 *       | 			(maxInitWeight - minInitWeight) + minInitWeight;
 */

	
public Unit(String Name, int[] Position, int Weight, 
		int Agility,  int Strength, int Toughness, boolean enableDefaultBehaviour) 
				throws IllegalArgumentException {
	double x = (Position[0]);
	double y = (Position[1]);
	double z = (Position[2]);
	double[] p = {x,y,z};
	if (! canHaveAsPoistion(p))
		Fall();
	setPosition(p);
	this.setName(Name);
	Random rand = new Random();
	if (! isValidInitStength(Strength))
		Strength = rand.nextInt(maxInitStrength - minInitStrength) + minInitStrength;
	setStength(Strength);
	if (! isValidInitAgility(Agility))
		Agility = rand.nextInt(maxInitAgility - minInitAgility) + minInitAgility;
	setAgility(Agility);
	if (! isValidInitThoughness(Toughness))
		Toughness = rand.nextInt(maxInitThoughness - minInitThoughness) 
		+ minInitThoughness;
	setToughness(Toughness);
	if (! isValidInitWeight(Weight))
		Weight = rand.nextInt(maxInitWeight - minInitWeight) 
		+ minInitWeight;
	setWeight(Weight);
	if (enableDefaultBehaviour == true)
		startDefaultBehaviour(enableDefaultBehaviour);
}


/**
 * Return the Position of this Unit.
 */
@Basic @Raw
public double[] getPoistion() {
	return this.Position;
}
/**
 * 
 * @return the center of the position of this unit
 */
public double[] getCenterPosition(){
	double x = getOccupiedGameCube(getPoistion())[0] + 0.5;
	double y = getOccupiedGameCube(getPoistion())[1] + 0.5;
	double z = getOccupiedGameCube(getPoistion())[2] + 0.5;
	double [] pos = {x,y,z};
	return pos;
	
}
/**
 * 
 * @param Position
 * 			The position of a Unit
 * 
 * @return
 * 			| new.getOccupiedGameCube == Position
 */
public long[] getOccupiedGameCube(double[] Position){
	long x = Math.round(Position[0]);
	long y = Math.round(Position[1]);
	long z = Math.round(Position[2]);
	long [] OccupiedGameCube = {x, y, z};
	return OccupiedGameCube;
}

/**
 * Set the Position of this Unit to the given Position.
 * 
 * @param  Position
 *         The new Position for this Unit.
 * @post   The Position of this new Unit is equal to
 *         the given Position.
 *       | new.getPosition() == Position
 * @throws IllegalArgumentException
 *         The given Position is not a valid Position for any
 *         Unit.
 *       | ! canHaveAsPosition(getPosition())
 */
@Raw
public void setPosition(double[] position) 
		throws IllegalArgumentException {
	if (! canHaveAsPoistion(position))
		throw new IllegalArgumentException("A Unit can not have this position");
	this.Position = position;
}

/**
 * Check whether this Unit can have the given Position as its Position.
 *  
 * @param  Position
 *         The Position to check.
 * @return 
 *       | (0 < Xpos < maxX - 1) && (0 < Ypos < maxY-1) && (0 < Zpos < maxZ-1)
 *       | && world.isPassable(x, y, z);
*/
@Raw
public boolean canHaveAsPoistion(double[] Position) {
	int x = (int) Math.floor(Position[0]);
	int y = (int) Math.floor(Position[1]);
	int z = (int) Math.floor(Position[2]);
	return (Position[0] >= 0) && (Position[0] <= maxX - 1) 
			&& (Position[1] >= 0) && (Position[1] <= maxY - 1)
			&& (Position[2] >= 0) && (Position[2] <= maxZ - 1)
			&& world.isPassable(x, y, z);
	
}

/**
 * Variable registering the Position of this Unit.
 */

static int[] initialPosition ;
private double Xpos;
private double Ypos;
private double Zpos;
private double[] Position = {Xpos, Ypos, Zpos};

private static double maxX = 50;
private static double maxY = 50;
private static double maxZ = 50;





//=======NAME FUNCTIONS=====





/**
 * Return the Name of this Unit.
 */
@Basic @Raw
public String getName() {
	return this.Name;
}

/**
 * Check whether the given Name is a valid Name for
 * any Unit.
 *  
 * @param  Name
 *         The Name to check.
 * @return 
 *       | for i in range(Name)
 *       | Name[i] == [a-z, A-Z, " ", "'", """]
 *       | name.length >= 2
*/
public boolean isValidName(String Name) {
 	if (Name.length() < 2)
 		return false;
 	else{
	String allowedChar = "^[a-zA-Z(\\s)(\')(\")]+$";
		if ((Name.matches(allowedChar)))
			return true;
		else
			return false;
	}
	 
}

/**
 * Set the Name of this Unit to the given Name.
 * 
 * @param  Name
 *         The new Name for this Unit.
 * @post   The Name of this new Unit is equal to
 *         the given Name.
 *       | new.getName() == Name
 * @throws IllegalArgumentException
 *         The given Name is not a valid Name for any
 *         Unit.
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
 * Variable registering the Name of this Unit.
 */
private String Name;



// ==========WEIGTH, STRENGTH, AGILITY, THOUGHNESS=======

/**
 * Check whether the given Strength is a valid Initial Strength for
 * any Unit.
 *  
 * @param  Strength
 *         The Strength to check.
 * @return 
 *       | return (minInitStrength <= Strength) && (Strength <= maxInitStrength)
*/
public boolean isValidInitStength(int Strength) {
	return (minInitStrength <= Strength) && (Strength <= maxInitStrength);
	
}
/**
 * Check whether the given Strength is a valid Initial Strength for
 * any Unit.
 *  
 * @param  Strength
 *         The Strength to check.
 * @return 
 *       | return (minInitAgility <= Agility) && (Agility <= maxInitAgility)
*/
public boolean isValidInitAgility(int Agility) {
	return (minInitAgility <= Agility) && (Agility <= maxInitAgility);
	
}

/**
 * Check whether the given Strength is a valid Initial Strength for
 * any Unit.
 *  
 * @param  Strength
 *         The Strength to check.
 * @return 
 *       | return (minInitThoughness <= Thoughness) && (Thoughness <= maxInitThoughness)
*/
public boolean isValidInitThoughness(int Thoughness) {
	return (minInitThoughness <= Thoughness) && (Thoughness <= maxInitThoughness);
	
}


/**
 * Check whether the given Strength is a valid Initial Strength for
 * any Unit.
 *  
 * @param  Strength
 *         The Strength to check.
 * @return 
 *       | return (minInitWeight <= Weight) && (Weight <= maxInitWeight)
*/
public boolean isValidInitWeight(int Weight) {
	return (minInitWeight <= Weight) && (Weight <= maxInitWeight);
	
}

/**
 * Cte for the min and max init Strength, Agility, Toughness and Weight
 */
public static int minInitStrength = 25;
public static int maxInitStrength = 100;
public static int minInitAgility = 25;
public static int maxInitAgility = 100;
public static int minInitThoughness = 25;
public static int maxInitThoughness = 100;
private int minInitWeight = MinWeight();
public static int maxInitWeight = 200;


/**
 * Return the Strength of this Unit.
 */
@Basic @Raw
public int getStength() {
	return this.Strength;
}

/**
 * Check whether the given Strength is a valid Strength for
 * any Unit.
 *  
 * @param  Strength
 *         The Strength to check.
 * @return 
 *       | return (minStrength <= Strength) && (Strength <= maxStrength)
*/
public boolean isValidStength(int Strength) {
	return (minStrength <= Strength) && (Strength <= maxStrength);
	
}

/**
 * Set the Strength of this Unit to the given Strength.
 * 
 * @param  Strength
 *         The new Strength for this Unit.
 * @post   If the given Strength is a valid Strength for any Unit,
 *         the Strength of this new Unit is equal to the given
 *         Strength.
 *       | if (isValidStength(Strength))
 *       |   then new.getStength() == Strength
 */
@Raw
public void setStength(int Strength) {
	if (isValidStength(Strength))
		this.Strength = Strength;
}

/**
 * Variable registering the Strength of this Unit.
 */
private int Strength;

/**
 * Cte that gives the max and min Strength
 */
private int maxStrength = 200;
private int minStrength = 1;

/**
 * Return the Agility of this Unit.
 */
@Basic @Raw
public int getAgility() {
	return this.Agility;
}

/**
 * Check whether the given Agility is a valid Agility for
 * any Unit.
 *  
 * @param  Agility
 *         The Agility to check.
 * @return 
 *       | return (1 <= Agility) && (Agility <= 200)
*/
public boolean isValidAgility(int Agility) {
	return (minAgility <= Agility) && (Agility <= maxAgility);
	
}

/**
 * Set the Agility of this Unit to the given Agility.
 * 
 * @param  Agility
 *         The new Agility for this Unit.
 * @post   If the given Agility is a valid Agility for any Unit,
 *         the Agility of this new Unit is equal to the given
 *         Agility.
 *       | if (isValidAgility(Agility))
 *       |   then new.getAgility() == Agility
 */
@Raw
public void setAgility(int Agility) {
	if (isValidAgility(Agility))
		this.Agility = Agility;
}

/**
 * Variable registering the Agility of this Unit.
 */
private int Agility;

/**
 * Cte for the max and min Agility
 */
private int maxAgility = 200;
private int minAgility = 1;

/**
 * Return the Toughness of this Unit.
 */
@Basic @Raw
public int getToughness() {
	return this.Toughness;
}

/**
 * Check whether the given Toughness is a valid Toughness for
 * any Unit.
 *  
 * @param  Toughness
 *         The Toughness to check.
 * @return 
 *       | return (minThoughness <= Toughness) && (Toughness <= maxThoughness)
*/
public boolean isValidToughness(int Toughness) {
	return (minThoughness <= Toughness) && (Toughness <= maxThoughness);
	
}

/**
 * Set the Toughness of this Unit to the given Toughness.
 * 
 * @param  Toughness
 *         The new Toughness for this Unit.
 * @post   If the given Toughness is a valid Toughness for any Unit,
 *         the Toughness of this new Unit is equal to the given
 *         Toughness.
 *       | if (isValidToughness(Toughness))
 *       |   then new.getToughness() == Toughness
 */
@Raw
public void setToughness(int Toughness) {
	if (isValidToughness(Toughness))
		this.Toughness = Toughness;
}

/**
 * Variable registering the Toughness of this Unit.
 */
private int Toughness;

/**
 * Cte for the max and min Toughness
 */

private int maxThoughness = 200;
private int minThoughness = 1;


/**
 * Return the Weight of this Unit.
 */
@Basic @Raw
public int getWeight() {
	return this.Weight;
}

/**
 * Check whether the given Weight is a valid Weight for
 * any Unit.
 *  
 * @param  Weight
 *         The Weight to check.
 * @return 
 *       | return (minWeight <= Weight) && (Weight <= maxWeight)
*/
public boolean isValidWeight(int Weight) {
	return ( this.MinWeight()<= Weight) && (Weight <= maxWeight);
}

/**
 * Set the Weight of this Unit to the given Weight.
 * 
 * @param  Weight
 *         The new Weight for this Unit.
 * @post   If the given Weight is a valid Weight for any Unit,
 *         the Weight of this new Unit is equal to the given
 *         Weight.
 *       | if (isValidWeight(Weight))
 *       |   then new.getWeight() == Weight
 */
@Raw
public void setWeight(int Weight) {
	if (isValidWeight(Weight))
		this.Weight = Weight;
}

/**
 * Variable registering the Weight of this Unit.
 */
private int Weight;
/**
 * Var & method to give the min and max Weight of a unit
 */
private int minWeight;
private int maxWeight = 200;

public int MinWeight(){
	 int minWeight = ((getAgility() + getStength())/2);
	 this.minWeight = minWeight;
	 return this.minWeight;
}



//=======STAMINA, HITPOINTS=======


/**
 * Initialize this new Unit with given Stamina.
 * 
 * @param  Stamina
 *         The Stamina for this new Unit.
 * @pre    The given Stamina must be a valid Stamina for any Unit.
 *       | isValidStamina(Stamina)
 * @post   The Stamina of this new Unit is equal to the given
 *         Stamina.
 *       | new.getStamina() == Stamina
 */
/**
 * Initialize this new Unit with given Hitpoints.
 * 
 * @param  Hitpoints
 *         The Hitpoints for this new Unit.
 * @pre    The given Hitpoints must be a valid Hitpoints for any Unit.
 *       | isValidHitpoints(Hitpoints)
 * @post   The Hitpoints of this new Unit is equal to the given
 *         Hitpoints.
 *       | new.getHitpoints() == Hitpoints
 */

public Unit(int Stamina, int Hitpoints) {
	this.setStamina(Stamina);
	this.setHitpoints(Hitpoints);
}

/**
 * Return the Stamina of this Unit.
 */
@Basic @Raw
public int getStamina() {
	return this.Stamina;
}

/**
 * Check whether the given Stamina is a valid Stamina for
 * any Unit.
 *  
 * @param  Stamina
 *         The Stamina to check.
 * @return 
 *       | result == 0 <= Stamina <= (200 * Weight / 100 * Toughness / 100)
*/
public boolean isValidStamina(int Stamina) {
	return (0 <= Stamina) && 
			(Stamina <= this.maxStamina());
}

/**
 * Set the Stamina of this Unit to the given Stamina.
 * 
 * @param  Stamina
 *         The new Stamina for this Unit.
 * @pre    The given Stamina must be a valid Stamina for any
 *         Unit.
 *       | isValidStamina(Stamina)
 * @post   The Stamina of this Unit is equal to the given
 *         Stamina.
 *       | new.getStamina() == Stamina
 */
@Raw
public void setStamina(int Stamina) {
	assert isValidStamina(Stamina);
	this.Stamina = Stamina;
}

/**
 * Variable registering the Stamina of this Unit.
 */
private int Stamina;


/**
 * Return the Hitpoints of this Unit.
 */
@Basic @Raw
public int getHitpoints() {
	return this.Hitpoints;
}

/**
 * Check whether the given Hitpoints is a valid Hitpoints for
 * any Unit.
 *  
 * @param  Hitpoints
 *         The Hitpoints to check.
 * @return 
 *       | result == 0 <= Hitpoints <= (200 * Weight / 100 * Toughness / 100)
*/
public boolean isValidHitpoints(int Hitpoints) {
	return (0 <= Hitpoints) && 
			(Hitpoints <= this.maxHP());
}

/**
 * Set the Hitpoints of this Unit to the given Hitpoints.
 * 
 * @param  Hitpoints
 *         The new Hitpoints for this Unit.
 * @pre    The given Hitpoints must be a valid Hitpoints for any
 *         Unit.
 *       | isValidHitpoints(Hitpoints)
 * @post   The Hitpoints of this Unit is equal to the given
 *         Hitpoints.
 *       | new.getHitpoints() == Hitpoints
 */
@Raw
public void setHitpoints(int Hitpoints) {
	assert isValidHitpoints(Hitpoints);
	this.Hitpoints = Hitpoints;
}

/**
 * Variable registering the Hitpoints of this Unit.
 */
private int Hitpoints;

/**
 * Var + methods to calc the maximum Hitpoints and Stamina 
 */
private int maxStam;
private int maxHP;
public int maxHP(){
	int maxHP = Math.round(200 * (getWeight()/100) * (getToughness()/100));
	 this.maxHP = maxHP;
	 return this.maxHP;
}

public int maxStamina(){
	 int maxStam = Math.round(200 * (getWeight()/100) * (getToughness()/100));
	  this.maxStam = maxStam;
	  return this.maxStam;
}



/**
 * Initialize this new Unit with given Orientation.
 * 
 * @param  Orientation
 *         The Orientation for this new Unit.
 * @post   If the given Orientation is a valid Orientation for any Unit,
 *         the Orientation of this new Unit is equal to the given
 *         Orientation. Otherwise, the Orientation of this new Unit is equal
 *         to default_value_Java.
 *       | if (isValidOrientation(Orientation))
 *       |   then new.getOrientation() == Orientation
 *       |   else new.getOrientation() == PI/2
 */
public Unit(float Orientation, double[] newPosition) {
		Orientation = (float) (Math.PI/2);
	
	setOrientation(Orientation);
}



/**
 * Return the Orientation of this Unit.
 */
@Basic @Raw
public float getOrientation() {
	return this.Orientation;
}


/**
 * Set the Orientation of this Unit to the given Orientation.
 * 
 * @param  Orientation
 *         The new Orientation for this Unit.
 * @post   If the given Orientation is a valid Orientation for any Unit,
 *         the Orientation of this new Unit is equal to the given
 *         Orientation.
 *       | if (isValidOrientation(Orientation))
 *       |   then new.getOrientation() == Orientation
 */
@Raw
public void setOrientation(float Orientation) {
		this.Orientation = Orientation;
}

/**
 * Variable registering the Orientation of this Unit.
 */
private float Orientation;


/**
 * Var + method for the base speed of a Unit
 */
private double Vb;

public double Vb(){
	 double baseSpeed = 1.5 * ((getStength() + getAgility())/
			 (200*((getWeight()/100))));
	this.Vb = baseSpeed;
	 return this.Vb;
}

/**
 * Calculate the new position to where a unit moves (x', y', z')
 * @param newPosition
 * 			The position the unit has to move to
 * @return
 * 			centerNewPos = {(x' = lc/2 + xc'), (y' = lc/2 + yc'), (z' = lc/2 + zc')}
 */
public double[] getCenterNewPosition(double[] newPosition){
	if (newPosition[0] < this.Xc)
		Xc2 = Math.round(this.Xc - 1);
	else
		Xc2 = Math.round(this.Xc + 1);
	if (newPosition[1] < this.Yc)
		Yc2 = Math.round(this.Yc - 1);
	else
		Yc2 = Math.round(this.Yc + 1);
	if (newPosition[2] < this.Zc)
		Zc2 = Math.round(this.Zc - 1);
	else
		Zc2 = Math.round(this.Zc + 1);
	double[] centerNewPos = {(Xc2+Lc/2), (Yc2+Lc/2), (Zc2+Lc/2)};
	return centerNewPos;
}
/**
 * Cte for the length of a game cube
 */
static int Lc = 1;

/**
 * Var + methods for to calc the center pos of the Cube where a unit moves to
 */
private long Xc;
private long Yc;
private long Zc;
private long Xc2;
private long Yc2;
private long Zc2;
/**
 * Calculates the x position of the center of a cube
 */
public long Xc(){
	 long xc = getOccupiedGameCube(getPoistion())[0];
	 this.Xc = xc;
	 return this.Xc;
}
/**
 * Calculates the y position of the center of a cube
 */
public long Yc(){
	 long xc = getOccupiedGameCube(getPoistion())[1];
	 this.Yc = xc;
	 return this.Yc;
}
/**
 * Calculates the z position of the center of a cube
 */
public long Zc(){
	 long xc = getOccupiedGameCube(getPoistion())[2];
	 this.Zc = xc;
	 return this.Zc;
}

/**
 * 
 * @param newPosition
 * 			Position to where the Unit should move
 * @post
 * 		| if z - z' == -1
 * 		|   then new.Vw = 0.5Vb
 * 		| else if z-z' == 1
 * 		|    then new.Vw = 1.2Vb
 * 		| else
 * 		|    new.Vw = Vb
 * 		| with z = this.getPosition[2] && z' == newPosition[2]  
 * 
 */
public double Vw(double[] newPosition){
	double[] nP = getCenterNewPosition(newPosition);
	if ( Util.fuzzyEquals(getPoistion()[2] - nP[2], -1))
		this.Vw = Vb() * 0.5;
	else if (Util.fuzzyEquals(getPoistion()[2] - nP[2], 1))
		this.Vw = Vb() * 1.2;
	else
		this.Vw = Vb();
	
	return this.Vw;
}
/**
 * 
 * @param newPosition
 * 			Position to where the Unit should move
 * @post
 * 		|if this.getStamina >0
 * 		| then while this.getStamina > 0
 * 		|			new.Vs = this.Vw * 2
 * 		|			new.Stamina = this.getStamina - 1
 * 		| else
 * 		|      new.Vs = this.Vw
 */
public double Vs(double[] newPosition){
	if (getStamina() > 0)
		while (getStamina() > 0){
			this.Vs = Vw(newPosition) * 2;
			this.Stamina = (getStamina() - 1);
		}
	else
		this.Vs = Vw(newPosition);
		
	return this.Vs;
}


/**
 * constants for the walking and sprinting speed
 */
private double Vs;
private double Vw;

/**
 * Move a unit to another cube
 * @param newPosition
 * 			New position a unit should move to
 * @param Speed
 * 			Tells whether a unit should be sprinting or not
 * @post
 * 		  |new.getPosition == newPosition
 * 
 */
public void moveToAdjacent(double[] newPosition){
	if (canHaveAsPoistion(newPosition) && isMoving() == false && isFalling() == false){
		isMoving = true;
		while (getPoistion()[0] != newPosition[0]){
			this.Position[1] = getPoistion()[0] + (v(newPosition)[0]* dt);
			advanceTime(dt);
		}
		while (getPoistion()[1] != newPosition[1]){
			this.Position[1] = getPoistion()[1] + (v(newPosition)[1]* dt);
			advanceTime(dt);
			}
		while (getPoistion()[2] != newPosition[2]){
			this.Position[2] = getPoistion()[2] + (v(newPosition)[2]* dt);
			advanceTime(dt);
		}
		if (getPoistion() == newPosition)
			this.Position = getCenterNewPosition(getPoistion());
	}
	this.isMoving = false;
	double vx = v(newPosition)[0];
	double vy = v(newPosition)[1];
	setOrientation(Math.round(Math.atan2(vy, vx)));
}
/**
 * return whether a unit is moving or not
 */
private boolean isMoving = false;
public boolean isMoving(){
	return this.isMoving;
}
/**
 * Calculate d for the moveToAdjacent funct
 * @param newPosition
 * 			Position to where to unit should move next
 * @return
 * 			| d = sqrt((x'-x)^2 + (y'-y)^2 + (z'-z)^2)
 */
private double d(double[] newPosition){
	double d = 0;
	for (int i = 0; i < newPosition.length; i++)
		d += Math.pow(getCenterNewPosition(newPosition)[i] + 
				getOccupiedGameCube(this.getPoistion())[i], 2);
	return Math.sqrt(d);
}
/**
 * Calculate v for the moveToAdjacent funct
 * @param newPosition
 * 			New pos where the unit should move to
 * @param Speed
 * 			Tells whether sprint is turned on or not
 * @return
 * 			| if speed == sprint
 * 			|      v = (vx, vy, vz) = (vs* (x'-x)/d, vs*(y'-y)/d, vs*(z'-z)/d)
 * 			| else
 * 			|	    v = (vx, vy, vz) = (vw* (x'-x)/d, vw*(y'-y)/d, vw*(z'-z)/d)
 */	
private double[] v(double[] newPosition){
	
	double x = (getCenterNewPosition(newPosition)[0] - 
			getOccupiedGameCube(this.getPoistion())[0])/d(newPosition);
	double y = (getCenterNewPosition(newPosition)[1] - 
			getOccupiedGameCube(this.getPoistion())[1])/d(newPosition);
	double z = (getCenterNewPosition(newPosition)[2] - 
			getOccupiedGameCube(this.getPoistion())[2])/d(newPosition);
	if (Sprint == true){
		x *= Vs(newPosition);
		y *= Vs(newPosition);
		z *= Vs(newPosition);
	}
	else{
		x *= Vw(newPosition);
		y *= Vw(newPosition);
		z *= Vw(newPosition);
	}
	double[] v = {x, y, z};
	return v;
		
}
/**
 * return the current speed of a unit
 */
public double getCurrentSpeed(){
	double a = Math.pow(v(getCenterPosition())[0],2);
	double b = Math.pow(v(getCenterPosition())[1],2);
	double c = Math.pow(v(getCenterPosition())[2],2);
	double d = Math.sqrt(a+b+c);
	return d;
}

/**
 * Make a unit move to a new position
 * @param newPosition
 * 			new position to which the unit should move
 * @param Speed
 * 			Whether the unit should sprint or not
 * @post
 * 		| new.getPosition == newPosition
 */
public void moveTo(double[] newPosition){
	int x, y, z;
	while (getPoistion() != newPosition){
		if (getPoistion()[0] == newPosition[0])
			x = 0;
		else if (getPoistion()[0] < newPosition[0])
			x = 1;
		else
			x = -1;
		if (getPoistion()[1] == newPosition[1])
			y = 0;
		else if (getPoistion()[1] < newPosition[1])
			y = 1;
		else
			y = -1;
		if (getPoistion()[2] == newPosition[2])
			z = 0;
		else if (getPoistion()[2] < newPosition[2])
			z = 1;
		else
			z = -1;
		double[] pos = {x,y,z};
		if (true == this.Sprint)
			advanceTime(Lc/Vs(newPosition));
		else
			advanceTime(Lc/Vw(newPosition));
		moveToAdjacent(pos);
	}	
}
/**
 * Queues for the position and n for the moveTo method
 */
Queue<double[]> Q1 = new LinkedList<double[]>();
Queue<Integer> Q2 = new LinkedList<Integer>();

/**
 * Path finding method that moves units to a newPosition more than 1 away from their current position
 * @param newPosition 
 * 			new position for the unit to go to
 * @param n0
 * 			number of steps to get to the new position
 * @effect the units position is equal to the newPosition
 * 			|new.getPosition == newPosition
 * 
 */
public void moveTo(double[] newPosition, int n0){
	int x = (int) Math.floor(newPosition[0]);
	int z = (int) Math.floor(newPosition[2]);
	int y = (int) Math.floor(newPosition[1]);
	
	ArrayList<double[]> L = new ArrayList<double[]>();
	for (int i = -1; i <= 1; i++)
		for (int j = -1; j <= 1; j++)
			for (int k = -1; k <= 1; k++){
				if (world.isPassable(x+i, y+j, z+k) && (! world.isPassable(x+i, y+j, z+k))
				 && (! Q1.contains(coordToPos(x-1, y, z)) && (! Q2.contains(n0)))){	
					L.add(coordToPos(x+i, y+j, z+k));	
		}
	}
	for (int i = 0; i < L.size(); i++) {
		Q1.add(L.get(i));
		Q2.add(n0+1);
	}

	while (getPoistion() != newPosition){
		while (isUnderAttack() == false && isResting() == false 
				&& hasToRest() == false){
		Q1.add(newPosition);
		Q2.add(0);
		while (! Q1.contains(getPoistion())&& Q1.size() > 0){
			double[] p = Q1.element();
			int n = Q2.element();
			moveTo(p, n);
		}
		}
	}
	if (Q1.contains(getPoistion()))
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				for (int k = -1; k <= 1; k++){
					if (Q1.contains(coordToPos(x+i, y+j, z+k))){
						double [] next = coordToPos(x+i, y+j, z+k);
						moveToAdjacent(next);
					}
				}
}



/**
 * Takes x, y and z coordinates and returns it as a double[]
 * @param x
 * 			xPosition
 * @param y
 * 			yPosiiton
 * @param z
 * 			zPosition
 * @return Returns the position as a double[]
 * 			|coordToPos(x,y,z) == double[] pos = {x,y,z}
 */
public double[] coordToPos(double x, double y, double z){
	double[] p = {x,y,z};
	return p;
}


/**
 * Make a unit start sprinting
 */
public void startSprint(){
	this.Sprint = true;
}
/**
 * Make a unit stop sprinting
 */
public void stopSprint(){
	this.Sprint = false;
}
/**
 * 
 * check if a unit is sprinting
 */
public boolean isSprinting(){
	return this.Sprint;
}
public boolean Sprint = false;

/**
 * Method that makes a unit work
 */
public void work(){
	float TimeLeft = 500/getStength();
	while (this.working == true && isUnderAttack() == false)
		for (int i = 0; TimeLeft/dt > i; i++)
			advanceTime(dt);
}
/**
 * Make a unit start working
 */
public boolean enableWorking(){
	return this.working == true;
}
/**
 * Check if a unit is working
 */
public boolean isWorking(){
	if (this.working == true)
		return true;
	else
		return false;
}
private boolean working = false;


/**
 * Make a unit attack another unit from a different faction
 * @param Attacker
 * 			the unit that attacks the defender
 * @param Defender
 * 			the unit that defends himself from the attacker
 * @effect
 * 		Make a unit start attacking another one who defends himself
 */
public void attack(Unit Attacker, Unit Defender){
	List<Unit> p = faction.getAllUnitsFromFaction();
	if (!(p.contains(Attacker) && p.contains(Defender))){
	float TimeLeft = 1;
	double xa = Attacker.getPoistion()[0];
	double ya = Attacker.getPoistion()[1];
	double xd = Defender.getPoistion()[0];
	double yd = Defender.getPoistion()[1];
		while (TimeLeft != 0){
			Attacker.attacking = true;
			Defender.underAttack = true;
			defend(Attacker, Defender);
			setOrientation(Math.round(Math.atan2((yd-ya), (xd-xa))));
			advanceTime(dt);
			TimeLeft -= dt;
	}
		Attacker.attacking = false;
		Defender.underAttack = false;
	}
}
/**
 * variable for a faction
 */
private Faction faction;

/**
* Check if a unit is attacking another one
 */
public boolean isAttacking(){
	if (this.attacking == true)
		return true;
	else
		return false;
}
/**
 *Check if this unit is under attack
 */
public boolean isUnderAttack(){
	return this.underAttack;
}

private boolean attacking = false;
private boolean underAttack = false;
/**
 * Make a unit defend himself against another one from a different faction 
 * @param Attacker
 * 			unit that is attacking the other unit
 * @param Defender
 * 			unit that is defending himself against the other unit
 * @effect the defending unit either blocks damage and gains 20 xp
 * 			or dodges the attack and gains 20 xp
 * 			or gets hit and loses Attacker.getStrength/10 hp and the 
 * 			attacker gains 20 xp
 * 
 */
public void defend(Unit Attacker, Unit Defender){
	double xa = Attacker.getPoistion()[0];
	double ya = Attacker.getPoistion()[1];
	double xd = Defender.getPoistion()[0];
	double yd = Defender.getPoistion()[1];
	while (Defender.underAttack = true){
	double dodgeChance = 0.20 * Defender.getAgility()/Attacker.getAgility();
	double blockChance = 0.25 * (Defender.getAgility() + Defender.getStength())/
			(Attacker.getAgility() + Attacker.getStength());
	double rand = Math.random();
	setOrientation(Math.round(Math.atan2((ya-yd), (xa-xd))));
	if (rand <= dodgeChance){
		double[]  newPos = coordToPos(Defender.getPoistion()[0] += rand, 
				Defender.getPoistion()[1] += rand, Defender.getPoistion()[2] += rand);
		if( canHaveAsPoistion(newPos)){
		Defender.Position = newPos;	
		Defender.addXP(20);
		}
	}
	else if (dodgeChance < rand) 
		if (rand <= (dodgeChance + blockChance)){
			attack(Defender, Attacker);
			Defender.addXP(20);
		}
		else{
			int hp;
			hp = Defender.getHitpoints() - Attacker.getStength()/10;
			Defender.setHitpoints(hp);
			Attacker.addXP(20);
		}
	}
	if (Defender.getHitpoints() == 0)
		killUnit();
	levelUp();
}
/**
 * Make a unit rest
 * @effect The units hitpoints go up while resting until they are full, then the units
 * 			stamina points go up
 * 			| while (resting)
 * 			|	if (this.getHitpoints < maxHP)
 * 			|   new.setHitpoints(this.getHitpoints+getToughness/200)*dt
 * 			|	else
 * 			|	new.setStamina(this.getStamina+getToughness/100)*dt
 * 			
 */
public void rest(){
	int hp = this.getHitpoints();
	int stam = this.getStamina();
	while (this.resting == true && this.underAttack == false){
		if (getHitpoints() < maxHP())
			while (getHitpoints() < maxHP()){
				hp += getToughness()/200;
				setHitpoints(hp);	
				advanceTime(dt);
			}
		else if (getStamina() < maxStamina())
			while (getStamina() < maxStamina()){
				stam += getToughness()/100;
				setStamina(stam);
				advanceTime(dt);
			}
	}
}
/**
 * Make a unit start resting
 */
public void enableRest(){
	rest();
	this.resting = true;
}
/**
 * Check if this unit has to rest
 */
public boolean hasToRest(){
	if (getStamina() == 0)
		return true;
	else
		return false;
}
/**g
 * Check if a unit is resting
 */
public boolean isResting(){
	if (this.resting = true)
		return true;
	else
		return false;
}
private boolean resting = false;
/**
 * Activate the default behaviour of a unit (the unit starts resting, working,
 * fighting another unit or moves to a random position)
 * @param defBeh
 * 			checks if default behaviour is on or not
 */
public void startDefaultBehaviour(boolean defBeh){
	Random rand = new Random(); 
	int r = rand.nextInt(3) +1;
	int p = rand.nextInt(1) + 1;
	Unit other = null;
	double[] newPos = coordToPos(getPoistion()[0] + p * Math.pow(-1, r),
			getPoistion()[1] + p * Math.pow(-1, p), getPoistion()[2] + p * Math.pow(-1, r));
	if (working == false && attacking == false && resting == false &&
			moving == false && underAttack == false && defBeh == true){
		this.defBehav = true;
		if (r == 1)
			rest();
		else if (r == 2)
			work();
		else if (r == 3)
			attack(this,other);
		else{
			if (Stamina > 0)
				moveTo(newPos,0);
			else
				moveTo(newPos,0);
		}
	}
		else
			this.defBehav = false;
}
private boolean defBehav;
/**
 * Checks whether default behaviour is on or not
 */
public boolean isDefaultBehaviourEnabled(){
	return this.defBehav;
}
private boolean moving = false;


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
public boolean isDead;
/**
 * Variable referencing to the world this unit belongs to
 */
private World world = null;
/**
 * Makes a unit fall if he is standing on a passable cube and there are no other
 * impassable cubes less than  1 lc around him
 * @param world
 * 			| the world in which the unit exists
 * @post 	if there is no passable cubes around the unit it falls and loses 10 hiptpoints
 * 			per z level he falls
 * 			| wile (world.isPassable(x+/-1,y+/-1,z+/-1) && z>0
 * 			|    new.setPosition(x,y,z-1) && new.setHipoints(getHitpoints-10) 	
 */
public void Fall(){
	double[] p = getPoistion();
	int x = (int) Math.floor(p[0]);
	int y = (int) Math.floor(p[1]);
	int z = (int) Math.floor(p[2]);
	boolean canFall = false;
	int v = -3;
	
	if (! world.isPassable(x+1,y,z))
		canFall = false;
	else if (! world.isPassable(x-1,y,z))
		canFall = false;
	else if (! world.isPassable(x,y+1,z))
		canFall = false;
	else if (! world.isPassable(x,y-1,z))
		canFall = false;
	else if (! world.isPassable(x,y,z+1))
		canFall = false;
	else if (! world.isPassable(x,y,z-1))
		canFall = false;
	else
		canFall = true;
	
	if (canFall == true){
		this.falling = true;
		double dt = Lc/v;
		advanceTime(dt);
		z--;
		setHitpoints(getHitpoints()-10);
		double[] p2 = coordToPos(x, y, z);
		setPosition(p2);
		if (world.isPassable(x, y, z) && z > 0)
			Fall();
			
	}
	this.falling = false;
	if (this.getHitpoints() == 0)
		killUnit();
}

/**
 * Check if a unit is falling
 */
public boolean isFalling(){
	return this.falling;
}
private boolean falling = false;

/**
 * Check whether a unit is dead or not
 */
public boolean isDead() {
	return this.dead;
}
/**
 * Variable for the death of a unit
 */
private boolean dead = false;

/**
 * Kills a unit when its hitpoints reach 0, removes it from the world, 
 * his current faction and drops the objects he was holding (if he was holding
 * any)
 */
public void killUnit(){
	if (this.getHitpoints() == 0){
		dead = true;
		List<String> f = world.getAllFactions();
		int l = f.size();
		for (int i = 0; i < l; i++)
			if (faction.getFactionFromName(f.get(i)).hasAsFaction(this))
				faction.removeUnitFromFact(this);
		List<Unit> w = world.getAllUnits();
		w.remove(this);
		if (holdsBoulder()){
			boulder.setHolder(null);
			boulder.setPosition(this.getPoistion());
		}
		if (holdsLog()){
			log.setHolder(null);
			log.setPosition(this.getPoistion());
		}
		this.attacking = false;
		this.resting = false;
		this.working = false;
		this.falling = false;
		this.defBehav = false;
		this.isMoving = false;
		this.underAttack = false;
	}
}

/**
 * Check if this unit holds a log
 * @return true if this unit holds the log false otherwise 			
 */
public boolean holdsLog(){
	assert log.hasHolder();
	return log.getHolder() == this;
}
private Log log;
/**
 * Check if this unit holds a boulder
 * @return true if this unit holds the boulder false otherwise			
 */
public boolean holdsBoulder(){
	return boulder.getHolder() == this;
}
private Boulder boulder;
/**
 * 
 * @param x
 * @param y
 * @param z
 */
public void workAt(int x, int y, int z){
	work();
	
	if (holdsBoulder()){
		boulder.unsetHolder();
		boulder.setPosition(coordToPos(x, y, z));
		addXP(10);
	}
		
	else if (holdsLog()){
		log.unsetHolder();
		log.setPosition(coordToPos(x, y, z));
		addXP(10);
	}
	else if (world.getCubeType(x, y, z) == (Object)3 && 
			boulder.getPosition() == coordToPos(x, y, z) &&
			log.getPosition() == coordToPos(x, y, z)){
		log.Consume();
		boulder.Consume();
		setWeight(getWeight()+1);
		setToughness(getToughness()+1);
		addXP(10);
	}
	
	else if (boulder.getPosition() == coordToPos(x, y, z)){
		boulder.setHolderTo(this);
		addXP(10);
	}
	
	else if (log.getPosition() == coordToPos(x, y, z)){
		log.setHolderTo(this);
		addXP(10);
	}
	
	else if (world.getCubeType(x, y, z) == (Object)2){
		world.collapseCube(x, y, z);
		addXP(10);
	}
	
	else if (world.getCubeType(x, y, z) == (Object)1){
		world.collapseCube(x, y, z);
		addXP(10);
	}
	levelUp();
}

/**
 * variable to hold this units xp
 */
private int XP;
/**
 * add xp to the units total xp
 * @param xp
 * 			|xp to be added to the total xp of this unit
 */
public void addXP(int xp){
	this.XP += xp;
}
/**
 * Get the xp of this unit
 */
public int getXP(){
	return this.XP;
}

/**
 * If a unit has gathered 10 or more xp, its strength, agility or toughness 
 * will be increased by 1
 */
public void levelUp(){
	Random rand = new Random();
	if (getXP() >= 10){
		for (int i = getXP(); i >= 10; i-=10){
			int p = rand.nextInt(100);
			if (p <= 33)
				setAgility(getAgility()+1);
			else if (p>33 && p <= 66)
				setStength(getStength()+1);
			else
				setToughness(getToughness()+1);
		}
	}	
}



}