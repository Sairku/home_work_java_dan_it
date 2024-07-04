public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, Human mother, Human father) {
        super(name, surname, year, mother, father);
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPet() != null) {
            System.out.println("Привіт, мій милий " + getFamily().getPet().getNickname());
        }
    }

    public void makeup() {
        System.out.println("Я підфарбовуюся!");
    }
}
