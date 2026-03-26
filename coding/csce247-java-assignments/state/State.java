package state;
/**
 * @author Sean Graysmith
 * @version 2/8/2026
 * 
 * An interface for States.
 * States must have the methods labeled "required methods"
 */
public interface State {
    /* required methods */

    /**
     * Press the home button.
     */
    public void pressHomeButton();

    /**
     * Press the Netflix button.
     */
    public void pressNetflixButton();

    /**
     * Press the Hulu button.
     */
    public void pressHuluButton();

    /**
     * Press the movie button.
     */
    public void pressMovieButton();

    /**
     * Press the TV button.
     */
    public void pressTVButton();

    /**
     * Watch a specified title.
     * @param title The title to watch.
     */
    public void watch(String title);
}
