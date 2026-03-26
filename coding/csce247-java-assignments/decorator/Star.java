package decorator;
/**
 * @author Sean Graysmith
 * @version 2/1/2026
 * 
 * A Star decoration for a tree.
 * The image of the star is located at: decorator/txt/star.txt
 */
public class Star extends TreeDecorator{
    /* fields */
    private Tree tree;
    
    /**
     * Add a star decoration to the given tree.
     * Depends on integrateDecor to merge decorations into the tree. See integrateDecor in TreeDecorator class.
     * Depends on FileReader getLines to read text files to ArrayList. 
     * 
     * @param tree  The tree to add the decoration to.
     */
    public Star(Tree tree){
        super(tree.lines);
        this.tree = tree;
        integrateDecor(FileReader.getLines("decorator/txt/star.txt"));
    }
}
