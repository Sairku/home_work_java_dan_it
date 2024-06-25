import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public void greetPet() {
        if (family.getPet() != null) {
            System.out.println("Привіт, " + family.getPet().getNickname());
        }
    }

    public void describePet() {
        if (family.getPet() != null) {
            String trickDescription = family.getPet().getTrickLevel() > 50 ? "дуже хитрий" : "майже не хитрий";
            System.out.println("У мене є " + family.getPet().getSpecies() + ", їй " + family.getPet().getAge() + " років, він " + trickDescription);
        }
    }
    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = new Family(mother, father);
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    @Override
    public String toString() {
        String motherName = family != null && family.getMother() != null ? family.getMother().getName() : "no mother";
        String fatherName = family != null && family.getFather() != null ? family.getFather().getName() : "no father";
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + arrayToString(schedule) +
                ", mother='" + motherName + '\'' +
                ", father='" + fatherName + '\'' +
                '}';
    }
    private String arrayToString(String[][] array) {
        if (array == null) return "null";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("[").append(String.join(", ", array[i])).append("]");
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Human human) {
        if (this == human) return true;
        if (human == null) return false;
        return year == human.year &&
                iq == human.iq &&
                name.equals(human.name) &&
                surname.equals(human.surname) &&
                Arrays.equals(schedule, human.schedule) &&
                (family != null ? family.equals(human.family) : human.family == null);
    }

    public int hashCode() {
        int result = name.hashCode();
        result = 23 * result + surname.hashCode();
        result = 23 * result + year;
        result = 23 * result + iq;
        result = 23 * result + Arrays.hashCode(schedule);
        result = 23 * result + (family != null ? family.hashCode() : 0);
        return result;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
            this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public  int getIq(){
        return iq;
    }
    public void setIq(int iq){
        this.iq = iq;
    }
    public String[][] getSchedule(){
        return schedule;
    }
    public void setSchedule(String[][] schedule){
        this.schedule = schedule;
    }
    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

}
