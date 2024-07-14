import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        // Створення домашніх улюбленців
        Set<String> habits1 = new HashSet<>();
        habits1.add("eat");
        habits1.add("drink");
        habits1.add("sleep");

        Set<String> habits2 = new HashSet<>();
        habits2.add("scratch");
        habits2.add("sleep");
        habits2.add("play");

        Set<String> habits3 = new HashSet<>();
        habits3.add("sing");
        habits3.add("swim");

        Set<String> habits4 = new HashSet<>();
        habits4.add("calculate");
        habits4.add("move");

        Pet pet1 = new Dog("Rock", 5, 75, habits1);
        Pet pet2 = new DomesticCat("Whiskers", 3, 60, habits2);
        Pet pet3 = new Fish("Tweety", 2, 80, habits3);
        Pet pet4 = new RoboCat("Robo", 1, 100, habits4);

        // Створення людей
        long birthDate1 = LocalDate.of(1945, 1, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        long birthDate2 = LocalDate.of(1950, 1, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        long birthDate3 = LocalDate.of(1977, 1, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        Man father1 = new Man("Vito", "Karleone", birthDate1);
        Woman mother1 = new Woman("Jane", "Karleone", birthDate2);
        Human otherChild = new Human("Adopted", "Child", "20/03/2016", 120);

        Map<String, String> schedule1 = new HashMap<>();
        schedule1.put(DayOfWeek.MONDAY.name(), "gym");
        schedule1.put(DayOfWeek.TUESDAY.name(), "coding");

        Man child1 = new Man("Michael", "Karleone", 1977, 90, schedule1, null);

        Woman mother2 = new Woman("Sarah", "Connor", 1975);
        Man father2 = new Man("John", "Connor", 1970);

        Map<String, String> schedule2 = new HashMap<>();
        schedule2.put(DayOfWeek.WEDNESDAY.name(), "swimming");
        schedule2.put(DayOfWeek.THURSDAY.name(), "math");

        Man child2 = new Man("Kyle", "Connor", 2000, 85, schedule2, null);

        Map<String, String> schedule3 = new HashMap<>();
        schedule3.put(DayOfWeek.FRIDAY.name(), "painting");
        schedule3.put(DayOfWeek.SUNDAY.name(), "music");

        Woman child3 = new Woman("Kate", "Connor", 2002, 95, schedule3, null);

        // Створення сімей
        Family family1 = new Family(mother1, father1);
        family1.addChild(child1);
        family1.getPets().add(pet1);
        child1.setFamily(family1);

        Family family2 = new Family(mother2, father2);
        family2.addChild(child2);
        family2.addChild(child3);
        family2.getPets().add(pet2);
        family2.getPets().add(pet3);
        child2.setFamily(family2);
        child3.setFamily(family2);

        IFamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        familyController.saveFamily(family1);
        familyController.saveFamily(family2);

        System.out.println("All families:");
        familyController.displayAllFamilies();

        System.out.println("Батько "+ father1.describeAge());
        System.out.println("Мати " + mother1.describeAge());
        System.out.println("Дітина " + child1.describeAge());
        System.out.println("Усиновлена дитина " + otherChild.describeAge());
        Family retrievedFamily = familyController.getFamilyById(0);
        System.out.println("\nRetrieved family by index 0:");
        System.out.println(retrievedFamily);

        boolean isDeleted = familyController.deleteFamilyByIndex(0);
        System.out.println("\nFamily deleted by index 0: " + isDeleted);

        System.out.println("\nAll families after deletion:");
        familyController.displayAllFamilies();

        // Використання методів для дитини та улюбленця
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

        // Створення багатьох об'єктів для запуску збирача сміття
        for (int i = 0; i < 10000; i++) {
            new Human("Test", "Person", 2000 + i);
        }
    }
}
