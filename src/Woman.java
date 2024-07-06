import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, Human mother, Human father) {
        super(name, surname, year, mother, father);
    }

    public Woman(String name, String surname, int year, int iq, Map<String, String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
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
