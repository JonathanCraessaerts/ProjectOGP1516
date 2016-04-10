package hillbillies.model;

import hillbillies.part2.listener.TerrainChangeListener;
import hillbillies.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;



public class World {

	
	/**
	 * Create a new world with given terrain type
	 * @param terrainTypes
	 * 			A three-dimensional array (structured as [x][y][z]) with the
	 *          types of the terrain, encoded as integers.	
	 *@effect
	 *			Creates a world with only solid terrain types
	 * @param modelListener
	 * 			 An object with a single method,
	 *            This method must be called by your implementation whenever
	 *            the terrain type of a cube changes (e.g., as a consequence of
	 *            cave-ins), so that the GUI will correctly update the display.
	 *            The coordinate of the changed cube must be given in the form
	 *            of the parameters x, y and z. 
	 *            
	 * @effect
	 * 		  Notes changes in type of terrain of cubes
	 * 
	 */
	public World(int[][][] terrainTypes, TerrainChangeListener modelListener){
		Random rand = new Random();
		this.xDim = 50;
		this.yDim = 50;
		this.zDim = 50;
		for (int x = 0; x < getNbCubesX(); x++)
			for (int y = 0; y < getNbCubesY(); y++)
				for (int z = 0; z < getNbCubesZ(); z++){
					int a = rand.nextInt(1) + 1;
					if (a == 1){
						terrainTypes[x][y][z] = TYPE_ROCK;
						this.TerrainTypes = terrainTypes;
					}
					else{
						terrainTypes[x][y][z] = TYPE_TREE;
						this.TerrainTypes = terrainTypes;
					}
				}
		for (int x = 0; x < getNbCubesX(); x++)
			for (int y = 0; y < getNbCubesY(); y++)
				for (int z = 0; z < getNbCubesZ(); z++){
					collapseCube(x, y, z);
				}
	}
	/**
	 * Return the number of cubes in the world in the x-direction.
	 */
	public int getNbCubesX(){
		return this.xDim;
	}
	/**
	 * Return the number of cubes in the world in the y-direction.
	 */
	public int getNbCubesY(){
		return this.yDim;
	}
	/**
	 * Return the number of cubes in the world in the z-direction.
	 */
	public int getNbCubesZ(){
		return this.zDim;
	}
	
	
	/**
	 * Returns whether a solid cube is connected to another solid cube or not
	 * @param x
	 * 		 x coordinate of a cube in the game World
	 * @param y
	 * 		y coordinate of a cube in the game World
	 * @param z
	 * 		z coordinate of a cube in the game World
	 * @effect
	 * 		result == true if cube is connected to another solid cube
	 */
	public boolean isSolidConnectedToBorder(int x, int y, int z){
		ConnectedToBorder cube = new ConnectedToBorder(x, y, z);
		return cube.isSolidConnectedToBorder(x,y,z);
	}
	
	/**
	 * Dimensions of the game World
	 */
	private int xDim;
	private int yDim;
	private int zDim;
	private int[][][] TerrainTypes;
	
	/**
	 * Types of the terrain represented as integers
	 */
	private static final int TYPE_AIR = 0;
	private static final int TYPE_ROCK = 1;
	private static final int TYPE_TREE = 2;
	private static final int TYPE_WORKSHOP = 3;
	
	
	/**
	 * Create a unit in this world with random attributes and a random starting position
	 * This unit starts a new faction if there are less factions in this world then maxNbFactions
	 * or joins the one with the least amount of units in it
	 * 
	 * @param unit
	 * 			The unit that has to be created
	 * @post The unit has a valid position and the cube he is on is passable
	 * 			|canHaveAsPosition(unit.getPosition) && isPassable(unit.getPosition)
	 * @post The unit has a valid random name
	 * 			| isValidName(unit.getName)
	 * @post The unit has a valid random strength
	 * 			| isValidstrength(unit.getstrength)
	 * @post The unit has a valid random Agility
	 * 			| isValidAgility(unit.getAgility)
	 * @post The unit has a valid random Toughness
	 * 			| isValidToughness(unit.getToughness)
	 * @post The unit has a valid random Weight
	 * 			| isValidWeight(unit.getWeight)
	 * @post The unit has a valid random Hitpoints
	 * 			| isValidHitpoints(unit.getHitpoints) 
	 * @post The unit has a valid random Stamina
	 * 			| isValidStamina(unit.getStamina) 
	 * @post If the amount of factions is lower than the max the unit makes a new faction
	 * 			otherwise he joins the faction with the least amount of units
	 * 			| if (getNbFactions() < this.maxNbOfUnits)
	 * 			|   Faction faction = new Faction(name)
	 * 			| 	addFaction(faction);
	 * 			| else 
	 *			|	Faction faction = getSmallestFaction();
	 *			|	faction.addUnitToFact(unit);
	 */
	public void addUnit(Unit unit) {
		Random rand = new Random();
		assert unit != null;
		int[] a = validRandPos();
		if (getNbOfUnits() <= this.maxNbOfUnits){
			double x = a[0];
			double y = a[1];
			double z = a[2];
			double[] pos = {x,y,z};
			unit.setPosition(pos);
			unit.setName(randName());
			unit.setStength(rand.nextInt(Unit.maxInitStrength - Unit.minInitStrength) + Unit.minInitStrength);
			unit.setAgility(rand.nextInt(Unit.maxInitAgility - Unit.minInitAgility) + Unit.minInitAgility);
			unit.setToughness(rand.nextInt(Unit.maxInitThoughness - Unit.minInitThoughness) + Unit.minInitThoughness);
			unit.setWeight((unit.getStength()+unit.getAgility())/2);
			unit.setHitpoints(200*unit.getToughness()/100*unit.getWeight()/100);
			unit.setStamina(200*unit.getToughness()/100*unit.getWeight()/100);
			if (getNbFactions() < this.maxNbOfUnits){
				String name = makeFactionName();
				Faction faction = new Faction(name);
				assert faction.canHaveAsName(name);
				faction.addUnitToFact(unit);
				addFaction(faction);
			}
			else{
				Faction faction = getSmallestFaction();
				faction.addUnitToFact(unit);
			}	
			int b = getNbOfUnits();
			setNbOfUnits(++b);;
		}
	}
	
