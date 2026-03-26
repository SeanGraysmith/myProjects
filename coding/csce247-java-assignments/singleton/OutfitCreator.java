package singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/**
 * @author Sean Graysmith
 * @version 2/15/2026
 * 
 * An outfit creator. 
 * 
 * Will create an outfit by randomly choosing items in the hashmap, refer to getOutfit for detailed documentation.
 * 
 * Depends on:
 * ArrayList, HashMap, Random, package class FileReader
 */
public class OutfitCreator {
    /* fields */
    private HashMap<ClothingPart, ArrayList<ClothingItem>> clothing;
    private Random rand;
    private static OutfitCreator outfitCreator;

    /**
     * Create a new OutfitCreator.
     * Has a HashMap that contains three keys:
     * TOPS,BOTTOMS,WHOLES
     */
    private OutfitCreator(){
        this.rand = new Random();
        clothing = new HashMap<ClothingPart, ArrayList<ClothingItem>>();

        // populate hashmap, three columns 
        // TOP,BOTTOM,WHOLE
        clothing.put(ClothingPart.TOP, FileReader.getTops());
        clothing.put(ClothingPart.BOTTOM, FileReader.getBottoms());
        clothing.put(ClothingPart.WHOLE, FileReader.getwholes());
    }

    /* methods */
    
    /**
     * Returns the instance of OutfitCreator. 
     * Creates new OutfitCreator if it is null. 
     * 
     * @return  The OutfitCreator.
     */
    public static OutfitCreator getInstance() {
        if (outfitCreator == null){
            outfitCreator = new OutfitCreator();
        }
        return outfitCreator;
    }

    /**
     * Gets an outfit for the given season. 
     * 
     * Chooses randomly between a whole outfit and a two-piece outfit.
     * Populates arraylist of items that match the provided season.
     * Chooses an outfit at random from the arraylists.
     * 
     * @param season    The season that the outfit will match.
     * @return  Returns the outfit as a String.
     */
    public String getOutfit(Season season){
        String outfitString = "";
        boolean wholeOutfit = rand.nextBoolean(); //choosing whole outfit or two-piece outfit
        if (wholeOutfit){ //whole outfits
            ArrayList<ClothingItem> validWholes = new ArrayList<ClothingItem>();

            //populates the arraylist with whole outfits that match the given season
            for (ClothingItem item : clothing.get(ClothingPart.WHOLE)) {
                if (item.hasSeason(season)){
                    validWholes.add(item);
                }
            }
            //chooses an outfit at random and converts it to the string.
            outfitString = validWholes.get(rand.nextInt(validWholes.size())).toString();
        } else { //two piece outfits
            ArrayList<ClothingItem> validTops = new ArrayList<ClothingItem>();
            ArrayList<ClothingItem> validBottoms = new ArrayList<ClothingItem>();

            //populating arraylist with valid tops
            for (ClothingItem item : clothing.get(ClothingPart.TOP)){
                if (item.hasSeason(season)){
                    validTops.add(item);
                }
            }
            //populating arraylist with valid bottoms
            for (ClothingItem item : clothing.get(ClothingPart.BOTTOM)){
                if(item.hasSeason(season)){
                    validBottoms.add(item);
                }
            }

            //choosing at random a top and bottom and then setting the output string.
            ClothingItem selectedTop = validTops.get(rand.nextInt(validTops.size()));
            ClothingItem selectedBottom = validBottoms.get(rand.nextInt(validBottoms.size()));
            outfitString = selectedTop + "and " + selectedBottom;
        }
        return outfitString;
    }
}
