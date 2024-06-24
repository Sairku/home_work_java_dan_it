import java.util.Arrays;

public class Pet {

    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public void eat (){
        System.out.println("Я ї'м!");
    }
    public void respond(){
        System.out.println("Привіт, хазяїн. Я -" + nickname +". Я скучив!");
    }
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

    public Pet(String species, String nickname ){
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(String species,String nickname, int age, int trickLevel,String[] habits ){
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet(){};

    // Getter and Setters
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String species) {
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
