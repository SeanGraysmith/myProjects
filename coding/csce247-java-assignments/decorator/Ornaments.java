package decorator;
/**
 * @author Sean Graysmith
 * @version 2/1/2026
 * 
 * An ornament decoration for a tree. 
 * The image for ornaments is located at: decorator/txt/ornaments.txt
 */
public class Ornaments extends TreeDecorator{
    /* fields */
    private Tree tree;

    /**
     * Add ornaments decoration to the given tree. 
     * Depends on integrateDecor to merge lines. See integrateDecor in TreeDecorator class. 
     * Depends on FileReader getLines to read text files into ArrayList. 
     * 
     * @param tree  The tree to add ornaments to. 
     */
    public Ornaments(Tree tree){
        super(tree.lines);
        this.tree = tree;
        integrateDecor(FileReader.getLines("decorator/txt/ornaments.txt"));
    }
}
