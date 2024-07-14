import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, long birthDate, Human mother, Human father) {
        super(name, surname, birthDate, mother, father);
    }

    public Woman(String name, String surname, long birthDate, int iq, Map<String, String> schedule, Family family) {
        super(name, surname, birthDate, iq, schedule, family);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPets() != null) {
            for (Pet pet : getFamily().getPets()) {
                System.out.println("Привіт, мій милий " + pet.getNickname());
            }
        }
    }

    public void makeup() {
        System.out.println("Я підфарбовуюся!");
    }
}
