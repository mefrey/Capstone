import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
/**
 * Write a description of class SnakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld extends ActorWorld
{

    /**
     * Default constructor for objects of class SnakeWorld
     */
    public SnakeWorld(Grid grid)
    {
        super(grid);

    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public boolean keyPressed(String description, Location loc)
    {
        if (description.equals("S"))
            {
                SnakeGame.setDXDY(0,1);  
                return true;
            }
            else if (description.equals("W"))
            {
                SnakeGame.setDXDY(0,-1);
                return true;
            }
            else if (description.equals("A"))
            {
                SnakeGame.setDXDY(-1,0);   
                return true;
            }
            else if (description.equals("D"))
            {
                SnakeGame.setDXDY(1,0); 
                return true;
            }
        return false;    

    }
    
    public void step()
    {
    }

}