	/**
	 * Returns a name of 5 random allowed characters
	 * @return String of 5 random characters
	 */
	public String randName(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz'ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder a = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    a.append(c);
		}
		String name = a.toString();
		return name;
	}
	
	
	
	/**
	 * Returns a random position in the game world
	 * @returns 
	 * 			|result == 0 < pos[0] < xDim-1 && 0 < pos[1] < yDim-1 && 
	 * 			| 0 < pos[2] < zDim-1
	 */
	public int[] randPos(){
		Random rand = new Random();
		int x = rand.nextInt(xDim-1);
		int y = rand.nextInt(yDim-1);
		int z = rand.nextInt(zDim-1);
		int[] pos = {x,y,z};
		return pos;
	}
	/**
	 * Returns a random,passable position, which is a valid position for a unit
	 * 
	 * @returns 
	 * 			|result == 0 < pos[0] < xDim-1 && 0 < pos[1] < yDim-1 && 
	 * 			| 0 < pos[2] < zDim-1 && isPassable(pos[0],pos[1],pos[2])
	 * 		
	 */
	public int[] validRandPos(){
		int [] rand = randPos();
		int x = rand[0];
		int y = rand[1];
		int z = rand[2];
		if (! isPassable(x, y, z) ||  !(! isPassable(x,y,z-1)||z==0 )){
			rand = randPos();
			validRandPos();
		}
		else
			return rand;
		return Unit.initialPosition;
	}
	
	/**
	 * Returns if a cube is passable (type air/workshop) or not (type rock/tree)
	 * @param x
	 * 		 x coordinate of a cube in the game World
	 * @param y
	 * 		y coordinate of a cube in the game World
	 * @param z
	 * 		z coordinate of a cube in the game World
	 * @result
	 * 		| result == true if getCubeType()== TYPE_ROCK || TYPE_TREE
	 * 					false if getCubeType()== TYPE_AIR || TYPE_WORKSHOP
	 */
	public boolean isPassable(int x, int y, int z){
		if (getCubeType(x, y, z) == (Object) TYPE_ROCK || 
				getCubeType(x, y, z) == (Object) TYPE_TREE)
			return false;
		else
			return true;
			
	}
	
	/**
	 * Returns the terraintype a cube of this world has
	 * @param x
	 * 		 x coordinate of a cube in the game World
	 * @param y
	 * 		y coordinate of a cube in the game World
	 * @param z
	 * 		z coordinate of a cube in the game World
	 * @return the type of terrain a cube has
	 */
	public Object getCubeType(int x, int y, int z){
		if (this.TerrainTypes[x][y][z] == TYPE_AIR)
			return 0;
		else if (this.TerrainTypes[x][y][z] == TYPE_ROCK)
			return 1;
		else if (this.TerrainTypes[x][y][z] == TYPE_TREE)
			return 2;
		else if (this.TerrainTypes[x][y][z] == TYPE_WORKSHOP)
			return 3;
		else	
			return null;
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
	 * Collapses the cube at position x,y,z with a probability of 0.25
	 * of leaving a boulder or a log if the cubes were type rock or wood respectively
	 * and giving the cube type air, if the cube under the collapsed cube isPassable, the 
	 * boulder or log will fall
	 * @param x
	 * 			x coordinate of the cube
	 * @param y
	 * 			y coordinate of the cube
	 * @param z
	 * 			z coordinate of the cube
	 * @effect
	 * 			|new.getCubeType == 0 
	 */
	public void collapseCube(int x, int y, int z){
		Random rand = new Random();
		int p = rand.nextInt(100);
		int w = rand.nextInt(40)+10;
		if (! isSolidConnectedToBorder(x, y, z)){
		if (getCubeType(x, y, z) == (Object)2){
			this.TerrainTypes[x][y][z] = TYPE_AIR;
			if (p <= 25){
				Log log = new Log(coordToPos(x, y, z), w, null);
				setNbOfLogs(getNbOfLogs()+1);
				if (isPassable(x, y, z-1))
					log.Fall();
			}
		}
		else if (getCubeType(x, y, z) == (Object)1){
			this.TerrainTypes[x][y][z] = TYPE_AIR;
			if (p <= 25){
				Boulder boulder = new Boulder(coordToPos(x, y, z), w, null);
				setNbOfBoulders(getNbOfBoudlers()+1);
				if (isPassable(x, y, z-1))
					boulder.Fall();
			}
		}
		}
	}
	public int getNbOfLogs(){
		return this.NbOfLogs;
	}
	/**
	 * Set a number a Logs in this world
	 * @param nb
	 * 			number of Logs that has to be set in this world
	 */
	public void setNbOfLogs(int nb){
		
		this.NbOfLogs = nb;
	}
	public int getNbOfBoudlers(){
		return this.NbOfBoulders;
	}
	/**
	 * Set a number a Boulders in this world
	 * @param nb
	 * 			number of Boulders that has to be set in this world
	 */
	public void setNbOfBoulders(int nb){
		
		this.NbOfBoulders = nb;
	}
	private int NbOfLogs;
	private int NbOfBoulders;
	
	/**
	 * Get the number of units in this world
	 */
	public int getNbOfUnits(){
		return this.NbOfUnits;
	}
	/**
	 * Set a number a units in this world
	 * @param nb
	 * 			number of units that has to be set in this world
	 */
	public void setNbOfUnits(int nb){
		
		this.NbOfUnits = nb;
	}
	/**
	 * Variables for the amount of units in this world
	 */
	private int maxNbOfUnits = 100;
	private int NbOfUnits;

	/**
	 * Make a name for a new faction
	 * @return
	 * 		A new faction name
	 */
	public String makeFactionName(){
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder a = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    a.append(c);
		}
		String name = a.toString();
		return name;
	}
	
	
    /**
     * Check whether this world has the given faction as one of its factions
     */
    @Basic @Raw
    public boolean hasAsFaction(Faction faction) {
        try {
            return factions.get(faction.getName()) == faction;
        }
        catch (NullPointerException exc) {
            assert (faction == null);
            return false;
        }
    }
	
    /**
     * Return the number of factions in this world
     * 
     * @return  The total number of factions in this world
     *        | result ==
     *        |   card({faction:Faction | hasAsFaction(faction)})
     */
    public int getNbFactions() {
        return factions.size();
    }
	
    /**
     * Add the given faction to the set of factions registered in
     * this world
     * 
     * @param   faction
     *          The faction to be added
     * @post    The given faction is registered as one of the
     *          factions for this world
     *        | new.hasAsFaction(faction)
     */
    void addFaction(Faction faction) {
        assert faction != null;
        factions.put(faction.getName(), faction);
    }

    /**
     * Remove the given faction from the faction registered in
     * this world
     * 
     * @param   faction
     *          The faction to be removed.
     * @post    This world no longer has the given faction as one of it factions
     *        | ! new.hasAsFaction(this)
     */
    void removeFaction(Faction faction) {
        assert hasAsFaction(faction);
        factions.remove(faction.getName());
    }
    
    /**
     * Returns the smallest faction of all factions that exists in this world
     * @return
     * 			The smallest faction in factions
     */
    public Faction getSmallestFaction(){
    	    java.util.Map.Entry<String, Faction> minKey = null;
    	    int minSize = Integer.MAX_VALUE;
    	    for(java.util.Map.Entry<String, Faction> key : factions.entrySet()) {
    	        int size = factions.get(key).getFactSize();
    	        if(size < minSize) {
    	            minSize = size;
    	            minKey = key;
    	        }
    	    }
    	    return minKey.getValue();
    	}
    
    /**
     * Returns a list of all factions existing in this world
     * @return
     * 		|result == list[getNbFactions()]
     */
    public List<String> getAllFactions(){
    	List<String> allFact = new ArrayList<String>();
    	for (String key : factions.keySet()) 
    		allFact.add(key);
    	return allFact;
    }
    /**
     * Returns all units from all factions in this world
     * @return
     * 			|result == List[getNbOfUnits()]
     */
    public List<Unit> getAllUnits(){
    	List<Unit> allUnits = new ArrayList<Unit>();
    	for(java.util.Map.Entry<String, Faction> key : factions.entrySet()) {
    		allUnits.add((Unit)factions.get(key).getAllUnitsFromFaction());
    	}
    	assert allUnits.size() == getNbOfUnits();
    	return allUnits;
    }
    
	
    /**
     * Variable referencing a map collecting all the factions
     * registered in this world
     * 
     * @invar   Each key registered in the map is an effective
     *          unit
     *        | for each key in factions.keySet():
     *        |   (unit != null)
     * @invar   Each value associated with a key in the map is
     *          an effective, non-extinct faction involving this
     *          world and involving a share whose code is identical
     *          to the associating key.
     *        | for each key in factions.keySet():
     *        |   (factions.get(key) != null) &&
     *        |   (! factions.get(key).isExtinct()) &&
     *        |   (factions.get(key).getFaction().getCode().equals(key))
     */
    private final Map<String, Faction> factions = new HashMap<String, Faction>();

    
    
    
	
}

