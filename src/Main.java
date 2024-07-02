import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Створення домашніх улюбленців
        Pet pet1 = new Pet(Species.DOG , "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        Pet pet2 = new Pet(Species.CAT, "Whiskers", 3, 60, new String[]{"scratch", "sleep", "play"});
        Pet pet3 = new Pet(Species.BIRD, "Tweety", 2, 80, new String[]{"sing", "fly"});

        // Створення людей
        Human mother1 = new Human("Jane", "Karleone", 1950);
        Human father1 = new Human("Vito", "Karleone", 1945);
        Human child1 = new Human("Michael", "Karleone", 1977, 90, new String[][]{{DayOfWeek.MONDAY.name(), "gym"}, {DayOfWeek.TUESDAY.name(), "coding"}}, null);

        Human mother2 = new Human("Sarah", "Connor", 1975);
        Human father2 = new Human("John", "Connor", 1970);
        Human child2 = new Human("Kyle", "Connor", 2000, 85, new String[][]{{DayOfWeek.WEDNESDAY.name(), "swimming"}, {DayOfWeek.THURSDAY.name(), "math"}}, null);
        Human child3 = new Human("Kate", "Connor", 2002, 95, new String[][]{{DayOfWeek.FRIDAY.name(), "painting"}, {DayOfWeek.SUNDAY.name(), "music"}}, null);

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
        pet1.foul();
        System.out.println(pet1);

        for (int i = 0; i < 10000; i++) {
            new Human("Test", "Person", 2000 + i);
        }
    }
}