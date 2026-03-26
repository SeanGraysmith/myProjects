package singleton;
import java.util.ArrayList;
/**
 * @author Sean Graysmith
 * @version 2/15/2026
 * 
 * A clothing item. 
 * 
 * Depends on:
 * ArrayList, package class FileReader
 * 
 */
public class ClothingItem {
    /* fields */
    private String name;
    private String color;
    private ArrayList<Season> seasons;

    /**
     * Create a new Clothing Item. 
     * Clothing items have names, colors, and a list of seasons. 
     * 
     * @param name  The name of this item.
     * @param color The color of this item.
     */
    public ClothingItem(String name, String color){
        this.name = name;
        this.color = color;
        this.seasons = new ArrayList<Season>(4);
    }

    /* methods */

    /**
     * Checks whether this outfit has the given season in it's season arraylist.
     * @param season    The season to check for. 
     * @return  Returns bool for if it contains the season or not. 
     */
    public boolean hasSeason(Season season){
        if (seasons.contains(season)){
            return true;
        } 
        return false;
    }

    /**
     * Adds a season to the seasons arraylist.
     * 
     * @param season    The season to add.
     */
    public void addSeason(Season season){
        seasons.add(season);
    }

    /**
     * Converts this ClothingItem to a string. 
     * 
     * Follows the format:
     * "a <<color>> <<name>>""
     */
    @Override
    public String toString(){
        String ret = "";
        ret += "a " + color + " " + name;
        return ret;
    }
}
