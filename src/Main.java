public class Main {
    public static void main(String[] args) {
        // Створення домашніх улюбленців
        Pet pet1 = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        Pet pet2 = new DomesticCat("Whiskers", 3, 60, new String[]{"scratch", "sleep", "play"});
        Pet pet3 = new Fish("Tweety", 2, 80, new String[]{"sing", "swim"});
        Pet pet4 = new RoboCat("Robo", 1, 100, new String[]{"calculate", "move"});

        // Створення людей
        Man father1 = new Man("Vito", "Karleone", 1945);
        Woman mother1 = new Woman("Jane", "Karleone", 1950);
        Man child1 = new Man("Michael", "Karleone", 1977, 90, new String[][]{
                {DayOfWeek.MONDAY.name(), "gym"},
                {DayOfWeek.TUESDAY.name(), "coding"}
        }, null);

        Woman mother2 = new Woman("Sarah", "Connor", 1975);
        Man father2 = new Man("John", "Connor", 1970);
        Man child2 = new Man("Kyle", "Connor", 2000, 85, new String[][]{
                {DayOfWeek.WEDNESDAY.name(), "swimming"},
                {DayOfWeek.THURSDAY.name(), "math"}
        }, null);
        Woman child3 = new Woman("Kate", "Connor", 2002, 95, new String[][]{
                {DayOfWeek.FRIDAY.name(), "painting"},
                {DayOfWeek.SUNDAY.name(), "music"}
        }, null);

        // Створення сімей
        Family family1 = new Family(mother1, father1);
        family1.addChild(child1);
        family1.setPet(pet1);
        child1.setFamily(family1);

        Family family2 = new Family(mother2, father2);
        family2.addChild(child2);
        family2.addChild(child3);
        family2.setPet(pet3);
        child2.setFamily(family2);
        child3.setFamily(family2);

        System.out.println("Family 1:");
        System.out.println(family1);
        System.out.println("Members:");
        System.out.println(mother1);
        System.out.println(father1);
        System.out.println(child1);

        System.out.println("\nFamily 2:");
        System.out.println(family2);
        System.out.println("Members:");
        System.out.println(mother2);
        System.out.println(father2);
        System.out.println(child2);
        System.out.println(child3);

        System.out.println("\nMethods for child1 and pet1:");
        child1.greetPet();
        child1.describePet();
        System.out.println(child1);

        pet1.eat();
        pet1.respond();
        if (pet1 instanceof Foul) {
            ((Foul) pet1).foul();
        }
        System.out.println(pet1);

        father1.repairCar();
        mother1.makeup();

        for (int i = 0; i < 10000; i++) {
            new Human("Test", "Person", 2000 + i);
        }
    }
}
