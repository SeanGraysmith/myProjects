package singleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Responsible for reading file
 */
public class FileReader {
    private static final String TOPS_FILE_NAME = "singleton/txt/tops.txt";
    private static final String BOTTOMS_FILE_NAME = "singleton/txt/bottoms.txt";
    private static final String WHOLES_FILE_NAME = "singleton/txt/wholes.txt";

    public static ArrayList<ClothingItem> getTops(){
        return getClothing(TOPS_FILE_NAME);
    }

    public static ArrayList<ClothingItem> getBottoms(){
        return getClothing(BOTTOMS_FILE_NAME);
    }

    public static ArrayList<ClothingItem> getwholes(){
        return getClothing(WHOLES_FILE_NAME);
    }

    /**
     * Reads in the file and creates a list of clothing
     * 
     * @param fileName The file to read through
     * @return A list of clothing items
     */
    private static ArrayList<ClothingItem> getClothing(String fileName) {
        ArrayList<ClothingItem> clothing = new ArrayList<ClothingItem>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(":");
                ClothingItem item = new ClothingItem(data[0], data[1].trim());
                String[] itemSeasons = data[2].split(",");

                for (Season season : Season.values()) {
                    if (hasSeason(itemSeasons, season)) {
                        item.addSeason(season);
                    }
                }

                clothing.add(item);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        return clothing;
    }

    private static boolean hasSeason(String[] data, Season season) {
        for (String item : data) {
            if (item.trim().equalsIgnoreCase(season.toString())) {
                return true;
            }
        }
        return false;
    }
}
