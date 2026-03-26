package strategy;

public class Elephant extends Animal {

    public Elephant(String name) {
        super(name);

        character.add("        /  \\~~~/  \\");
        character.add("  ,----(     ..    )");
        character.add(" /      \\__     __/");
        character.add("/|         (\\  |(");
        character.add("^ \\   /___\\  /\\ | ");
        character.add("  |__|   |__|-\"    ");
        character.add("");
        this.moveBehavior = new WalkBehavior(character, 1
        );







        
    }
}
