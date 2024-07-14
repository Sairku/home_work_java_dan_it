import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, long birthDate, Human mother, Human father) {
        super(name, surname, birthDate, mother, father);
    }

    public Man(String name, String surname, long birthDate, int iq, Map<String, String> schedule, Family family) {
        super(name, surname, birthDate, iq, schedule, family);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPets() != null) {
            for (Pet pet : getFamily().getPets()) {
                System.out.println("Привіт, друже " + pet.getNickname());
            }
        }
    }

    public void repairCar() {
        System.out.println("Я лагоджу машину!");
    }
}
