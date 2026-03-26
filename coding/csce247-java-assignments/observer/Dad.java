package observer;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 1/25/2026
 * 
 * The low-effort father of the subject(s). 
 * Observes baby and acts when updated by one. 
 * 
 * Depends on Random to function.
 */
public class Dad extends Observer{
    /* constructor */

    /**
     * Creates a new Dad.
     * Refer to Observer for documentation on construction. 
     * 
     * Calls super. 
     * 
     * @param babies    The list of subjects (type Baby)
     */
    public Dad(ArrayList<Baby> babies){
        super(babies);
    }

    /* methods */

    /**
     * Updates this observer on a Baby. 
     * Chooses randomly from a set of three "actions"
     * 
     * Uses Random rand to choose the option.
     */
    public void update(Cry cry, Baby baby){
        switch(rand.nextInt(3)){ //switch on 0,1,2
            case 0:
                System.out.println("\nDad puts a pillow over his head");
                break;
            case 1:
                System.out.println("\nDad nudges mom");
                break;
            case 2:
                System.out.println("\nDad screams....aaaaaaaaa");
                break;
        }
    }
}
