package strategy;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
/**
 * @author Sean Graysmith
 * @version 1/18/2026
 * 
 * An abstract class for the movement behavior of animals. 
 * When the move method is called, since move is an abstract method, the corresponding move method's class is called. Ex. Rabbits have a JumpBehavior so their JumpBehavior's move method is called;
 * the move method within the child classes calls the parameterized version of move (i.e. move(boolean jump) ) so that animals can either walk or jump. 
 * 
 * NOTE: There is a display flicker when animals are moving and I think its associated with the clear method or how it is used; but I can't seem to fix it. 
 * 
 * Methods clear and sleep were given. 
 */
public abstract class MoveBehavior {
    private final int NUM_MOVES = 30;
    private int speed;
    private ArrayList<String> character;

    /**
     * Parameterized constructor for MoveBehaviors. 
     * @param character The ArrayList that holds the ascii-art.
     * @param speed     The speed at which the animal moves.
     */
    public MoveBehavior(ArrayList<String> character, int speed){
        this.character = character;
        this.speed = speed;
    }

    /**
     * Non-parameterized abstract move requires each child to have their own corresponding move method. 
     */
    public abstract void move();

    /**
     * Parameterized move method that both children will access to move the animals. 
     * Animals will display and then their ascii-art is altered for the next iteration. 
     * 
     * Depends on clear, displayCharacter,pushCharacterForward, and sleep methods. 
     * Depends on NUM_MOVES for how long the animals move for. 
     * 
     * The speed of the animal determines how long the program sleeps for between movements. 
     * 
     * @param jump  boolean for if the animal jumps or not. 
     */
    protected void move(boolean jump){
        for(int i=0;i<NUM_MOVES;i++){
            if(i%2 == 0 && jump){ //every other iteration a line is printed before displaying the character (only if it is a jumping character)
                                  //this creates the jumping effect
                System.out.println();
            }
            displayCharacter();
            pushCharacterForward();
            sleep(300 / speed);
            clear();
        }
    }

    /**
     * Adds a space to the beginning of each line of the avatar.
     * This makes the visual effect of the character moving to the right side. 
     */
    private void pushCharacterForward(){
        for(int i=0;i < character.size(); i++){
            String temp = " " + character.get(i);
            character.set(i, temp);
        }
    }
    /**
     * Displays the characters "avatar" to the screen. 
     * Prints line-by-line. 
     */
    private void displayCharacter(){
        System.out.println();
        for(String line: this.character){
            System.out.println(line);
        }
    }

    /**
     * Pauses the program
     * This method was given. 
     * 
     * @param num The miliseconds to pause the program for
     */
    private void sleep(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }
    /**
     * Clears the console
     * This method was given. 
     */
    private void clear() {
        System.out.print("\033[H\033[2J");
    }
}
