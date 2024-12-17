import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public Human(String name, String surname, String birthDateString, int iq) {
        this.name = name;
        this.surname = surname;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        this.birthDate = birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        this.iq = iq;
        this.schedule = new HashMap<>();
    }

public Human(String name, String surname, long birthDate, int iq){
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.iq = iq;
    }

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

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.schedule = new HashMap<>();
    }

    public Human(String name, String surname, long birthDate, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.schedule = new HashMap<>();
        this.family = new Family(mother, father);
    }

    public Human(String name, String surname, long birthDate, int iq, Map<String, String> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public String describeAge(){
        LocalDate birthDate = Instant.ofEpochMilli(this.birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        return String.format("Вік: %d років, %d місяців, %d днів", Period.between(birthDate, now).getYears(),
                Period.between(birthDate, now).getMonths(), Period.between(birthDate, now).getDays());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is being deleted: " + this);
        super.finalize();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = Instant.ofEpochMilli(this.birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        String formattedDate = birthDate.format(formatter);
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + formattedDate +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }
    public String prettyFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDateLocal = Instant.ofEpochMilli(this.birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        String formattedDate = birthDateLocal.format(formatter);

        return String.format("{name='%s', surname='%s', birthDate='%s', iq=%d, schedule=%s}",
                name, surname, formattedDate, iq, schedule);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return birthDate == human.birthDate &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(schedule, human.schedule) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, schedule, family);
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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
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
