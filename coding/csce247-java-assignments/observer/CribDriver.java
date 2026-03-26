package observer;

import java.util.ArrayList;
import java.util.Scanner;

public class CribDriver {
	private static final String YES = "y";
	private static final String NO = "n";
	private Scanner reader;

	public CribDriver() {
		reader = new Scanner(System.in);
	}

	public void run() {
		int numBabies = getInt("How many babies do you have? ");

		if(numBabies <= 0){
			System.out.println("Sorry this is an invalid number of babies.");
			return;
		}

		ArrayList<Baby> babies = new ArrayList<Baby>();

		for(int i=0; i < numBabies; i++){
			String babyName = getText("Enter Babie " + (i+1) + "'s Name: ");
			babies.add(new Baby(babyName));
		}
		
		Observer dad = new Dad(babies);
		Observer mom = new Mom(babies);
		
		System.out.println("\n***** Babies were put down in their crib. *****\n");

		while (true) {
			int cryNum = getInt("What type of cry does the baby make: \n1. Angry\n2. Hungry\n3. Wet\n");

			System.out.println("Which baby");
			int count = 1;
			for(Baby baby : babies){
				System.out.println(count + ". " + baby.getName());
				count++;
			}

			int babyNum = getInt("Enter baby number: ") - 1;

			if(babyNum < 0 || babyNum >= babies.size())
			{
				System.out.println("Invalid baby number.");
				continue;
			}

			Baby baby = babies.get(babyNum);

            if (cryNum == 1) {
                baby.angryCry();
            } else if(cryNum == 2){
				baby.hungryCry();
			} else if(cryNum == 3){
				baby.wetCry();
			} else {
				System.out.println("invalid command");
			}

            if (!playAgain()) {
                break;
            }
        }

        reader.close();
        System.out.println("Goodbye");
	}

	private int getInt(String prompt) {
		int num = 0;
		System.out.print(prompt);

		try {
			num = Integer.valueOf(reader.nextLine().trim());
		} catch(Exception e){
			return -1;
		}

		return num;
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
		CribDriver driver = new CribDriver();
		driver.run();
	}
}
