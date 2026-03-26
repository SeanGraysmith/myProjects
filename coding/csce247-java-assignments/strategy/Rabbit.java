package strategy;

public class Rabbit extends Animal {

    public Rabbit(String name) {
        super(name);

        character.add(" \\\\");
        character.add("  \\\\");
        character.add("  ( _\\");
        character.add("  / \\__");
        character.add(" / _/`\"`");
        character.add("{\\  )_");

        this.moveBehavior = new JumpBehavior(character, 2);
    }

}
