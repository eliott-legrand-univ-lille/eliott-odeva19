package fil.coo.util;

/**
 * <b>Enum that represent the different cardinal point</b>
 * 
 * <p> You can have the direct opposite direction </p>
 * 
 * @author legrand,santi
 *
 */
public enum Direction implements Chooseable {
	NORTH,SOUTH,EAST,WEST;
	
	/** Return Direction's opposite
	 * @return Direction's opposite
	 */
	public Direction getOpposite(){
		if (this == NORTH){
			return SOUTH;
		}
		if (this == SOUTH){
			return NORTH;
		}
		if (this == EAST){
			return WEST;
		}
		else{ 
			return EAST;
		}
	}
}
