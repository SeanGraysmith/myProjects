package state;
/**
 * @author Sean Graysmith
 * @version 2/8/2026
 * 
 * A Netflix State. Implements State and extends Application. 
 * 
 * Netflix is an application that has TV Shows and Movies.
 * Can switch states, and watch titles from here.
 * 
 * Relies upon ArrayList movies, ArrayList tvShows. 
 */
public class NetflixState extends Application implements State{
    /* fields */
    private TV tv;
    
    /**
     * Create a new NetflixState.
     * 
     * Self populates movies and tvShows.
     * @param tv    The TV that this is a state of. 
     */
    public NetflixState(TV tv){
        super();
        this.tv = tv;

        //populate movies & tv
        movies.add("Netflix Movie 1");
        movies.add("Netflix Movie 2");
        movies.add("Netflix Movie 3");
        movies.add("Netflix Movie 4");
        movies.add("Netflix Movie 5");
        movies.add("Netflix Movie 6");

        tvShows.add("Netflix TV Show 1");
        tvShows.add("Netflix TV Show 2");
        tvShows.add("Netflix TV Show 3");
        tvShows.add("Netflix TV Show 4");
        tvShows.add("Netflix TV Show 5");
        tvShows.add("Netflix TV Show 6");
    }

    /* methods */
    
    /**
     * Press the home button on the remote. 
     * 
     * Switches to the HomeState from NetflixState.
     * Relies upon setState, getHomeState of the stored tv.
     */
     @Override
    public void pressHomeButton(){
        System.out.println("\nSwitching from Netflix to Home.");
        tv.setState(tv.getHomeState());
    }

    /**
     * Press the Netflix button on the remote.
     * 
     * Does not switch since we are already in Netflix.
     */
    @Override
    public void pressNetflixButton(){
        System.out.println("\nYou are already on Netflix.");
    }

    /**
     * Press the Hulu button on the remote.
     * 
     * Switches to the HuluState from NetflixState.
     * Relies upon setState, getHomeState of the stored tv.
     */
    @Override
    public void pressHuluButton(){
        System.out.println("\nSwitching from Netflix to Hulu.");
        tv.setState(tv.getHuluState());
    }

    /**
     * Press the movie button on the remote.
     * 
     * Prints a list of movies. 
     * Relies upon super method displayMovies.
     */
    @Override
    public void pressMovieButton(){
        displayMovies();
    }

    /**
     * Press the TV button on the remote.
     * 
     * Prints a list of TV shows.
     * Relies upon super method displayTVShows.
     */
    @Override
    public void pressTVButton(){
        displayTVShows();
    }

    /**
     * Watch a title. 
     * See super watch method for detailed watch documentation. 
     * 
     * @param title The title to watch. Must match exactly by case and structure. 
     */
    @Override
    public void watch(String title){
        super.watch(title);
    }
}
