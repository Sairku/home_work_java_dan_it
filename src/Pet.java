import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public void eat (){
        System.out.println("Я ї'м!");
    }

    public abstract void respond();

    public void foul (){
        System.out.println("Потрібно добре замести сліди...");
    }

    @Override
    public String toString() {
        return String.format("{species=%s, nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species, nickname, age, trickLevel, habits);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object is being deleted: " + this);
        super.finalize();
    }

    public Pet(Species species, String nickname){
        this.species = species != null ? species : Species.UNKNOWN;
        this.nickname = nickname;
    }
    public Pet(String nickname, int age, int trickLevel,Set<String> habits ){
        this.species = species != null ? species : Species.UNKNOWN;
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
                habits.equals(pet.habits);
    }

    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, habits);
    }

    public String prettyFormat() {
        return String.format("{species=%s, nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species, nickname, age, trickLevel, habits.stream().collect(Collectors.joining(", ")));
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
    public Set<String> getHabits() {
        return habits;
    }
    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }


}

