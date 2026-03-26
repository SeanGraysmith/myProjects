package observer;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Sean Graysmith
 * @version 1/25/2026
 * 
 * Baby, an implentation of Subject. 
 * 
 * Has a list of observers which should be populated with at least one observer for this class to function correctly once initialized. 
 * Uses Random and ArrayList. 
 */
public class Baby implements Subject{
    /* fields */
    private String name;
    private ArrayList<Observer> observers;
    private Random rand;

    /* constructor */

    /**
     * Creates a new Baby.
     * 
     * observers ArrayList has an initial capacity of 2.
     * @param name
     */
    public Baby(String name){
        this.name = name;
        observers = new ArrayList<Observer>(2);
        this.rand = new Random();
    }

    /* methods */

    /**
     * Get the name of this baby.
     * @return  Returns the name in form String. 
     */
    public String getName(){
        return name;
    }

    /**
     * Receive love from an observer. 
     * 
     * Uses Random rand to determine action. nextBoolean returns either True or False with a 50/50 chance. 
     */
    public void receiveLove(){
        if(rand.nextBoolean()){
            System.out.println("\n" + this.getName() + " feels appreciated and loved.");
        } else {
            System.out.println("\n" + this.getName() + " pushes everyone away and continues to cry.");
        }
    }

    /**
     * The baby eats...or not.
     * 
     * Uses Random rand to determine action. nextBoolean returns either True or False with a 50/50 chance. 
     */
    public void eat(){
        if (rand.nextBoolean()){
            System.out.println("\n" + this.getName() + " has a happy full tummy.");
        } else {
            System.out.println("\n" + this.getName() + " throws all his food on the floor.");
        }
    }

    /**
     * Get changed into a new diaper. 
     * 
     * Prints to stdout. 
     */
    public void getChanged(){
        System.out.println("\n" + this.getName() + " is having a diaper change");
    }

    /**
     * Register a new observer into the observers ArrayList.
     * Observers are stored in an ArrayList observer which contains all active observers of this Baby. 
     * 
     * @param observer  The new observer to register. 
     */
    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    /**
     * Remove a registered observer from the ArrayList.
     * Observers are stored in an ArrayList observer which contains all active observers of this Baby.
     * 
     * @param observer  The active observer to remove. 
     */
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    /**
     * Notify observers of a new occurence (the baby is crying)
     * All observers are notified and passed the Cry. 
     * 
     * @param cry   The Cry for this notification, must be either ANGRY, HUNGRY, or WET.
     */
    @Override
    public void notifyObservers(Cry cry){
        for (Observer observer : observers){
            observer.update(cry, this);
        }
    }

    /**
     * Cry because of being angry.
     * 
     * Depends on notifyObservers to notify. Passes a Cry.ANGRY. 
     */
    public void angryCry(){
        System.out.println("\nWaaaaaaaaa! " + this.getName() + " is feeling abandoned and angry.");
        notifyObservers(Cry.ANGRY);
    }

    /**
     * Cry because of being hungry.
     * 
     * Depends on notifyObservers to notify. Passes Cry.HUNGRY.
     */
    public void hungryCry(){
        System.out.println("\nNeh Neh Neh! " + this.getName() + " is starving!!!");
        notifyObservers(Cry.HUNGRY);
    }

    /**
     * Cry because of being wet.
     * 
     * Depends on notifyObservers to notify. Passes Cry.WET.
     */
    public void wetCry(){
        System.out.println("\nAaaaaa! " + this.getName()  + " is WET!");
        notifyObservers(Cry.WET);
    }
}
