package strategy;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 1/18/2026
 * 
 * Child of MoveBehavior, behavior for jumping animals. 
 * 
 */
public class JumpBehavior extends MoveBehavior{
    /**
     * Parameterized constructor for JumpBehavior. 
     * @param character The ascii-art ArrayList of Strings
     * @param speed     The speed at which the animal moves. 
     */
    public JumpBehavior(ArrayList<String> character, int speed){
        super(character, speed);
    }

    /**
     * Make the animal jump forward. 
     * Depends on the protected move(boolean jump) method in the parent class. 
     */
    @Override
    public void move(){
        move(true);
    }
}
