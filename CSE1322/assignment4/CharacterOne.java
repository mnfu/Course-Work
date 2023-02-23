package assignment4;

public class CharacterOne extends Character {
    public CharacterOne() {
        super("I'm fluffy, funny, & always looking for a taco truck", "gabrieliglesias");
    }

    @Override
    public String greeting() {
        return "How are you doin tonight?";
    }

    @Override
    public String getInformation() {
        return "Well, I've had a pretty successful career i'd say, made a lot of people laugh. I also own a LOT of VW vans!";
    }

    @Override
    public String sayGoodbye() {
        return "Have a good night!";
    }
}
