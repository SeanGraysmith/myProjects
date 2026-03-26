package observer;
/**
 * @author Sean Graysmith
 * @version 1/25/2026
 * 
 * Interface for subjects.
 * Subjects are observed by Observers. Who will act when they are updated by the subject. 
 * 
 * There are three required methods for subjects: registerObserver, removeObserver, notifyObservers.
 */
public interface Subject {

    /**
     * Register a new observer for this subject.
     * Refer to type specific (Baby) documentation for detailed information on this method. 
     * 
     * @param observer The new observer to register, of type Observer. 
     */
    public void registerObserver(Observer observer);

    /**
     * Remove an existing observer for this subject. 
     * Refer to type specific (Baby) documentation for detailed information on this method. 
     * 
     * @param observer  The existing observer to remove from the observers list. 
     */
    public void removeObserver(Observer observer);

    /**
     * Notify all observers of crying.
     * Refer to type specific (Baby) documentation for detailed information on this method. 
     * 
     * @param cry   The cry of type Cry, which can be either ANGRY, HUNGRY, or WET. 
     */
    public void notifyObservers(Cry cry);
}
