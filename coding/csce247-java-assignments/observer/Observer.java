package observer;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Sean Graysmith
 * @version 1/25/2026
 * 
 * Observers observe subjects, and react when they are updated by them.
 * Observers must self-register with subjects. Depends on subject.registerObserver to self register. 
 * 
 * Has children Mom, Dad
 * 
 */
public abstract class Observer {
    /* fields */
    protected Random rand;
    protected ArrayList<Baby> babies; //this wasn't in the UML but it makes the most sense to have it here. 

    /* constructor */
    public Observer(ArrayList<Baby> babies){
        this.babies = babies;
        this.rand = new Random();
        selfRegister();
    }


    /* methods */ 

    /**
     * Update this observer on the status of a subject. 
     * @param cry   the enum Cry (angry, wet, or hungry)
     * @param baby  The subject (type Baby) that is updating this observer
     */
    public abstract void update(Cry cry, Baby baby); 

    
    /**
     * Helper method for constructor.
     * Self-registers this observer with all subjects in ArrayList babies.
     */
    private void selfRegister(){
        for (Subject subject : babies) {//self register to each subject
            subject.registerObserver(this);
        }
    }
}
