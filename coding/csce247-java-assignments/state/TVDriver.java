package state;

import java.util.Scanner;

public class TVDriver {
	private static final String YES = "y";
	private static final String NO = "n";
	private Scanner reader;

	public TVDriver() {
		reader = new Scanner(System.in);
	}

	public void runTV() {
		TV tv = new TV();
		System.out.println("\n******* Let's watch T.V. *******");

		while (true) {
			String option = getText("Press a button: (H)ome, (N)etflix, H(u)lu, (T)V, (M)ovie, (W)atch: ");
			
            if (option.equalsIgnoreCase("h")) {
                tv.pressHomeButton();
			}
			else if (option.equalsIgnoreCase("n")) {
                tv.pressNetflixButton();
			}
			else if (option.equalsIgnoreCase("u")) {
                tv.pressHuluButton();
			}
			else if (option.equalsIgnoreCase("t")) {
                tv.pressTVButton();
			}
			else if (option.equalsIgnoreCase("m")) {
                tv.pressMovieButton();
			}
			else if(option.equalsIgnoreCase("w")){
				String title = getText("Enter Program Title: ");
				tv.watch(title);
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
		TVDriver tvDriver = new TVDriver();
		tvDriver.runTV();
	}
}
