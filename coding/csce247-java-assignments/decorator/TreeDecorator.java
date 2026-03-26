package decorator;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 2/1/2026
 * 
 * Abstract class treedecorator contains methods needed to decorate Trees. 
 * 
 * Depends on ArrayLists
 * Custom helper method that merges two strings together named "mergeLines".
 */
public abstract class TreeDecorator extends Tree{

    /**
     * Create a new TreeDecorator.
     * @param lines The lines that represent the Tree's image. 
     */
    public TreeDecorator(ArrayList<String> lines){
        super(lines);
    }

    /* methods */

    /**
     * Decorates a tree with the given decor ArrayList.
     * 
     * Merges each line of the tree with each line of decor. 
     * Depends on helper method mergeLines. 
     * @param decor The ArrayList of decor to merge into the tree ArrayList named lines. 
     */
    protected void integrateDecor(ArrayList<String> decor){
        //for every line in the tree, merge it and the decor line
        for(int i = 0; i < lines.size();i++) {
            lines.set(i, mergeLines(lines.get(i), decor.get(i)));
        }
    }

    /**
     * Merges two strings together, then returns the merged string. 
     * Replaces white-space in line1 with characters in line2, keeps them in the correct location. 
     * 
     * Helper method for integrateDecor. 
     * @param line1 The first line, should be lines from the tree. 
     * @param line2 The seocnd line, shoudl be lines from the decorations. 
     * @return  Returns the merged lines in form String. 
     */
    private String mergeLines(String line1, String line2){
        // finds which line is longer, for iterative purposes
        int longest = Math.max(line1.length(), line2.length());
        // where we will store every character of the new string
        char[] res = new char[longest];
        
        // for the length of the longest string of the two..
        // return the character at i if the string is long enough. Then,
        // If the char in line1 is not a space, place the char from line1 in output string, otherwise use char from line2. 
        for(int i=0; i<longest; i++){
            char preChar = i < line1.length() ? line1.charAt(i) : ' ';
            char newChar = i < line2.length() ? line2.charAt(i) : ' ';
            res[i] = preChar != ' ' ? preChar : newChar;
        }
        return new String(res);
    }
}
