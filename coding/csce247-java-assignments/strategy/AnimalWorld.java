package strategy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Animal world moving program
 */
public class AnimalWorld {
    private static final String YES = "y";
    private static final String NO = "n";
    private Scanner reader;

    public AnimalWorld() {
        reader = new Scanner(System.in);
    }

    /**
     * Runs the program, letting the user pick which character to move
     */
    public void run() {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Bird("Tweety"));
        animals.add(new Elephant("Charlie"));
        animals.add(new Rabbit("Eco"));

        while (true) {
            displayCharacters(animals);
            System.out.print("Who would you like to move: ");
            String characterName = reader.nextLine().toLowerCase().trim();

            if (!moveAnimals(animals, characterName)) {
                System.out.println(characterName + " isn't in our list");
            }

            if (!playAgain()) {
                break;
            }
        }

        reader.close();
        System.out.println("Goodbye");

    }

    /**
     * Moves the animal forward
     * 
     * @param animals        The list of animals
     * @param characterName The name of the animal to move
     * @return true if the animal moves and false otherwise
     */
    private boolean moveAnimals(ArrayList<Animal> animals, String characterName) {
        for (Animal animal : animals) {
            if (animal.toString().equalsIgnoreCase(characterName)) {
                animal.move();
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the animals and their names
     * 
     * @param animals The list of animals
     */
    private void displayCharacters(ArrayList<Animal> animals) {
        System.out.println("You have the following 3 characters");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    /**
     * Asks the user if they would like to continue
     * If they enter yes, it returns true, otherwise it returns false
     * 
     * @return True if they want to play again, and false otherwise
     */
    private boolean playAgain() {
        while (true) {
            System.out.print("Do you want to continue (Y)es or (N)o: ");
            String command = reader.nextLine().toLowerCase().trim();

            if (command.equals(YES)) {
                return true;
            } else if (command.equals(NO)) {
                return false;
            } else {
                System.out.println("Sorry, that's not a valid command");
            }
        }
    }

    public static void main(String[] args) {
        AnimalWorld world = new AnimalWorld();
        world.run();
    }
}
