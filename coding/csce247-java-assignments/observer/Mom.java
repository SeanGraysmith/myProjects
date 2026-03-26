package observer;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 1/25/2026
 * 
 * The mother of the subject(s). 
 * Acts on problems she is updated on. 
 * 
 * Accesses public methods of the Baby to act when updated. 
 */
public class Mom extends Observer{
    /* constructor */

    /**
     * Creates a new Mom.
     * Refer to Observer for detailed construction documentation.
     * 
     * Calls super. 
     * @param babies    The list of subjects (type Baby)
     */
    public Mom(ArrayList<Baby> babies){
        super(babies);
    }

    /* methods */

    /**
     *  Updates this observer on a Baby. 
     *  
     *  Depending on the type of Cry, chooses action to solve it. 
     *  Prints to console.
     *  Calls public Baby methods getName, receiveLove, eat, getChanged. 
     */
    public void update(Cry cry, Baby baby){
        switch(cry){
            case ANGRY:
                System.out.println("\nMom hugs " + baby.getName());
                baby.receiveLove();
                break;
            case HUNGRY:
                System.out.println("\nMom feeds " + baby.getName());
                baby.eat();
                break;
            case WET:
                System.out.println("\nMom changes " + baby.getName());
                baby.getChanged();
                break;
        }
    }
    
}
