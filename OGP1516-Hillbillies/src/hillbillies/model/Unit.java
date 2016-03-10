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
public Unit(double[] Position) throws IllegalArgumentException {
	if (! canHaveAsPoistion(Position))
		throw new IllegalArgumentException();
	this.Position = Position;
}


/**
 * Return the Position of this Unit.
 */
@Basic @Raw @Immutable
public double[] getPoistion() {
	return this.Position;
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


private double Xpos;
private double Ypos;
private double Zpos;
private double[] Position = {Xpos, Ypos, Zpos};

private double maxX = 50;
private double maxY = 50;
private double maxZ = 50;





//=======NAME FUNCTIONS=====



/**
 * Initialize this new Unit with given Name.
 *
 * @param  Name
 *         The Name for this new Unit.
 * @effect The Name of this new Unit is set to
 *         the given Name.
 *       | this.setName(Name)
 */
public Unit(String Name)throws IllegalArgumentException {
	this.setName(Name);
}


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
	assert Name.length() >= 2;
	boolean check = false;
	String spChar = "'";
	for (int i = 0; i < Name.length();){
		if (Character.isLetter(Name.charAt(i)))
			check = true;
		else if (Character.isWhitespace(Name.charAt(i)))
			check = true;
		else if (Name.charAt(i) == '"' || spChar.contains(Name.substring(i, 1)))
			check = true;
		else
			check = false;
			return false;
		
	}
	return check;
	
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
 * @invar  The Strength of each Unit must be a valid Strength for any
 *         Unit.
 *       | isValidStength(getStength())
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
 * @invar  The Agility of each Unit must be a valid Agility for any
 *         Unit.
 *       | isValidAgility(getAgility())
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
 * @invar  The Toughness of each Unit must be a valid Toughness for any
 *         Unit.
 *       | isValidToughness(getToughness())
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
 * @invar  The Weight of each Unit must be a valid Weight for any
 *         Unit.
 *       | isValidWeight(getWeight())
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


public Unit(int Strength, int Agility, int Toughness, int Weight) {
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
 * Cte for the min and max init Strength, Agility, Toughness and Weight
 */
private int minInitStrength = 25;
private int maxInitStrength = 100;
private int minInitAgility = 25;
private int maxInitAgility = 100;
private int minInitThoughness = 25;
private int maxInitThoughness = 100;
private int minInitWeight = this.minWeight;
private int maxInitWeight = 200;


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
	return (this.minWeight <= Weight) && (Weight <= maxWeight);
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
 * Var to give the min and max Weight of a unit
 */
private int minWeight = ((getAgility() + getStength())/2);
private int maxWeight = 200;



//=======STAMINA, HITPOINTS=======

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
			(Stamina <= this.getMaxStamina());
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
			(Hitpoints <= this.getMaxHP());
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
 * Var to calc the maximum Hitpoints and Stamina + getters and setters
 */
private int maxStamina = Math.round(200 * (this.getWeight()/100) * (this.getToughness()/100));
private int maxHP = Math.round(200 * (this.getWeight()/100) * (this.getToughness()/100));
public int getMaxStamina() {
	return maxStamina;
}


public void setMaxStamina(int maxStamina) {
	this.maxStamina = maxStamina;
}

public int getMaxHP() {
	return maxHP;
}

public void setMaxHP(int maxHP) {
	this.maxHP = maxHP;
}

/**
 * @invar  The Orientation of each Unit must be a valid Orientation for any
 *         Unit.
 *       | isValidOrientation(getOrientation())
 */

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
	if (! isValidOrientation(Orientation))
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
 * Check whether the given Orientation is a valid Orientation for
 * any Unit.
 *  
 * @param  Orientation
 *         The Orientation to check.
 * @return 
 *       | result == 
*/
public boolean isValidOrientation(float Orientation) {
	
	return true;
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
	if (isValidOrientation(Orientation))
		this.Orientation = Orientation;
}

/**
 * Variable registering the Orientation of this Unit.
 */
private float Orientation;


/**
 * Var for the base speed of a Unit
 */

private double Vb = 1.5 * ((this.getStength() + this.getAgility())/
					(200*(this.getWeight()/100)));

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
 * Var for to calc the center pos of the Cube where a unit moves to
 */
private long Xc = this.getOccupiedGameCube(this.getPoistion())[0];
private long Yc = this.getOccupiedGameCube(this.getPoistion())[1];
private long Zc = this.getOccupiedGameCube(this.getPoistion())[2];
private long Xc2;
private long Yc2;
private long Zc2;


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
	assert canHaveAsPoistion(newPosition);
	double[] nP = getCenterNewPosition(newPosition);
	if (this.getPoistion()[2] - nP[2] == -1)
		Vw = this.Vb * 0.5;
	else if (this.getPoistion()[2] - nP[2] == 1)
		Vw = this.Vb * 1.2;
	else
		Vw = this.Vb;
	
	return Vw;
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
	if (this.getStamina() > 0)
		while (this.getStamina() > 0){
			Vs = this.Vw(newPosition) * 2;
			Stamina = (this.getStamina() - 1);
		}
	else
		Vs = this.Vw(newPosition);
		
	return Vs;
}
/**
 * 
 * @param Speed
 * 		   Determine whether the sprint function is on or not
 * @return
 * 			| if speed == "Sprint"
 * 			|    then true
 * 			| else
 * 			|    false
 */
public boolean Sprint(String Speed){
	if (Speed == "Sprint")
		return true;
	else
		return false;
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
public void moveToAdjacent(double[] newPosition, String Speed){
	assert canHaveAsPoistion(newPosition);
	while (this.getPoistion()[0] != newPosition[0])
		Position[0] = this.getPoistion()[0] + (v(newPosition, Speed)[0]* deltaT);
	while (this.getPoistion()[1] != newPosition[1])
		Position[1] = this.getPoistion()[1] + (v(newPosition, Speed)[1]* deltaT);
	while (this.getPoistion()[2] != newPosition[2])
		Position[2] = this.getPoistion()[2] + (v(newPosition, Speed)[2]* deltaT);
	if (this.getPoistion() == newPosition)
		Position = this.getCenterNewPosition(this.getPoistion());
	double vx = v(newPosition, Speed)[0];
	double vy = v(newPosition, Speed)[1];
	this.setOrientation(Math.round(Math.atan2(vy, vx)));
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
private double[] v(double[] newPosition, String Speed){
	
	double x = (getCenterNewPosition(newPosition)[0] - 
			getOccupiedGameCube(this.getPoistion())[0])/d(newPosition);
	double y = (getCenterNewPosition(newPosition)[1] - 
			getOccupiedGameCube(this.getPoistion())[1])/d(newPosition);
	double z = (getCenterNewPosition(newPosition)[2] - 
			getOccupiedGameCube(this.getPoistion())[2])/d(newPosition);
	if (Sprint(Speed)){
		x *= this.Vs(newPosition);
		y *= this.Vs(newPosition);
		z *= this.Vs(newPosition);
	}
	else{
		x *= this.Vw(newPosition);
		y *= this.Vw(newPosition);
		z *= this.Vw(newPosition);
	}
	double[] v = {x, y, z};
	return v;
		
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
public void moveTo(double[] newPosition, String Speed, Unit unit){
	int x, y, z;
	while (this.getPoistion() != newPosition){
		moving = true;
		if (this.getPoistion()[0] == newPosition[0])
			x = 0;
		else if (this.getPoistion()[0] < newPosition[0])
			x = 1;
		else
			x = -1;
		if (this.getPoistion()[1] == newPosition[1])
			y = 0;
		else if (this.getPoistion()[1] < newPosition[1])
			y = 1;
		else
			y = -1;
		if (this.getPoistion()[2] == newPosition[2])
			z = 0;
		else if (this.getPoistion()[2] < newPosition[2])
			z = 1;
		else
			z = -1;
		double[] pos = {x,y,z};
		Time += deltaT;
		moveToAdjacent(pos, Speed);
	}	
	moving = false;
}

public void work(Unit unit){
	float TimeLeft = this.Strength/500;
	while (TimeLeft > 0){
		working = true;
		TimeLeft -= deltaT;
	}
	working = false;
	
}

public void attack(Unit Attacker, Unit Defender){
	float TimeLeft = 1;
	double xa = Attacker.getPoistion()[0];
	double ya = Attacker.getPoistion()[1];
	double xd = Defender.getPoistion()[0];
	double yd = Defender.getPoistion()[1];
	while (TimeLeft > 0){
		defend(Attacker, Defender);
		setOrientation(Math.round(Math.atan2((yd-ya), (xd-xa))));
		attacking = true;
		TimeLeft -= deltaT;
	}
	attacking = false;
}

public void defend(Unit Attacker, Unit Defender){
	double xa = Attacker.getPoistion()[0];
	double ya = Attacker.getPoistion()[1];
	double xd = Defender.getPoistion()[0];
	double yd = Defender.getPoistion()[1];
	underAttack = true;
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
	underAttack = false;
}

public void rest(Unit unit){
	int hp = this.getHitpoints();
	int stam = this.getStamina();
	if (underAttack == false){
		resting = true;
		if (this.getHitpoints() < getMaxHP())
			while (this.getHitpoints() < getMaxHP()){
				hp += this.getToughness()/200;
				this.setHitpoints(hp);	
			}
		else if (this.getStamina() < getMaxStamina())
			while (this.getStamina() < getMaxStamina()){
				stam += this.getToughness()/100;
				this.setStamina(stam);
			}
	}
	else
		resting = false;
}

public void startDefaultBehaviour(Unit unit){
	Random rand = new Random(); 
	int r = rand.nextInt(2) +1;
	int p = rand.nextInt(1) + 1;
	double newPosX = unit.getPoistion()[0] + p * Math.pow(-1, r);
	double newPosY = unit.getPoistion()[1] + p * Math.pow(-1, p);
	double newPosZ = unit.getPoistion()[2] + p * Math.pow(-1, r);
	double[] newPos = {newPosX, newPosY, newPosZ};
	if (working == false && attacking == false && resting == false &&
			moving == false && underAttack == false && defBeh == true)
		if (r == 1)
			rest(unit);
		else if (r == 2)
			work(unit);
		else{
			if (Stamina > 0)
				moveTo(newPos, "Sprint", unit);
			else
				moveTo(newPos, "Walk", unit);
		}
}

public void stopDefaultBehaviour(Unit unit){
	if (defBeh == true)
		defBeh = false;
}

public void advanceTime(){
	if (working == true)
		while (working == true)
			Time += 500/this.Strength * deltaT;
	else if (attacking == true)
		Time += 1 * deltaT;
	else if (resting == true)
		while (resting == true)
			Time += deltaT * 2;
	else if (Time == 180)
		resting = true;
	else 
		defBeh = true;
}



private boolean moving = false;
private boolean working = false;
private boolean attacking = false;
private boolean underAttack = false;
private boolean resting = false;
private boolean defBeh = false;



private double Time;
private double deltaT = 0.1;

}