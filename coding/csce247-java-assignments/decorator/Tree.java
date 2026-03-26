package decorator;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 2/1/2026
 * 
 * Abstract class tree.
 * Trees have an ArrayList of Strings that can be printed to create their image in the terminal.
 * Depends on ArrayList
 * 
 * Refer to toString to see how Trees are converted to colorful images in the terminal.
 * 
 */
public abstract class Tree {
    /* color constants */
    private static final String RESET = "\033[0m";  // Text Reset
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String WHITE = "\033[0;37m";   // WHITE
    private static final String RED = "\033[0;31m";     // RED
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BROWN = "\u001B[38;2;139;69;19m"; // RGB: 139, 69, 19
    
    /* fields */
    protected ArrayList<String> lines;

    /**
     * Create a new tree.
     * 
     * @param lines the arraylist of strings that create the image of this tree
     */
    public Tree(ArrayList<String> lines){
        this.lines = lines;
    }

    /* methods */

    /**
     * Convert the image of this tree into a printable string. 
     * 
     * Replaces letters G,W,R,Y,B with respective color coding:
     *             green,white,red,yellow,brown
     * 
     * Returns the image of this tree as a String with each line separated by newline characters. 
     */
    @Override
    public String toString() {
        String ret = "";
        for (String line : lines){
            // making lines that contain Y line up correctly in the terminal
            if (line.contains("Y")){
                line = " " + line;
            }
            line = line.replaceAll(">", " >"); //moving the right corner of the star to line up correctly

            // replacing color locations with color codes in text
            line = line.replaceAll("G",GREEN + " ");
            line = line.replaceAll("W\\*",WHITE + " *" + GREEN);
            line = line.replaceAll("R\\(\\)",RED + " \\(\\)" + GREEN);
            line = line.replaceAll("Y",YELLOW);
            line = line.replaceAll("B",BROWN + " ");
            ret += line + "\n";
        }

        // reset to end of tree string to make sure terminal text does not change color
        ret += RESET;
        return ret;
    }
}
