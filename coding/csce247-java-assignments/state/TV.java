package state;

/**
 * @author Sean Graysmith
 * @version 2/8/2026
 * 
 * A TV. 
 * 
 * Has three possible states; 
 * HomeState, NetflixState, HuluState
 * 
 * When a button method is called,
 * the related button method within the current state is called.
 * See Documentation within each state for detailed operational documentation.
 * 
 */
public class TV {
    /* fields */
    private State HomeState;
    private State NetflixState;
    private State HuluState;
    private State state;

    /**
     * Create a new TV
     * 
     * The starting state is HomeState.
     */
    public TV(){
        this.HomeState = new HomeState(this);
        this.NetflixState = new NetflixState(this);
        this.HuluState = new HuluState(this);

        state = HomeState;
    }

    /* methods */
    
    /**
     * Press the home button on the remote.
     * Relies upon pressHomeButton of the current state.
     * 
     * @return  Returns a string that represents what is happening.
     */
    public String pressHomeButton(){
        state.pressHomeButton();
        return "\nThe home button is pressed.";
    }

    /**
     * Press the Netflix button on the remote.
     * Relies upon pressNetflixButton of the current state.
     * 
     * @return  Returns a string that represents what is happening. 
     */
    public String pressNetflixButton(){
        state.pressNetflixButton();
        return "\nThe Netflix button is pressed.";
    }

    /**
     * Press the Hulu button on the remote. 
     * Relies upon pressHuluButton of the current state.
     * 
     * @return  Returns a String that represents what is happening. 
     */
    public String pressHuluButton(){
        state.pressHuluButton();
        return "\nThe Hulu button is pressed.";
    }

    /**
     * Press the movie button on the remote.
     * Relies upon pressMovieButton of the current state.
     * 
     * @return  Returns a string that represents what is happening.
     */
    public String pressMovieButton(){
        state.pressMovieButton();
        return "\nThe Movie button is pressed.";
    }

    /**
     * Press the TV button on the remote.
     * Relies upon pressTVButton of the current state.
     * 
     * @return  Returns a string that represents what is happening
     */
    public String pressTVButton(){
        state.pressTVButton();
        return "\nThe TV button is pressed.";
    }

    /**
     * Sets the current state of the TV.
     * 
     * @param state The new State for this TV.
     */
    public void setState(State state){
        this.state = state;
    }

    /**
     * Get the HomeState object of this TV.
     * 
     * @return  Returns the HomeState of type State.
     */
    public State getHomeState(){
        return HomeState;
    }

    /**
     * Get the NetflixState object of this TV.
     * 
     * @return  Returns the NetflixState of type State.
     */
    public State getNetflixState(){
        return NetflixState;
    }

    /**
     * Get the HuluState object of this TV.
     * 
     * @return  Returns the HuluState of type State.
     */
    public State getHuluState(){
        return HuluState;
    }

    /**
     * Watch a title within the current State.
     * 
     * @param title The title to watch. Must match including case. 
     */
    public void watch(String title){
        state.watch(title);
    }
}
