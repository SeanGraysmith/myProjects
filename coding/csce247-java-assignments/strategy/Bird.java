package strategy;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
        character.add("     __");
        character.add("   /.__.\\");
        character.add("   \\ \\/ /");
        character.add("'__/    \\");
        character.add(" \\-      )");
        character.add("  \\_____/");
        character.add("    | |");
        character.add("    \" \"");

        this.moveBehavior = new JumpBehavior(character, 1);
    }

}
