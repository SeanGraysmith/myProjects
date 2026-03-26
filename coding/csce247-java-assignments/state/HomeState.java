package state;
/**
 * @author Sean Graysmith
 * @version 2/8/2026
 * 
 * The HomeState of the TV. This should be the starting state.
 * 
 * Can switch states from here, but there are not titles to watch.
 */
public class HomeState implements State{
    /* fields */
    private TV tv;

    /**
     * Create a new HomeState
     * @param tv    The TV that this is a state of.
     */
    public HomeState(TV tv){
        this.tv = tv;
    }

    /* methods */

    /**
     * Press the home button on the remote.
     * 
     * Does not change state since you are already in Home.
     */
    @Override
    public void pressHomeButton(){
        System.out.println("\nYou are already at Home.");
    }

    /**
     * Press the Netflix button on the remote.
     * 
     * Switches to the Netflix state from Home.
     * Relies upon setState,getNetflixState of the stored tv.
     */
    @Override
    public void pressNetflixButton(){
        System.out.println("\nSwitching from Home to Netflix.");
        tv.setState(tv.getNetflixState());
    }

    /**
     * Press the Hulu button on the remote.
     * 
     * Switches to Hulu state from Home.
     * Relies upon setState,getHuluState of the stored tv.
     */
    @Override
    public void pressHuluButton(){
        System.out.println("\nSwitching from Home to Hulu.");
        tv.setState(tv.getHuluState());
    }

    /**
     * Press the Movie button on the remote.
     * 
     * There are no movies in Home.
     */
    @Override
    public void pressMovieButton(){
        System.out.println("\nThere are no movies in Home. Try Netflix or Hulu.");
    }

    /**
     * Press the TV button on the remote.
     * 
     * There are no TV shows in home.
     */
    @Override
    public void pressTVButton(){
        System.out.println("\nThere are no TV shows in Home. Try Netflix or Hulu.");
    }

    /**
     * Press the watch button on the remote.
     * 
     * There are no titles in Home.
     */
    @Override
    public void watch(String title){
        System.out.println("\nThere are no titles to watch in Home.");
    }
}
