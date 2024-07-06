import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public void greetPet() {
        if (family.getPets() != null) {
            for (Pet pet : family.getPets()) {
                System.out.println("Привіт, " + pet.getNickname());
            }
        }
    }

    public void describePet() {
        if (family.getPets() != null) {
            for (Pet pet : family.getPets()) {
                String trickDescription = pet.getTrickLevel() > 50 ? "дуже хитрий" : "майже не хитрий";
                System.out.println("У мене є " + pet.getSpecies() + ", їй " + pet.getAge() + " років, він " + trickDescription);
            }
        }
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.schedule = new HashMap<>();
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.schedule = new HashMap<>();
        this.family = new Family(mother, father);
    }

    public Human(String name, String surname, int year, int iq, Map<String, String> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is being deleted: " + this);
        super.finalize();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    public boolean equals(Human human) {
        if (this == human) return true;
        if (human == null) return false;
        return year == human.year &&
                iq == human.iq &&
                name.equals(human.name) &&
                surname.equals(human.surname) &&
                schedule.equals(human.schedule) &&
                (family != null ? family.equals(human.family) : human.family == null);
    }

    public int hashCode() {
        int result = name.hashCode();
        result = 23 * result + surname.hashCode();
        result = 23 * result + year;
        result = 23 * result + iq;
        result = 23 * result + schedule.hashCode();
        result = 23 * result + (family != null ? family.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
