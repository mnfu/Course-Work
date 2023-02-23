package assignment4;

public class CharacterThree extends Character {
    public CharacterThree() {
        super("I'm tall wish a shiny metal helmet, and have a little green guy to go across space with me", "mandalorian");
    }

    @Override
    public String greeting() {
        return "Su cuy'gar! (Hello!)";
    }

    @Override
    public String getInformation() {
        return "I'm a bounty hunter. It's what I do. The little green guy just happened to fall into my care, that's it.";
    }

    @Override
    public String sayGoodbye() {
        return "Re'turcye mhi (Goodbye)";
    }
}
