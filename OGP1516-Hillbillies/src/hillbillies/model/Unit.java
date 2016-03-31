package hillbillies.model;

import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Raw;



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
	initialPosition = Position;
	this.setName(Name);
	Random rand = new Random();
	if (! isValidStength(Strength))
		Strength = rand.nextInt(maxInitStrength - minInitStrength) + minInitStrength;
	setStength(Strength);
	if (! isValidAgility(Agility))
		Agility = rand.nextInt(maxInitAgility - minInitAgility) + minInitAgility;
	setAgility(Agility);
	if (! isValidToughness(Toughness))
		Toughness = rand.nextInt(maxInitThoughness - minInitThoughness) 
		+ minInitThoughness;
	setToughness(Toughness);
	if (! isValidWeight(Weight))
		Weight = rand.nextInt(maxInitWeight - minInitWeight) 
		+ minInitWeight;
	setWeight(Weight);
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
 * Check whether this Unit can have the given Position as its Position.
 *  
 * @param  Position
 *         The Position to check.
 * @return 
 *       | (0 < Xpos < maxX - 1) && (0 < Ypos < maxY-1) && (0 < Zpos < maxZ-1)
*/
@Raw
public boolean canHaveAsPoistion(double[] Position) {
	return (Position[0] >= 0) && (Position[0] <= maxX - 1) 
			&& (Position[1] >= 0) && (Position[1] <= maxY - 1)
			&& (Position[2] >= 0) && (Position[2] <= maxZ - 1);
	
}

/**
 * Variable registering the Position of this Unit.
 */

private int[] initialPosition ;
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
	 return this.minWeight = minWeight;
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
	return this.maxHP = maxHP;
}

public int maxStamina(){
	 int maxStam = Math.round(200 * (getWeight()/100) * (getToughness()/100));
	 return this.maxStam = maxStam;
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
public Unit(float Orientation, double[] newPosition, 
		String Speed) {
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
	 return this.Vb = baseSpeed;
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
private int Lc = 1;

/**
 * Var + methods for to calc the center pos of the Cube where a unit moves to
 */
private long Xc;
private long Yc;
private long Zc;
private long Xc2;
private long Yc2;
private long Zc2;

public long Xc(){
	 long xc = getOccupiedGameCube(getPoistion())[0];
	 return this.Xc = xc;
}
public long Yc(){
	 long xc = getOccupiedGameCube(getPoistion())[1];
	 return this.Yc = xc;
}
public long Zc(){
	 long xc = getOccupiedGameCube(getPoistion())[2];
	 return this.Zc = xc;
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
	if ((getPoistion()[2] - nP[2] >=  -1) && 
			(getPoistion()[2] - nP[2] <=  -1.01))
		this.Vw = Vb() * 0.5;
	else if ((getPoistion()[2] - nP[2] >=  1) && 
			(getPoistion()[2] - nP[2] <=  1.01))
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
	if (canHaveAsPoistion(newPosition) && isMoving == false){
		isMoving = true;
		while (getPoistion()[0] != newPosition[0]){
			this.Position[1] = getPoistion()[0] + (v(newPosition)[0]* 0.2);
			advanceTime(0.2);
		}
		while (getPoistion()[1] != newPosition[1]){
			this.Position[1] = getPoistion()[1] + (v(newPosition)[1]* 0.2);
			advanceTime(0.2);
			}
		while (getPoistion()[2] != newPosition[2]){
			this.Position[2] = getPoistion()[2] + (v(newPosition)[2]* 0.2);
			advanceTime(0.2);
		}
		if (getPoistion() == newPosition)
			this.Position = getCenterNewPosition(getPoistion());
	}
	this.isMoving = false;
	double vx = v(newPosition)[0];
	double vy = v(newPosition)[1];
	setOrientation(Math.round(Math.atan2(vy, vx)));
}

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



public void startSprint(){
	this.Sprint = true;
}
public void stopSprint(){
	this.Sprint = false;
}
public boolean isSprinting(){
	return this.Sprint;
}
public boolean Sprint = false;


public void work(){
	float TimeLeft = 500/getStength();
	while (this.working == true)
		for (int i = 0; TimeLeft/0.2 > i; i++)
			advanceTime(0.2);
}
public boolean enableWorking(){
	return this.working == true;
}
public boolean isWorking(){
	if (this.working == true)
		return true;
	else
		return false;
}
private boolean working = false;



public void attack(Unit Attacker, Unit Defender){
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
			advanceTime(0.2);
			TimeLeft -= 0.2;
	}
		Attacker.attacking = false;
		Defender.underAttack = false;
}
public boolean isAttacking(){
	if (this.attacking == true)
		return true;
	else
		return false;
}
private boolean attacking = false;
private boolean underAttack = false;

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
	double x,y,z;
	setOrientation(Math.round(Math.atan2((ya-yd), (xa-xd))));
	if (rand <= dodgeChance){
		x = Defender.getPoistion()[0] += rand;
		y = Defender.getPoistion()[1] += rand;
		z = Defender.getPoistion()[2] += rand;
		double[]  newPos = {x,y,z};
		assert canHaveAsPoistion(newPos);
		Defender.Position = newPos;	
	}
	else if (dodgeChance < rand) 
		if (rand <= (dodgeChance + blockChance))
			attack(Defender, Attacker);
		else{
			int hp;
			hp = Defender.getHitpoints() - Attacker.getStength()/10;
			Defender.setHitpoints(hp);
		}
	}
}

public void rest(){
	int hp = this.getHitpoints();
	int stam = this.getStamina();
	while (this.resting == true && this.underAttack == false){
		if (getHitpoints() < maxHP())
			while (getHitpoints() < maxHP()){
				hp += getToughness()/200;
				setHitpoints(hp);	
				advanceTime(0.2);
			}
		else if (getStamina() < maxStamina())
			while (getStamina() < maxStamina()){
				stam += getToughness()/100;
				setStamina(stam);
				advanceTime(0.2);
			}
	}
}
public boolean enableRest(){
	return this.resting = true;
}
public boolean isResting(){
	if (this.resting = true)
		return true;
	else
		return false;
}
private boolean resting = false;

public void startDefaultBehaviour(boolean defBeh){
	Random rand = new Random(); 
	int r = rand.nextInt(2) +1;
	int p = rand.nextInt(1) + 1;
	double newPosX = getPoistion()[0] + p * Math.pow(-1, r);
	double newPosY = getPoistion()[1] + p * Math.pow(-1, p);
	double newPosZ = getPoistion()[2] + p * Math.pow(-1, r);
	double[] newPos = {newPosX, newPosY, newPosZ};
	if (working == false && attacking == false && resting == false &&
			moving == false && underAttack == false && defBeh == true){
		defBehav = true;
		if (r == 1)
			rest();
		else if (r == 2)
			work();
		else{
			if (Stamina > 0)
				moveTo(newPos);
			else
				moveTo(newPos);
		}
	}
		else
			defBehav = false;
}
private boolean defBehav;

public boolean isDefaultBehaviourEnabled(){
	return defBehav;
}
private boolean moving = false;



public void advanceTime(double deltaT){
	
	this.Time += deltaT;

}

private double Time;


}