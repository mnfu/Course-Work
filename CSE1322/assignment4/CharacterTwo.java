package assignment4;

public class CharacterTwo extends Character {
    public CharacterTwo() {
        super("I'm red and gold, and fly across the sky with my repulsors", "ironman");
    }

    @Override
    public String greeting() {
        return "Hey there kiddo";
    }

    @Override
    public String getInformation() {
        return "I'm a billionaire, a playboy, & a philanthropist.";
    }

    @Override
    public String sayGoodbye() {
        return "I love you 3000";
    }
}
