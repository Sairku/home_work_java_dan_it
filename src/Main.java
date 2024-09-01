import java.time.LocalDate;
import java.time.ZoneId;
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
                        // Заповнити тестовими даними
                        populateWithTestData(familyController);
                        System.out.println("Test data created.");
                        familyController.displayAllFamilies();
                        break;
                    case "2":
                        // Відобразити весь список сімей
                        familyController.displayAllFamilies();
                        break;
                    case "3":
                        // Відобразити список сімей, де кількість людей більша за задану
                        System.out.print("Enter the minimum number of family members: ");
                        int minSize = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        familyController.getFamiliesBiggerThan(minSize).forEach(family -> System.out.println(family.prettyFormat()));
                        break;
                    case "4":
                        // Відобразити список сімей, де кількість людей менша за задану
                        System.out.print("Enter the maximum number of family members: ");
                        int maxSize = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        familyController.getFamiliesLessThan(maxSize).forEach(family -> System.out.println(family.prettyFormat()));
                        break;
                    case "5":
                        // Підрахувати кількість сімей, де кількість членів дорівнює
                        System.out.print("Enter the exact number of family members: ");
                        int exactSize = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        long count = familyController.countFamiliesWithMemberNumber(exactSize);
                        System.out.println("Number of families with " + exactSize + " members: " + count);
                        break;
                    case "6":
                        // Створити нову родину
                        try {
                            Human mother = readHumanDetails(scanner, "mother");
                            Human father = readHumanDetails(scanner, "father");
                            familyController.createNewFamily(mother, father);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please try again.");
                            scanner.nextLine(); // clear the invalid input
                        }
                        break;
                    case "7":
                        // Видалити сім'ю за індексом сім'ї у загальному списку
                        System.out.print("Enter the index of the family to delete: ");
                        int indexToDelete = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        boolean success = familyController.deleteFamilyByIndex(indexToDelete);
                        if (success) {
                            System.out.println("Family deleted successfully.");
                        } else {
                            System.out.println("Failed to delete family. Invalid index.");
                        }
                        break;
                    case "8":
                        // Редагувати сім'ю за індексом сім'ї у загальному списку
                        System.out.print("Enter the index of the family to edit: ");
                        int indexToEdit = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        editFamily(scanner, familyController, indexToEdit);
                        break;
                    case "9":
                        // Видалити всіх дітей старше віку
                        System.out.print("Enter the age threshold: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        familyController.deleteAllChildrenOlderThan(age);
                        System.out.println("All children older than " + age + " have been deleted.");
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
        System.out.println("Type 'exit' to quit");
        System.out.print("Enter command: ");
    }

    private static void populateWithTestData(FamilyController familyController) {
        // Create test data
        Human mother1 = new Human("Jane", "Doe", "01/01/1980", 100);
        Human father1 = new Human("John", "Doe", "01/01/1975", 100);
        Family family1 = new Family(mother1, father1);
        familyController.saveFamily(family1);

        Human mother2 = new Human("Sarah", "Connor", "01/01/1975", 95);
        Human father2 = new Human("Kyle", "Connor", "01/01/1970", 90);
        Family family2 = new Family(mother2, father2);
        familyController.saveFamily(family2);

        System.out.println("Test data created.");
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
