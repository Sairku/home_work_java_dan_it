public final class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, Human mother, Human father) {
        super(name, surname, year, mother, father);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPet() != null) {
            System.out.println("Привіт, друже " + getFamily().getPet().getNickname());
        }
    }

    public void repairCar() {
        System.out.println("Я лагоджу машину!");
    }
}

