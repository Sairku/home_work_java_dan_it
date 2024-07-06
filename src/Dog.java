import java.util.Set;

public class Dog extends Pet implements Foul {
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, хазяїн. Я - " + getNickname() + ". Я скучив!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}
