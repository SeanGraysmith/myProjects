package state;
/**
 * @author Sean Graysmith
 * @version 2/8/2026
 * 
 * The HuluState of the TV. 
 * 
 * Can switch to other states from here, and watch titles within this state.
 */
public class HuluState extends Application implements State{
    /* fields */
    private TV tv;

    /**
     * Create a new HuluState.
     * 
     * Self-populates movies and tvShows.
     * 
     * @param tv    The TV this tate belongs to.
     */
    public HuluState(TV tv){
        super();
        this.tv = tv;

        //populate movies and tv shows
        movies.add("Hulu Movie 1");
        movies.add("Hulu Movie 2");
        movies.add("Hulu Movie 3");
        movies.add("Hulu Movie 4");
        movies.add("Hulu Movie 5");
        movies.add("Hulu Movie 6");

        tvShows.add("Hulu TV Show 1");
        tvShows.add("Hulu TV Show 2");
        tvShows.add("Hulu TV Show 3");
        tvShows.add("Hulu TV Show 4");
        tvShows.add("Hulu TV Show 5");
        tvShows.add("Hulu TV Show 6");
    }
    /* methods */

    /**
     * Press the home button on the remote.
     * 
     * Switches to HomeState from HuluState.
     * Relies upon setState,getHomeState of the TV.
     */
    @Override
    public void pressHomeButton(){
        System.out.println("\nSwitching from Hulu to Home.");
        tv.setState(tv.getHomeState());
    }

    /**
     * Press the Netflix button on the remote.
     * 
     * Swithces to NetflixState from HuluState.
     * Replies upon setState,getHomeState of the TV.
     */
    @Override
    public void pressNetflixButton(){
        System.out.println("\nSwitching from Hulu to Netflix.");
        tv.setState(tv.getNetflixState());
    }

    /**
     * Press the Hulu button on the remote.
     * 
     * Does nothing since we are already in HuluState.
     */
    @Override
    public void pressHuluButton(){
        System.out.println("\nYou are already in Hulu.");
    }

    /**
     * Press the Movie button on the remote.
     * 
     * Displays a list of movies that belong to HuluState.
     * 
     * Refer to displayTVShows super documentation.
     */
    @Override
    public void pressMovieButton(){
        displayMovies();
    }

    /**
     * Press the TV button on the remote.
     * 
     * Displays a list of movies that belong to HuluState.
     * 
     * Refer to displayTVShows super documentation.
     */
    @Override
    public void pressTVButton(){
        displayTVShows();
    }

    /**
     * Watch a specified title.
     * Refer to super method watch.
     * 
     * @param title The title to watch. Must match in case and structure.
     */
    @Override
    public void watch(String title){
        super.watch(title);
    }
}
