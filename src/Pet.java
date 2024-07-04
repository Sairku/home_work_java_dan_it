import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class Pet {

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public void eat (){
        System.out.println("Я ї'м!");
    }

    public abstract void respond();

    public void foul (){
        System.out.println("Потрібно добре замести сліди...");
    }


    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object is being deleted: " + this);
        super.finalize();
    }

    public Pet(String nickname ){
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
    }
    public Pet(String nickname, int age, int trickLevel,String[] habits ){
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet(){this.species = Species.UNKNOWN;};

    public boolean equals(Pet pet) {
        if (this == pet) return true;
        if (pet == null) return false;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                species.equals(pet.species) &&
                nickname.equals(pet.nickname) &&
                Arrays.equals(habits, pet.habits);
    }

    public int hashCode() {
        int result = species.hashCode();
        result = 23 * result + nickname.hashCode();
        result = 23 * result + age;
        result = 23 * result + trickLevel;
        result = 23 * result + Arrays.hashCode(habits);
        return result;
    }

    public Species getSpecies(){
        return species;
    }
    public void setSpecies(Species species) {
        this.species = species;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getTrickLevel() {
        return trickLevel;
    }
    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }
    public String[] getHabits() {
        return habits;
    }
    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    }

