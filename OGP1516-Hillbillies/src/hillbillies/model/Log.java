package hillbillies.model;


import be.kuleuven.cs.som.annotate.Raw;
/**
 * A class of logs as a special kind of object. 
 */
public class Log extends Objects {
	/**
	 * Initialize this new Weight with given Position and given Weight.
	 *
	 * @param  Position
	 *         The Position for this new object.
	 * @param  Weight
	 *         The Weight of this new object.
	 * @param  holder
	 * 		   The holder of this new object
	 * 
	 * @effect This new log is initialized as a new object with
	 *         given position, weight and holder
	 *       | super(position, weight, holder)
	 */
 @Raw
public Log(double[] Position, int Weight, Unit holder) throws IllegalArgumentException {
	super(Position, Weight, holder);
}

}
