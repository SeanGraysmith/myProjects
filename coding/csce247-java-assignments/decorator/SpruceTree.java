package decorator;

/**
 * @author Sean Graysmith
 * @verison 2/1/2026
 * 
 * A spruce tree. 
 * The image of this tree is located at decorator/txt/spruce-tree.txt
 */
public class SpruceTree extends Tree{
    /**
     * Create a new SpruceTree.
     * 
     * Depends on FileReader getLines to read lines into an ArrayList. 
     */
    public SpruceTree(){
        super(FileReader.getLines("decorator/txt/spruce-tree.txt"));
    }
}