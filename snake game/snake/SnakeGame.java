import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.util.Random;
import java.awt.Color;
import javax.swing.JComponent;

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeGame
{
    /** description of instance variable x (add comment for each instance variable) */
    private static SnakeWorld world;
    /** description of instance variable x (add comment for each instance variable) */
    private static final int ROWS = 25;
    /** description of instance variable x (add comment for each instance variable) */
    private static final int COLS = 25;

    private static int dX;

    private static int dY;

    private Critter head;

    private Location headLocation;

    private Critter food;

    private Critter[] tail;

    private boolean isDead;
    
    private Random random;

    /**
     * Default constructor for objects of class Board
     */
    public SnakeGame()
    {
        // create the grid
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on grid
        world = new SnakeWorld(grid);

        // display world
        world.show();

        //start game
        random = new Random();
        this.isDead = false;
        //makes the head of snake and places it on the board
        this.head = new Head();
        headLocation = new Location(random.nextInt(ROWS),random.nextInt(COLS));
        world.add(headLocation,head);
        //makes the food and places it on the board
        this.food = new Food();
        Location foodLocation = new Location(random.nextInt(ROWS),random.nextInt(COLS));
        world.add(foodLocation,food);
    }


    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void update()
    {
        Grid<Actor> grid = world.getGrid();
        Location newLoc = new Location(
                this.headLocation.getRow()+this.dX,
                this.headLocation.getCol()+this.dY);
        if (newLoc.getRow()< ROWS && 
            newLoc.getRow()> 0 &&
            newLoc.getCol()< COLS && 
            newLoc.getCol()> 0 &&
            grid.get(newLoc) == null)
        {
            this.head.makeMove(newLoc);
        }
        else if ( grid.get(newLoc) == this.food)
        {
            Location foodLocation = new Location(random.nextInt(ROWS),random.nextInt(COLS));
            //this.food.makeMove(foodLocation,food);
            this.head.makeMove(newLoc);
            
        }
        else
        {
            this.isDead = true;
        }
        this.world.toString();
    }

    public static void setDXDY(int dx, int dy)
    {
        SnakeGame.dX = dx;
        SnakeGame.dY = dy;
    }

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public static void main(String[] args)throws InterruptedException
    {
        SnakeGame game = new SnakeGame();

        while ( game.isDead == false )
        {
            Thread.sleep(500); // sleep 1000 milliseconds (1 second)
            game.update();
            if( game.dY == -1)game.isDead = true;
        }
    }


}
