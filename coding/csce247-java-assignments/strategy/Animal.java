package strategy;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 1/18/2026
 * 
 * An abstract class that contains general attributes of animals.
 * Character is the ArrayList of strings that holds the "picture" representation of the animal.
 * Currently has children Bird, Elephant, Rabbit.
 * 
 * See class MoveBehavior for detailed movement documentation. 
 * 
*/
public abstract class Animal {
    protected String name;
    protected ArrayList<String> character; //holds the ascii-art characters in line-by-line form
    protected MoveBehavior moveBehavior; //all animals move, but they declare their own behavior in their class. 

    /**
     * Parameterized constructor for animal. 
     * @param name  The name to be given to the animal
     */
    public Animal(String name){
        this.character = new ArrayList<String>();
        this.name = name;
    }

    /**
     * Make the animal move by calling its moveBehavior.move. 
     * This depends on moveBehavior having a move method that determines the correct movement type. 
     */
    public void move(){
        moveBehavior.move();
    }

    /**
     * Returns the animal's name as a String. 
     * 
     * @return the String name of the animal.     
     */
    @Override
    public String toString(){
        return name;
    }
}
