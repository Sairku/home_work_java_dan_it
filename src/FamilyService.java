import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
        familyDao.getAllFamilies().forEach(family ->
                System.out.println(familyDao.getAllFamilies().indexOf(family) + ": " + family));
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

    public long countFamiliesWithMemberNumber(int size) {
        return familyDao.getAllFamilies().stream()
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
        Human child = new Human(name, family.getFather().getSurname(), LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
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
        familyDao.getAllFamilies().forEach(family -> {
            family.getChildren().removeIf(child -> {
                LocalDate birthDate = Instant.ofEpochMilli(child.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate();
                return Period.between(birthDate, LocalDate.now()).getYears() > age;
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
            return family.getPets().stream().collect(Collectors.toList());
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
