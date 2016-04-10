package hillbillies.model;


import be.kuleuven.cs.som.annotate.Raw;
/**
 * A class of Boulders as a special kind of object. 
 */
public class Boulder extends Objects {
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
	 * @effect This new Boulder is initialized as a new object with
	 *         given position, weight and holder
	 *       | super(position, weight, holder)
	 */
 @Raw
public Boulder(double[] Position, int Weight, Unit holder) throws IllegalArgumentException {
	super(Position, Weight, holder);
}

}