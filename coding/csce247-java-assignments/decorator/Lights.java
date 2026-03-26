package decorator;
/**
 * @author Sean Graysmith
 * @version 2/1/2026
 * 
 * A lights decoration for a tree. 
 * The image for lights is located at: decorator/txt/lights.txt
 */
public class Lights extends TreeDecorator{
    /* fields */
    private Tree tree;

    /**
     * Add lights to the given tree. 
     * Depends on integrateDecor to merge lines. See integrateDecor in TreeDecorator class.
     * Depends on FileReader getLines to read text files to ArrayList. 
     * 
     * @param tree  The tree to add lights to. 
     */
    public Lights(Tree tree){
        super(tree.lines);
        this.tree = tree;
        integrateDecor(FileReader.getLines("decorator/txt/lights.txt"));
    }
}
