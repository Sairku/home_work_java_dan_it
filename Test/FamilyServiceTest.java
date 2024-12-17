import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyServiceTest {
    private FamilyService familyService;
    private IFamilyDao familyDao;
    private Human mother;
    private Human father;
    private Family family;

    @BeforeEach
    public void setUp() {
        familyDao = new CollectionFamilyDao();
        familyService = new FamilyService(familyDao);

        mother = new Woman("Jane", "Doe", 1980);
        father = new Man("John", "Doe", 1975);
        family = new Family(mother, father);

        familyService.createNewFamily(mother, father);
    }

    @Test
    public void testCountFamiliesWithMemberNumber() {
        family.addChild(new Human("Anna", "Doe", 2005));
        familyService.saveFamily(family);

        long count = familyService.countFamiliesWithMemberNumber(3);
        assertEquals(0, count);
    }

    @Test
    public void testBornChild() {
        Family updatedFamily = familyService.bornChild(family, "Michael", "Michelle");
        assertEquals(3, updatedFamily.countFamily());
        assertNotNull(updatedFamily.getChildren().get(0));
    }

    @Test
    public void testAdoptChild() {
        Human adoptedChild = new Human("Tom", "Doe", 2010);
        Family updatedFamily = familyService.adoptChild(family, adoptedChild);
        assertEquals(3, updatedFamily.countFamily());
        assertEquals(adoptedChild, updatedFamily.getChildren().get(0));
    }

    @Test
    public void testDeleteAllChildrenOlderThan() {
        family.addChild(new Human("Anna", "Doe", 2000));
        family.addChild(new Human("Tom", "Doe", 2010));
        familyService.saveFamily(family);

        familyService.deleteAllChildrenOlderThan(15);
        assertEquals(2, family.getChildren().size());
    }

    @Test
    public void testCount() {
        int count = familyService.count();
        assertEquals(0, count);
    }

}
