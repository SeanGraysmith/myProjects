package state;
import java.util.ArrayList;

/**
 * @author Sean Graysmith
 * @version 2/8/2026
 * 
 * An application, abstract.
 * 
 * Applications have lists of movies and TV shows, are able to list them to the console,
 * and can watch titles. 
 */
public abstract class Application {
    /* fields */
    protected ArrayList<String> movies = new ArrayList<String>();
    protected ArrayList<String> tvShows = new ArrayList<String>();


    /* methods */

    /**
     * Watch a specified title. Can watch any movie or TV show
     * contained within the movies or tvshow ArrayList of the current application.
     * 
     * Titles must match exactly in case and structure. 
     * 
     * @param title The title to watch. Must match exactly in case and structure.
     * 
     * The .contains method of an ArrayList checks each element using .equals, which is why
     * the strings provided must match exactly.
     */
    public void watch(String title){
        if(movies.contains(title)){
            System.out.println("\nWatched " + title);
        } else if (tvShows.contains(title)) {
            System.out.println("\nWatched " + title);
        } else {
            System.out.println("\nTitle not found.");
        }
    }

    /**
     * Print a list of movies in the current application to the console.
     * Relies upon the ArrayList structure to function.
     */
    public void displayMovies(){
        System.out.println("\nAvailable Movies:");
        for(String movie : movies){
            System.out.println(movie);
        }
    }

    /**
     * Print a list of TV Shows in the current application to the console.
     * Relies upon the ArrayList structure to function. 
     */
    public void displayTVShows(){
        System.out.println("\nAvailable TV Shows:");
        for(String tvShow : tvShows){
            System.out.println(tvShow);
        }
    }
}
