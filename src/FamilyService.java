import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private IFamilyDao familyDao;

    public FamilyService(IFamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        families.stream()
                .map(Family::prettyFormat)
                .forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int size) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() > size)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int size) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < size)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int size) {
        return (int) familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == size)
                .count();
    }

    public void createNewFamily(Human mother, Human father) {
        Family newFamily = new Family(mother, father);
        familyDao.saveFamily(newFamily);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        String name = Math.random() > 0.5 ? maleName : femaleName;
        Human child = new Human(name, family.getFather().getSurname(), System.currentTimeMillis());
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        List<Family> families = familyDao.getAllFamilies();
        long currentTime = System.currentTimeMillis();
        families.forEach(family -> {
            family.getChildren().removeIf(child -> {
                long ageInMillis = currentTime - child.getBirthDate();
                int childAge = (int) (ageInMillis / (365 * 24 * 60 * 60 * 1000L));
                return childAge > age;
            });
            familyDao.saveFamily(family);
        });
    }

    public int count() {
        return familyDao.count();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Pet> getPets(int index) {
        Family family = familyDao.getFamilyByIndex(index);
        if (family != null) {
            return new ArrayList<>(family.getPets());
        }
        return null;
    }

    public void addPet(int index, Pet pet) {
        Family family = familyDao.getFamilyByIndex(index);
        if (family != null) {
            family.getPets().add(pet);
            familyDao.saveFamily(family);
        }
    }

    public void saveFamily(Family family) {
        familyDao.saveFamily(family);
    }
}
