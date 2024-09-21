import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IFamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            displayMenu();
            command = scanner.nextLine();

            try {
                switch (command) {
                    case "1":
                        populateWithTestData(familyController);
                        System.out.println("Test data created.");
                        break;
                    case "2":
                        familyController.displayAllFamilies();
                        break;
                    case "3":
                        System.out.print("Enter the minimum number of family members: ");
                        int minSize = scanner.nextInt();
                        scanner.nextLine();
                        familyController.getFamiliesBiggerThan(minSize).forEach(family -> System.out.println(family.prettyFormat()));
                        break;
                    case "4":
                        System.out.print("Enter the maximum number of family members: ");
                        int maxSize = scanner.nextInt();
                        scanner.nextLine();
                        familyController.getFamiliesLessThan(maxSize).forEach(family -> System.out.println(family.prettyFormat()));
                        break;
                    case "5":
                        System.out.print("Enter the exact number of family members: ");
                        int exactSize = scanner.nextInt();
                        scanner.nextLine();
                        long count = familyController.countFamiliesWithMemberNumber(exactSize);
                        System.out.println("Number of families with " + exactSize + " members: " + count);
                        break;
                    case "6":
                        try {
                            Human mother = readHumanDetails(scanner, "mother");
                            Human father = readHumanDetails(scanner, "father");
                            familyController.createNewFamily(mother, father);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please try again.");
                            scanner.nextLine();
                        }
                        break;
                    case "7":
                        System.out.print("Enter the index of the family to delete: ");
                        int indexToDelete = scanner.nextInt();
                        scanner.nextLine();
                        boolean success = familyController.deleteFamilyByIndex(indexToDelete);
                        if (success) {
                            System.out.println("Family deleted successfully.");
                        } else {
                            System.out.println("Failed to delete family. Invalid index.");
                        }
                        break;
                    case "8":
                        System.out.print("Enter the index of the family to edit: ");
                        int indexToEdit = scanner.nextInt();
                        scanner.nextLine();
                        editFamily(scanner, familyController, indexToEdit);
                        break;
                    case "9":
                        System.out.print("Enter the age threshold: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        familyController.deleteAllChildrenOlderThan(age);
                        System.out.println("All children older than " + age + " have been deleted.");
                        break;
                    case "11":

                        populateWithTestData(familyController);
                        break;
                    case "12":

                        familyController.displayAllFamilies();
                        break;
                    case "13":

                        familyService.saveData();
                        break;
                    case "14":

                        familyService.loadData();
                        break;







                    case "exit":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } catch (FamilyOverflowException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!command.equals("exit"));
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Fill with test data");
        System.out.println("2. Display all families");
        System.out.println("3. Display families with more than a certain number of members");
        System.out.println("4. Display families with less than a certain number of members");
        System.out.println("5. Count families with a certain number of members");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete family by index");
        System.out.println("8. Edit family by index");
        System.out.println("9. Delete all children older than a certain age");
        System.out.println("11. Generate data");
        System.out.println("12. Display all fam");
        System.out.println("13. Save data");
        System.out.println("14. Load data");
        System.out.println("Type 'exit' to quit");
        System.out.print("Enter command: ");
    }

    private static void populateWithTestData(FamilyController familyController) {
        Human mother1 = new Human("Jane", "Doe", "01/01/1980", 100);
        Human father1 = new Human("John", "Doe", "01/01/1975", 100);
        Family family1 = new Family(mother1, father1);
        familyController.saveFamily(family1); // Family with 2 members

        Human mother2 = new Human("Sarah", "Connor", "01/01/1975", 95);
        Human father2 = new Human("Kyle", "Connor", "01/01/1970", 90);
        Family family2 = new Family(mother2, father2);
        Human child1 = new Human("Michael", "Connor", "01/01/2000", 90);
        family2.addChild(child1);
        familyController.saveFamily(family2); // Family with 3 members

        Human mother3 = new Human("Linda", "Smith", "01/01/1978", 85);
        Human father3 = new Human("Tom", "Smith", "01/01/1975", 88);
        Family family3 = new Family(mother3, father3);
        Human child2 = new Human("Anna", "Smith", "01/01/2002", 92);
        Human child3 = new Human("Lisa", "Smith", "01/01/2005", 89);
        family3.addChild(child2);
        family3.addChild(child3);
        familyController.saveFamily(family3); // Family with 4 members

        Human mother4 = new Human("Emily", "Brown", "01/01/1982", 97);
        Human father4 = new Human("David", "Brown", "01/01/1980", 94);
        Family family4 = new Family(mother4, father4);
        Human child4 = new Human("James", "Brown", "01/01/2010", 88);
        family4.addChild(child4);
        Pet pet1 = new Dog("Buddy", 3, 50, new HashSet<>(Arrays.asList("bark", "fetch")));
        family4.getPets().add(pet1);
        familyController.saveFamily(family4); // Family with 4 members including a pet
    }

    private static Human readHumanDetails(Scanner scanner, String role) {
        System.out.println("Enter " + role + " details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Birth year: ");
        int year = scanner.nextInt();
        System.out.print("Birth month: ");
        int month = scanner.nextInt();
        System.out.print("Birth day: ");
        int day = scanner.nextInt();
        System.out.print("IQ: ");
        int iq = scanner.nextInt();
        scanner.nextLine(); // consume newline

        LocalDate birthDate = LocalDate.of(year, month, day);
        long birthDateMillis = birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        return new Human(name, surname, birthDateMillis, iq);
    }

    private static void editFamily(Scanner scanner, FamilyController familyController, int indexToEdit) {
        System.out.println("Editing family at index " + indexToEdit);
        System.out.println("1. Born a child");
        System.out.println("2. Adopt a child");
        System.out.println("3. Go back to main menu");
        System.out.print("Enter command: ");
        String command = scanner.nextLine();

        switch (command) {
            case "1":
                System.out.print("Enter boy's name: ");
                String boyName = scanner.nextLine();
                System.out.print("Enter girl's name: ");
                String girlName = scanner.nextLine();
                Family familyToBorn = familyController.getFamilyById(indexToEdit);
                if (familyToBorn != null) {
                    familyController.bornChild(familyToBorn, boyName, girlName);
                    System.out.println("Child born successfully.");
                } else {
                    System.out.println("Invalid family index.");
                }
                break;
            case "2":
                try {
                    Human adoptedChild = readHumanDetails(scanner, "adopted child");
                    Family familyToAdopt = familyController.getFamilyById(indexToEdit);
                    if (familyToAdopt != null) {
                        familyController.adoptChild(familyToAdopt, adoptedChild);
                        System.out.println("Child adopted successfully.");
                    } else {
                        System.out.println("Invalid family index.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // clear the invalid input
                }
                break;
            case "3":
                System.out.println("Returning to main menu.");
                break;
            default:
                System.out.println("Invalid command. Please try again.");
        }
    }
}
