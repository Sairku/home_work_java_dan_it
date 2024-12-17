import java.util.List;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyService.getFamiliesLessThan(count);
    }

    public long countFamiliesWithMemberNumber(int count) {
        return familyService.countFamiliesWithMemberNumber(count);
    }

    public void createNewFamily(Human mother, Human father) {
        familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        if (family.countFamily() > 10) {
            throw new FamilyOverflowException("Розмір сім'ї перевищує 10 членів.");
        }
        return familyService.bornChild(family, maleName, femaleName);
    }

    public Family adoptChild(Family family, Human child) {
        if (family.countFamily() > 10) {
            throw new FamilyOverflowException("Розмір сім'ї перевищує 10 членів.");
        }
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public List<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }

    public void saveFamily(Family family) {
        familyService.saveFamily(family);
    }
}
