package strategy;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 1/18/2026
 * 
 * Child of MoveBehavior, behavior for animals that only walk and do not jump. 
 * 
 */
public class WalkBehavior extends MoveBehavior{

    /**
     * Parameterized constructor for WalkBehavior. 
     * 
     * @param character The Ascii-art ArrayList of strings. 
     * @param speed     The int speed at which the animal moves. 
     */
    public WalkBehavior(ArrayList<String> character, int speed){
        super(character, speed);
    }

    /**
     * Make the animal walk. 
     * Depends on the protected move(boolean jump) method in the parent class. 
     */
    @Override
    public void move(){
        move(false);
    }
}