package decorator;

import java.util.Scanner;

public class TreeDriver {
	private static final String YES = "y";
	private static final String NO = "n";
	private Scanner reader;

	public TreeDriver() {
		reader = new Scanner(System.in);
	}

	public void runDriver() {
		Tree tree = new SpruceTree();
		System.out.println("\n******* We brought home our tree *******");
		System.out.println(tree);



		while (true) {
			String addition = getText("What would you like to add to your tree: '(S)tar', '(L)ights', or '(O)rnaments: ");
			
            if (addition.equalsIgnoreCase("s")) {
                tree = new Star(tree);
				System.out.println(tree);
			}
			else if(addition.equalsIgnoreCase("l")){
				tree = new Lights(tree);
				System.out.println(tree);
			} 
			else if(addition.equalsIgnoreCase("o")){
				tree = new Ornaments(tree);
				System.out.println(tree);
			}
			else {
				System.out.println("invalid command");
			}

            if (!playAgain()) {
                break;
            }
        }

        reader.close();
        System.out.println("Goodbye");
	}

	private String getText(String prompt) {
		int num = 0;
		System.out.print(prompt);
		return reader.nextLine().trim();
	}

	 /**
     * Asks the user if they would like to continue
     * If they enter yes, it returns true, otherwise it returns false
     * 
     * @return True if they want to play again, and false otherwise
     */
    private boolean playAgain() {
        while (true) {
            System.out.print("\nDo you want to continue (Y)es or (N)o: ");
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
		TreeDriver cd = new TreeDriver();
		cd.runDriver();
	}
}
